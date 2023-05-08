import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class ManageScreen extends JPanel
 {
     private JComboBox<String> survivedComboBox;
     private JComboBox<String> survivedComboBoxSex;
     private JComboBox<String> survivedComboBoxEmbarked;
     private JComboBox<String> passengerName ;
     private Image backgroundImage;
     String PassengerName;
     int MinPassengerNumber  ;
     int MaxPassengerNumber ;
     String PassengerSex;
     int PassengerClassNumber ;
     int PassengerSibSpNumber ;
     double MinTicketCost  ;
     double MaxTicketCost  ;
     int PassengerCabin ;
     String Embarked ;
     int PassengerParchNumber  ;
     int PassengerTicket ;

        public ManageScreen(int x, int y, int width, int height)
        {
            File file = new File(Constants.PATH_TO_DATA_FILE);
            ReadCellExample rc = new ReadCellExample();//object of the class
            List<Passenger> passengerListSource = new ArrayList<>() ;
            String name = null ;
            passengerListSource = rc.createPassenger();
            /*Image backgroundImage = new Image(new FileInputStream("C:\\Users\\משתמש\\OneDrive\\Git Ripositories\\src\\data\\TITANIC3_i.jpg"));

            // Create an ImageView for the background image
            ImageView backgroundImageView = new ImageView(backgroundImage);
            backgroundImageView.setFitWidth(800);
            backgroundImageView.setFitHeight(600);*/
            /*try {
                backgroundImage = ImageIO.read(Objects.requireNonNull(getClass().getResource("C:\\Users\\משתמש\\OneDrive\\Git Ripositories\\src\\data\\TITANIC3_i.jpg")));
            } catch (NullPointerException ex) {
                ex.printStackTrace();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }*/

            if (file.exists())
            {

                //BackgroundImage picture = new BackgroundImage();

                //Image image = ImageIO.read(new File()) ;

                this.setLayout(null);
                this.setBounds(x, y + Constants.FIRST_LINE_MARGIN_FROM_TOP, width, height);
                JLabel survivedLabel = new JLabel("Passenger Class: ");
                survivedLabel.setBounds(x + Constants.FIRST_LINE_MARGIN_FROM_LEFT, y, Constants.LABEL_WIDTH, Constants.LABEL_HEIGHT);
                this.add(survivedLabel);
                this.survivedComboBox = new JComboBox<>(Constants.PASSENGER_CLASS_OPTIONS);
                this.survivedComboBox.setBounds(survivedLabel.getX()  + survivedLabel.getWidth() + 10, survivedLabel.getY(), Constants.COMBO_BOX_WIDTH, Constants.COMBO_BOX_HEIGHT);
                this.add(this.survivedComboBox);
                this.survivedComboBox.addActionListener((e) -> {
                    String ClassNumber = this.survivedComboBox.getItemAt(this.survivedComboBox.getSelectedIndex());
                    if (ClassNumber.equals(Constants.PASSENGER_CLASS_OPTIONS[1])) {
                        this.PassengerClassNumber = 1;
                    } else if (ClassNumber.equals(Constants.PASSENGER_CLASS_OPTIONS[2])) {
                        this.PassengerClassNumber = 2;
                    } else if (ClassNumber.equals(Constants.PASSENGER_CLASS_OPTIONS[3])) {
                        this.PassengerClassNumber = 3;
                    } else if (ClassNumber.equals(Constants.PASSENGER_CLASS_OPTIONS[0])) {
                        this.PassengerClassNumber = 0;
                    }
                    System.out.println((this.PassengerClassNumber));
                });
                JLabel survivedSexLabel = new JLabel("Passenger sex: ");
                survivedSexLabel.setBounds(x + Constants.FIRST_LINE_MARGIN_FROM_LEFT , Constants.SECOND_LINE_MARGIN_FROM_TOP, Constants.LABEL_WIDTH, Constants.LABEL_HEIGHT);
                this.add(survivedSexLabel);
                this.survivedComboBoxSex = new JComboBox<>(Constants.PASSENGER_SEX_OPTIONS);
                this.survivedComboBoxSex.setBounds(survivedLabel.getX() +  survivedLabel.getWidth() + 10, Constants.SECOND_LINE_MARGIN_FROM_TOP, Constants.COMBO_BOX_WIDTH, Constants.COMBO_BOX_HEIGHT);
                this.add(this.survivedComboBoxSex);
                this.survivedComboBoxSex.addActionListener((e) -> {
                    String sex = this.survivedComboBoxSex.getItemAt(this.survivedComboBoxSex.getSelectedIndex());
                    if (sex.equals(Constants.PASSENGER_SEX_OPTIONS[0])) {
                        PassengerSex = null;
                    } else if (sex.equals(Constants.PASSENGER_SEX_OPTIONS[1])) {
                        PassengerSex = "male";
                    }
                    else if (sex.equals(Constants.PASSENGER_SEX_OPTIONS[2])) {
                        PassengerSex = "female";
                    }
                    System.out.println((PassengerSex));
                });
                JLabel survivedEmbarkedLabel = new JLabel("Passenger embarked: ");
                survivedEmbarkedLabel.setBounds(x + Constants.FIRST_LINE_MARGIN_FROM_LEFT  , Constants.THIRD_LINE_MARGIN_FROM_TOP, Constants.LABEL_WIDTH, Constants.LABEL_HEIGHT);
                this.add(survivedEmbarkedLabel);
                this.survivedComboBoxEmbarked = new JComboBox<>(Constants.PASSENGER_EMBARKED_OPTIONS);
                this.survivedComboBoxEmbarked.setBounds(survivedLabel.getX() + survivedLabel.getWidth() + 20,  Constants.THIRD_LINE_MARGIN_FROM_TOP , Constants.COMBO_BOX_WIDTH, Constants.COMBO_BOX_HEIGHT);
                this.add(this.survivedComboBoxEmbarked);
                this.survivedComboBox.addActionListener((e) -> {
                    String embarked = this.survivedComboBoxEmbarked.getItemAt(this.survivedComboBoxEmbarked.getSelectedIndex());
                    if (embarked.equals(Constants.PASSENGER_EMBARKED_OPTIONS[1])) {
                        Embarked = "C";
                    } else if (embarked.equals(Constants.PASSENGER_EMBARKED_OPTIONS[2])) {
                        Embarked = "Q";
                    } else if (embarked.equals(Constants.PASSENGER_EMBARKED_OPTIONS[3])) {
                        Embarked = "S";
                    } else if (embarked.equals(Constants.PASSENGER_EMBARKED_OPTIONS[0])) {
                        Embarked = null;
                    }
                    System.out.println((Embarked));
                });
                JLabel passengerName = new JLabel("Passenger name:");
                passengerName.setBounds(x + Constants.THIRD_LINE_MARGIN_FROM_LEFT , y , Constants.LABEL_WIDTH , Constants.LABEL_HEIGHT);
                this.add(passengerName);
                TextField PassengerNameBox = new TextField("");
                PassengerNameBox.setBounds(x + Constants.THIRD_LINE_MARGIN_FROM_LEFT + 110, y, Constants.LABEL_WIDTH / 2, Constants.LABEL_HEIGHT);
                this.add(PassengerNameBox);
                PassengerNameBox.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e)
                    {
                        try {
                            String text = PassengerNameBox.getText();

                            // Validate that the input is a name containing only letters using regular expressions
                            if (text.matches("[a-zA-Z]+")) {
                                PassengerName = text;
                            } else {
                                showMessage("Please enter a name that contains only letters ");
                                PassengerNameBox.setText("");
                                System.out.println("Invalid input: " + PassengerName);
                            }
                        } catch (NumberFormatException exception)
                        {
                            PassengerNameBox.setText("");
                            PassengerSibSpNumber = Constants.DEFAULT_INT;
                        }

                    }
                });

                JLabel passengerTicket = new JLabel("Passenger ticket:");
                passengerTicket.setBounds(x + Constants.SECOND_LINE_MARGIN_FROM_LEFT , Constants.THIRD_LINE_MARGIN_FROM_TOP, Constants.LABEL_WIDTH , Constants.LABEL_HEIGHT);
                this.add(passengerTicket);
                TextField PassengerTicketBox = new TextField("");
                PassengerTicketBox.setBounds(x + Constants.SECOND_LINE_MARGIN_FROM_LEFT + 110, Constants.THIRD_LINE_MARGIN_FROM_TOP, Constants.LABEL_WIDTH / 2, Constants.LABEL_HEIGHT);
                this.add(PassengerTicketBox);
                PassengerTicketBox.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e)
                    {
                        try {
                            int ticket = Integer.parseInt(PassengerTicketBox.getText());

                            if (ticket > 9 || ticket < 0) {
                                showMessage("Please enter a number between 0-9");
                                PassengerTicketBox.setText("");
                                ticket = Integer.parseInt(PassengerTicketBox.getText());
                            }

                        } catch (NumberFormatException exception)
                        {
                            PassengerTicketBox.setText("");
                            PassengerSibSpNumber = Constants.DEFAULT_INT;
                        }

                    }
                });
                JLabel passengerSibPs = new JLabel("Passenger SibPs:");
                passengerSibPs.setBounds(x + Constants.SECOND_LINE_MARGIN_FROM_LEFT , y, Constants.LABEL_WIDTH , Constants.LABEL_HEIGHT);
                this.add(passengerSibPs);
                TextField SibPsAmountBox = new TextField("");
                SibPsAmountBox.setBounds(x + Constants.SECOND_LINE_MARGIN_FROM_LEFT + 110, y, Constants.LABEL_WIDTH / 2, Constants.LABEL_HEIGHT);
                this.add(SibPsAmountBox);
                SibPsAmountBox.addKeyListener(new KeyAdapter() {
                    public void keyReleased(KeyEvent e) {
                        try {

                            if (SibPsAmountBox.getText().equals(""))
                            {
                                PassengerSibSpNumber = -1;
                            }
                            else {

                                int value = Integer.parseInt(SibPsAmountBox.getText());
                                if (value > 9 || value < 0) {
                                    showMessage("Please enter a number between 0-9");
                                    SibPsAmountBox.setText("");
                                    value = Integer.parseInt(SibPsAmountBox.getText());
                                }
                                else
                                {
                                        PassengerSibSpNumber = value;
                                }
                                System.out.println("sibSPAmountData number " + PassengerSibSpNumber);
                            }
                        } catch (NumberFormatException exception) {
                            SibPsAmountBox.setText("");
                            PassengerSibSpNumber = Constants.DEFAULT_INT;
                        }
                    }
                });
                JLabel passengerFare = new JLabel("Passenger Fare:");
                passengerFare.setBounds(x + Constants.SECOND_LINE_MARGIN_FROM_LEFT , Constants.SECOND_LINE_MARGIN_FROM_TOP, Constants.LABEL_WIDTH , Constants.LABEL_HEIGHT);
                this.add(passengerFare);
                JLabel minFareLabel = new JLabel("Min Fare:");
                minFareLabel.setBounds(x + Constants.SECOND_LINE_MARGIN_FROM_LEFT + 105 , Constants.SECOND_LINE_MARGIN_FROM_TOP - 50, Constants.LABEL_WIDTH / 2 + 90, Constants.LABEL_HEIGHT);
                this.add(minFareLabel);
                TextField minFare = new TextField("");
                minFare.setBounds(x + Constants.SECOND_LINE_MARGIN_FROM_LEFT + 110, Constants.SECOND_LINE_MARGIN_FROM_TOP - 20, Constants.LABEL_WIDTH / 2, Constants.LABEL_HEIGHT);
                this.add(minFare);
                minFare.addKeyListener(new KeyAdapter() {
                    public void keyReleased(KeyEvent e) {
                        try {
                            float value = Float.parseFloat(minFare.getText());
                            if (minFare.getText().equals(" "))
                            {
                                MinTicketCost = 0 ;
                            }
                            else
                            {
                                MinTicketCost = value;
                            }
                            System.out.println("Min ticket price: " + MinTicketCost);
                        }
                        catch (NumberFormatException exception)
                        {
                            if (!minFare.getText().equals("") || (Constants.MAX_FARE < Float.parseFloat(minFare.getText()))) {
                                showMessage("Please enter a valid number");
                            }
                            minFare.setText("");
                            MinTicketCost = Float.parseFloat(String.valueOf(Constants.DEFAULT_INT));
                        }
                    }
                });
                JLabel maxFareLabel = new JLabel("Max Fare:");
                maxFareLabel.setBounds(x + Constants.SECOND_LINE_MARGIN_FROM_LEFT + 105 , Constants.SECOND_LINE_MARGIN_FROM_TOP + 20, Constants.LABEL_WIDTH / 2 + 90, Constants.LABEL_HEIGHT);
                this.add(maxFareLabel);
                TextField maxFare = new TextField("");
                maxFare.setBounds(x + Constants.SECOND_LINE_MARGIN_FROM_LEFT + 110, Constants.SECOND_LINE_MARGIN_FROM_TOP + 50, Constants.LABEL_WIDTH / 2, Constants.LABEL_HEIGHT);
                this.add(maxFare);
                maxFare.addKeyListener(new KeyAdapter() {
                    public void keyReleased(KeyEvent e) {
                        try
                        {
                            float value = Float.parseFloat(maxFare.getText());
                            if (maxFare.equals(""))
                            {
                                MaxTicketCost = Constants.MAX_FARE ;
                            }
                            else
                            {
                                MaxTicketCost = value;
                            }
                            System.out.println("Max ticket price: " + MaxTicketCost);
                        }
                        catch (NumberFormatException exception)
                        {
                            if (!maxFare.getText().equals("") || (Float.parseFloat(maxFare.getText()) < Float.parseFloat(minFare.getText())) )
                            {
                                showMessage("Please enter a valid number");
                            }
                            maxFare.setText("");
                            MaxTicketCost = Float.parseFloat(String.valueOf(Constants.MAX_FARE));
                        }
                    }
                });

                JLabel PassengerId = new JLabel("Passenger Id:");
                PassengerId.setBounds(x + Constants.THIRD_LINE_MARGIN_FROM_LEFT , Constants.SECOND_LINE_MARGIN_FROM_TOP, Constants.LABEL_WIDTH , Constants.LABEL_HEIGHT);
                this.add(PassengerId);
                JLabel minPassengerIdLabel = new JLabel("Min Passenger Id:");
                minPassengerIdLabel.setBounds(x + Constants.THIRD_LINE_MARGIN_FROM_LEFT + 75 , Constants.SECOND_LINE_MARGIN_FROM_TOP - 50, Constants.LABEL_WIDTH / 2 + 90, Constants.LABEL_HEIGHT);
                this.add(minPassengerIdLabel);
                TextField minPassengerId = new TextField("");
                minPassengerId.setBounds(x + Constants.THIRD_LINE_MARGIN_FROM_LEFT + 115, Constants.SECOND_LINE_MARGIN_FROM_TOP - 20, Constants.LABEL_WIDTH / 2, Constants.LABEL_HEIGHT);
                this.add(minPassengerId);
                minPassengerId.addKeyListener(new KeyAdapter()
                {
                    public void keyReleased(KeyEvent e)
                    {
                        try {
                            int value = Integer.parseInt(minPassengerId.getText());
                            if (value > Constants.MAX_PASSENGER || value < Constants.MIN_PASSENGER)
                            {
                                minPassengerId.setText("");
                                showMessage("Min passenger is " + Constants.MIN_PASSENGER + " Max passenger is " + Constants.MAX_PASSENGER);
                            }
                            else
                            {
                                if (minPassengerId.getText().equals(" "))
                                    {
                                        MinPassengerNumber = Constants.MIN_PASSENGER ;
                                    } else
                                    {
                                        MinPassengerNumber = value;
                                    }

                                    System.out.println("Passenger number " + MaxPassengerNumber);
                                }
                        } catch (NumberFormatException exception)
                        {
                            minPassengerId.setText("");
                            MinPassengerNumber = Constants.MIN_PASSENGER;
                            if (!minPassengerId.getText().equals(""))
                            {
                                showMessage("Please enter a valid number");
                            }
                        }
                    }
                });

                JLabel maxPassengerIdLabel = new JLabel("Max Passenger Id:");
                maxPassengerIdLabel.setBounds(x + Constants.THIRD_LINE_MARGIN_FROM_LEFT + 75 , Constants.SECOND_LINE_MARGIN_FROM_TOP + 20, Constants.LABEL_WIDTH / 2 + 90, Constants.LABEL_HEIGHT);
                this.add(maxPassengerIdLabel);
                TextField maxPassengerId = new TextField("");
                maxPassengerId.setBounds(x + Constants.THIRD_LINE_MARGIN_FROM_LEFT + 115, Constants.SECOND_LINE_MARGIN_FROM_TOP + 50, Constants.LABEL_WIDTH / 2, Constants.LABEL_HEIGHT);
                this.add(maxPassengerId);
                minPassengerId.addKeyListener(new KeyAdapter()
                {
                    public void keyReleased(KeyEvent e)
                    {
                        try {
                            int value = Integer.parseInt(maxPassengerId.getText());
                            if (value > Constants.MAX_PASSENGER || value < Constants.MIN_PASSENGER)
                            {
                                maxPassengerId.setText("");
                                showMessage("Min passenger is " + Constants.MIN_PASSENGER + " Max passenger is " + Constants.MAX_PASSENGER);
                            }
                            else
                            {
                                if (maxPassengerId.getText().equals(""))
                                {
                                    MaxPassengerNumber = Constants.MAX_PASSENGER ;
                                } else
                                {
                                    MaxPassengerNumber = value;
                                }

                                System.out.println("Passenger number " + MaxPassengerNumber);
                            }
                        }
                        catch (NumberFormatException exception)
                        {
                            maxPassengerId.setText("");
                            MaxPassengerNumber = Constants.MIN_PASSENGER;
                            if (!maxPassengerId.getText().equals(""))
                            {
                                showMessage("Please enter a valid number");
                            }
                        }
                    }
                });


                JLabel parchAmount = new JLabel("Parch:");
                parchAmount.setBounds(x + Constants.THIRD_LINE_MARGIN_FROM_LEFT+ 50, Constants.THIRD_LINE_MARGIN_FROM_TOP, Constants.LABEL_WIDTH / 2, Constants.LABEL_HEIGHT);
                this.add(parchAmount);
                TextField parchAmountBox = new TextField("");
                parchAmountBox.setBounds(x + Constants.THIRD_LINE_MARGIN_FROM_LEFT+ 115 , Constants.THIRD_LINE_MARGIN_FROM_TOP, Constants.LABEL_WIDTH / 2, Constants.LABEL_HEIGHT);
                this.add(parchAmountBox);
                parchAmountBox.addKeyListener(new KeyAdapter() {
                    // @Override
                    public void keyReleased(KeyEvent e) {
                        try {
                            if ( parchAmountBox.getText().equals("") )
                            {
                                System.out.println(parchAmountBox.getText().equals(""));
                                PassengerParchNumber = -1 ;
                            }
                            else
                            {
                                int value = Integer.parseInt(parchAmountBox.getText());
                                if (value > 9  || value < 0)
                                {
                                    showMessage("Please enter a number between 0-9");
                                    parchAmountBox.setText("");
                                    value = Integer.parseInt(parchAmountBox.getText());
                                }
                                else
                                {
                                    PassengerParchNumber = value;
                                }
                            }
                        } catch (NumberFormatException exception) {
                            System.out.println("Please enter a valid number");
                            parchAmountBox.setText("");
                            PassengerParchNumber = Constants.DEFAULT_INT;
                        }
                    }
                });


                JLabel cabin = new JLabel("Cabin:");
                cabin.setBounds(x + Constants.FIRST_LINE_MARGIN_FROM_LEFT, Constants.THIRD_LINE_MARGIN_FROM_TOP + 100 , Constants.LABEL_WIDTH , Constants.LABEL_HEIGHT);
                this.add(cabin);
                TextField cabinBox = new TextField("");
                cabinBox.setBounds(x + Constants.FIRST_LINE_MARGIN_FROM_LEFT + 100  , Constants.THIRD_LINE_MARGIN_FROM_TOP + 100 , Constants.LABEL_WIDTH / 2, Constants.LABEL_HEIGHT);
                this.add(cabinBox);
                cabinBox.addKeyListener(new KeyAdapter() {
                    // @Override
                    public void keyReleased(KeyEvent e) {
                        try {
                            int cabin ;
                            if ( cabinBox.getText().equals("") )
                            {
                                System.out.println(cabinBox.getText().equals(""));
                                cabin = -1 ;
                            }
                            else
                            {
                                int value = Integer.parseInt(cabinBox.getText());
                                if (value > 9  || value < 0)
                                {
                                    showMessage("Please enter a number between 0-9");
                                    cabinBox.setText("");
                                    value = Integer.parseInt(cabinBox.getText());
                                }
                                else
                                {
                                    PassengerParchNumber = value;
                                }
                            }
                        } catch (NumberFormatException exception) {
                            System.out.println("Please enter a valid number");
                            cabinBox.setText("");
                            //cabin = Constants.DEFAULT_INT;
                        }
                    }
                });
