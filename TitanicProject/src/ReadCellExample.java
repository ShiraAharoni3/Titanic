import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openxmlformats.schemas.drawingml.x2006.main.impl.STTextIndentLevelTypeImpl;

public class ReadCellExample
{

    public List<Passenger> createPassenger()
    {
        Workbook wbook = null;           //initialize Workbook null
        try {
            //reading data from a file in the form of bytes
            FileInputStream fis = new FileInputStream(Constants.PATH_TO_DATA_FILE );
            //constructs an XSSFWorkbook object, by buffering the whole stream into the memory
            wbook = new XSSFWorkbook(fis);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e1) {
            e1.printStackTrace();
        }

        Cell rdCell = null ;
        List<Passenger> passengerList = new ArrayList<>() ;
        for( int i = 1 ; i < 892 ; i++)
        {
            Passenger passenger = new Passenger
             (
                    readNumricCell(GetCellType(i, Fixed.PASSENGER_COLUMN , wbook )),
                    readNumricCell(GetCellType(i, Fixed.SURVIVED_COLUMN, wbook)),
                    readNumricCell(GetCellType(i, Fixed.P_CLASS_COLUMN , wbook)),
                    readStringCell(GetCellType(i, Fixed.NAME_COLUMN , wbook)),
                    readStringCell(GetCellType(i, Fixed.SEX_COLUMN , wbook )),
                    readNumricCell(GetCellType(i, Fixed.AGE_COLUMN , wbook)),
                    readNumricCell(GetCellType(i, Fixed.SIBSP_COLUMN , wbook)),
                    readNumricCell(GetCellType(i, Fixed.PARCH_COLUMN , wbook)),
                    readStringCell(GetCellType(i, Fixed.TICKET_COLUMN , wbook)),
                    readNumricCell(GetCellType(i, Fixed.FARE_COLUMN , wbook)),
                    readStringCell(GetCellType(i, Fixed.CABIN_COLUMN , wbook)),
                    readStringCell(GetCellType(i, Fixed.EMBARKED_COLUMN , wbook))
             );
            passengerList.add(passenger);

            //System.out.println( " ");
            for( int j = 0 ; j < 12 ; j++ )
            {
                rdCell=  GetCellType(i,  j , wbook);
                if( rdCell != null )
                {
                    CellType typeCell = rdCell.getCellTypeEnum();
                    if( typeCell == CellType.STRING  )
                    {
                        readStringCell( rdCell ) ;
                    }
                    else if( typeCell ==  CellType.NUMERIC)
                    {
                        readNumricCell( rdCell ) ;
                    }
                }

            }

        }

        return passengerList ;
    }

    public  Cell GetCellType(int vRow, int vColumn , Workbook wb ) {
/*
        Workbook wb = null;           //initialize Workbook null
        try {
            //reading data from a file in the form of bytes
            FileInputStream fis = new FileInputStream(Constants.PATH_TO_DATA_FILE );
            //constructs an XSSFWorkbook object, by buffering the whole stream into the memory
            wb = new XSSFWorkbook(fis);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e1) {
            e1.printStackTrace();
        }

 */
        Sheet sheet = wb.getSheetAt(0);   //getting the XSSFSheet object at given index
        Row row = sheet.getRow(vRow); //returns the logical row
        Cell cell = row.getCell(vColumn); //getting the cell representing the given column
        Cell Temp = null;

        return cell;
    }

    public String readStringCell( Cell cell ) {
        String StringValue = "" ;
        if (cell != null) {
            CellType typeCell = cell.getCellTypeEnum();

            if (typeCell == CellType.STRING) {
                StringValue = String.valueOf((cell.getStringCellValue()));//getting cell value
                if (StringValue == null) {
                    //System.out.print(" ");
                } else {
                    //System.out.print(StringValue + " ");
                }
            }
        }
        return StringValue;
    }

    public double readNumricCell( Cell cell ) {
        double NumericValue = -1 ;
        if (cell != null) {
            CellType typeCell = cell.getCellTypeEnum();
              if (typeCell ==  CellType.NUMERIC) {
                NumericValue = cell.getNumericCellValue();
                if (NumericValue == 0) {
                    //System.out.print(0 + " ");
                } else {
                   // System.out.print(NumericValue + " ");
                }
            }
        }
        return NumericValue ;
    }

}