/*               Passenger passenger = new Passenger(MinPassengerNumber , MaxPassengerNumber , PassengerClassNumber , Name ,
                                                        Sex , PassengerSibSpNumber, PassengerParchNumber ,PassengerTicket ,
                                                                     MinTicketCost , MaxTicketCost ,PassengerCabin ,Embarked) ;*/
                //Filter tmpFilter = new Filter();
                JButton filter = new JButton("Filter");
                filter.setBounds(x + Constants.FIRST_LINE_MARGIN_FROM_LEFT + 500, Constants.THIRD_LINE_MARGIN_FROM_TOP+ 350, Constants.LABEL_WIDTH , Constants.LABEL_HEIGHT + 20);
                filter.setFont(new Font("Filter", Font.ROMAN_BASELINE, 20));
                this.add(filter);
                List<Passenger> finalPassengerListSource1 = passengerListSource;
                filter.addActionListener(e -> {
                    try {
                        MinPassengerNumber = readIntBoxValue(minPassengerId.getText()) ;
                        MaxPassengerNumber = readIntBoxValue(maxPassengerId.getText()) ;
                        PassengerClassNumber = readIntBoxValue(this.survivedComboBox.getItemAt(this.survivedComboBox.getSelectedIndex())) ;
                        PassengerName = readStringBoxValue(PassengerNameBox.getText()) ;
                        PassengerSex = readStringBoxValue(this.survivedComboBoxSex.getItemAt(this.survivedComboBoxSex.getSelectedIndex())) ;
                        PassengerSibSpNumber =  readIntBoxValue(SibPsAmountBox.getText()) ;
                        PassengerParchNumber = readIntBoxValue(parchAmountBox.getText());
                        PassengerTicket = readIntBoxValue(PassengerTicketBox.getText()) ;
                        MinTicketCost =  readIntBoxValue(minFare.getText()) ;
                        MaxTicketCost = readIntBoxValue(maxFare.getText()) ;
                        PassengerCabin = readIntBoxValue(cabinBox.getText()) ;
                        Embarked = readStringBoxValue(this.survivedComboBoxEmbarked.getItemAt(this.survivedComboBoxEmbarked.getSelectedIndex())) ;
                        Filter tmpFilter = new Filter( MinPassengerNumber , MaxPassengerNumber , PassengerClassNumber , PassengerName , PassengerSex ,
                                PassengerSibSpNumber , PassengerParchNumber , PassengerTicket  , MinTicketCost  ,
                                MaxTicketCost ,  PassengerCabin , Embarked );
                        /*String tempX = parchAmountBox.getText();
                        if( tempX.equals("") )
                        {
                            System.out.println("Error");
                            PassengerParchNumber = -1 ;
                        }
                        else
                            System.out.println("hello" + tempX);
/*                       Passenger passenger1 = new Passenger( readIntBoxValue(minPassengerId.getText()),  readIntBoxValue(maxPassengerId.getText()) ,
                                readIntBoxValue(this.survivedComboBox.getItemAt(this.survivedComboBox.getSelectedIndex())) , readStringBoxValue(PassengerNameBox.getText()) ,
                                readStringBoxValue(this.survivedComboBoxSex.getItemAt(this.survivedComboBoxSex.getSelectedIndex()) ,
                                        readIntBoxValue(SibPsAmountBox.getText()) ,  readIntBoxValue(parchAmountBox.getText()) ,
                                        readIntBoxValue(PassengerTicketBox.getText()) , readIntBoxValue(minFare.getText()) ,readIntBoxValue(maxFare.getText()) ,
                                        readIntBoxValue(this.survivedComboBox.getItemAt(this.survivedComboBox.getSelectedIndex())) ,) ; */


                        List<Passenger> FilteredList = tmpFilter.filter(  finalPassengerListSource1);
                        showMessage(tmpFilter.CalculationOfSurvivors(FilteredList));
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                });
                JButton statistic = new JButton("Statistic");
                statistic.setBounds(x + Constants.FIRST_LINE_MARGIN_FROM_LEFT + 250, Constants.THIRD_LINE_MARGIN_FROM_TOP+ 350, Constants.LABEL_WIDTH , Constants.LABEL_HEIGHT + 20);
                statistic.setFont(new Font("Statistic", Font.ROMAN_BASELINE, 15));
                this.add(statistic);
                List<Passenger> finalPassengerListSource = passengerListSource;
                statistic.addActionListener(e -> {
                    try {
                        Statistics statistic1 = new Statistics();
                        statistic1.StatisticsHandler(finalPassengerListSource);
                    } catch (FileNotFoundException ex) {
                        throw new RuntimeException(ex);
                    }
                });




                this.survivedComboBox.addActionListener((e) -> {
                    //do whatever you want on change
                });
            }
        }

        /*public class BackgroundImage extends JPanel
        {
            Image pic ;
            public BackgroundImage()
            {
                ImageIcon imageIcon = new ImageIcon("WhatsApp Image 2023-04-30 at 19.04.25.jpeg") ;
                pic = imageIcon.getImage();
            }

            public void paintComponent( Graphics graphics)
            {
                super.paintComponent(graphics);
                graphics.drawImage(pic, 0 , 0 , null);
            }
        }*/


     public void showMessage(String message)
     {
         JOptionPane.showMessageDialog(this, message, "Filter", JOptionPane.INFORMATION_MESSAGE);
     }

     protected void paintComponent(Graphics g) {
         super.paintComponents(g);
         g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
     }

     public int readIntBoxValue (String value)
     {
         int tempX ;
         if( value.equals("") || value.equals("All") )
         {
            tempX = -1 ;
         }
         else {
             tempX = Integer.parseInt(value);
         }
         return tempX ;
     }

     public String readStringBoxValue (String value)
     {
         String tempY = value ;
         if( value.equals("") || value.equals("All")  )
         {
             tempY = "" ;
         }
         return tempY ;

     }

 }


