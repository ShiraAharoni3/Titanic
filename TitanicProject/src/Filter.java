import java.io.FileNotFoundException;
import java.util.*;

public class Filter
{
    private double PclassFilter;
    private String NameFilter;
    private String SexFilter;
    private double SibSpFilter;
    private double ParchFilter;
    private int onlyTicketNumber ;
    private int onlyCabinNumber ;
    private String EmbarkedFilter;
    private double minFare ;
    private double maxFare ;
    private int minPassengerIdFilter ;
    private int maxPassengerIdFilter ;
    public Filter () { };

    public Filter(  int minPassengerId, int maxPassengerId ,double Pclass ,String Name ,String Sex ,
                    double SibSp ,double Parch , int Ticket , double minFare , double maxFare, int Cabin ,String Embarked )
    {
        this.minPassengerIdFilter = minPassengerId;
        this.maxPassengerIdFilter = maxPassengerId ;
        this.PclassFilter = Pclass ;
        this.NameFilter = Name;
        this.SexFilter = Sex ;
        this.SibSpFilter = SibSp ;
        this.ParchFilter = Parch ;
        this.onlyTicketNumber = Ticket ;
        this.minFare = minFare ;
        this.maxFare = maxFare ;
        this.onlyCabinNumber = Cabin ;
        this.EmbarkedFilter = Embarked ;

    }
    public int getMinPassengerId () {return this.minPassengerIdFilter ; }
    public int getMaxPassengerId () {return this.maxPassengerIdFilter ; }
    public Double getPclassFilter ()
    {
        return this.PclassFilter ;
    }

    public String getNameFilter ()
    {
        return this.NameFilter ;
    }

    public String getSexFilter ()
    {
        return this.SexFilter ;
    }

    public int getSibSpFilter ()
    {
        return (int) this.SibSpFilter;
    }

    public int getParchFilter ()
    {
        return (int) this.ParchFilter;
    }
    public int getTicketFilter ()
    {
        return this.onlyTicketNumber ;
    }
    public Double getMinFare ()
    {
        return this.minFare ;
    }
    public Double getMaxFare ()
    {
        return this.maxFare ;
    }
    public int getIntCabin ()
    {
        return this.onlyCabinNumber ;
    }

    public String getEmbarkedFilter ()
    {
        return this.EmbarkedFilter ;
    }




    /*public List filter ( String name , int Pclass , int MinPassengerNumber , int MaxPassengerNumber, String Sex,
                         int PassengerSibSpNumber, int PassengerParchNumber, String PassengerTicket,
                         double MinTicketCost , double MaxTicketCost , String PassengerCabin,
                         String Embarked , List passenger)*/
  public List filter ( /*Passenger FilterPassenger  ,*/ List <Passenger> passengerList ) throws FileNotFoundException
    {

        List <Passenger> returnPassengerListAfterFilter = new ArrayList<>();
        for ( int i = 0 ; i < passengerList.size() ; i++)
        {
            Passenger currentObject = (Passenger) passengerList.get(i);
            if ( ( this.PclassFilter != -1 ) && ( this.PclassFilter != currentObject.getPclass()  ) )
                continue;
            if ( ( (this.minFare != -1 ) && (this.maxFare != -1)) &&
                    ( ( currentObject.getFare() <= this.minFare ) ||  ( currentObject.getFare() >= this.maxFare ) ) )
                continue;
           if ( ( !this.EmbarkedFilter.equals("")  ) && ( !this.EmbarkedFilter.equals(currentObject.getEmbarked())  ) )
                continue;
            if ( ( this.onlyCabinNumber != -1  ) && ( this.onlyCabinNumber != (currentObject.getIntCabin())  ) )
                continue;
             if ( ( this.onlyTicketNumber != -1  ) && ( this.onlyTicketNumber != currentObject.getOnlyTicketNumber()  ) )
                continue;
/*            String tmp = FilterPassenger.getSex();
            String tmp1 = currentObject.getSex();
            System.out.println("Parch amount: " + tmp1 +"  "+ tmp);*/
             if ( ( !this.SexFilter.equals("") ) && ( !this.SexFilter.equals(currentObject.getSex())  ) )
                continue;
           if ( ( !this.NameFilter.equals("") ) && ( !this.NameFilter.equals(currentObject.getName())  ) )
                continue;
            if ( (  ( this.minPassengerIdFilter != -1 ) &&
                    ( this.maxPassengerIdFilter != -1)) &&
                    ( ( currentObject.getPassengerId() <= this.minPassengerIdFilter  ) ||( currentObject.getPassengerId() >= this.maxPassengerIdFilter ) )
            )
                continue;

              if ( ( this.SibSpFilter != -1 ) && ( this.SibSpFilter != currentObject.getSibSp()  ) )
                continue;
              if ( ( this.ParchFilter != -1 ) && ( this.ParchFilter != currentObject.getParch()  ) )
                continue;

            returnPassengerListAfterFilter.add(currentObject) ;
        }
        for (int i = 0 ; i< returnPassengerListAfterFilter.size() ; i++)
        {
            System.out.println(returnPassengerListAfterFilter.get(i).getPassengerId());
        }
        System.out.println() ;
        //System.out.println(returnPassengerListAfterFilter);
        return returnPassengerListAfterFilter ;
    }

    public String CalculationOfSurvivors (List <Passenger> passengerList)
    {
       String TotalRows ;
       int PassengerNumber = passengerList.size();
       int passengersSurvivedNumber = 0 ;
       for( int i = 0 ; i< passengerList.size(); i++)
       {
           if (passengerList.get(i).getSurvived() == 1)
               passengersSurvivedNumber++ ;
       }
       TotalRows = "Total Rows:" + PassengerNumber + "(" + passengersSurvivedNumber + "survived," +
                      (PassengerNumber - passengersSurvivedNumber) +"did not)" ;
       return TotalRows ;
    }
    public List FilterByClass(double classNumber , List passengerList)
    {
        List<Passenger> PassengersWhoMeetTheRequirements = new ArrayList<>() ;
        if (classNumber == 0)
        {
            PassengersWhoMeetTheRequirements = passengerList ;
        }
        else
        {
            for ( int i = 0 ; i < passengerList.size() ; i++)
            {
                Passenger currentObject = (Passenger) passengerList.get(i);
                if (currentObject.getPclass() == classNumber );
                {
                    PassengersWhoMeetTheRequirements.add(currentObject) ;
                }
            }
        }

        return PassengersWhoMeetTheRequirements ;
    }
    public List FilterByName(String name , List passengerList)
    {
        List<Passenger> PassengersWhoMeetTheRequirements = new ArrayList<>() ;
        if (name == null)
        {
            PassengersWhoMeetTheRequirements = passengerList ;
        }
        else
        {
            for ( int i = 0 ; i < passengerList.size() ; i++)
            {
                Passenger currentObject = (Passenger) passengerList.get(i);
                if (currentObject.getName().equals(name ) || currentObject.getName().contains(name) );
                {
                    PassengersWhoMeetTheRequirements.add(currentObject) ;
                }
            }
        }

        return PassengersWhoMeetTheRequirements ;
    }

    public List FilterByPassengerNumber(int minPassengerNumber , int maxPassengerNumber , List passengerList)
    {
        List<Passenger> PassengersWhoMeetTheRequirements = new ArrayList<>() ;
        int minPassengerNumberForFilter = minPassengerNumber ;
        int maxPassengerNumberForFilter = maxPassengerNumber ;

        if (minPassengerNumber == 0)
        {
            minPassengerNumberForFilter = Constants.MIN_PASSENGER ;
        }
        if (maxPassengerNumber == 0)
        {
          maxPassengerNumberForFilter = Constants.MAX_PASSENGER ;
        }

        for ( int i = 0 ; i < passengerList.size() ; i++)
        {
            Passenger currentObject = (Passenger) passengerList.get(i);
            if ((currentObject.getPassengerId() > minPassengerNumberForFilter ) &&
                    (currentObject.getPassengerId() < maxPassengerNumberForFilter) );
            {
                PassengersWhoMeetTheRequirements.add(currentObject) ;
            }
        }

        return PassengersWhoMeetTheRequirements ;
    }

    public List FilterByPassengerSex (String sex , List passengerList)
    {
        List<Passenger> PassengersWhoMeetTheRequirements = new ArrayList<>() ;
        if (sex == null)
        {
            PassengersWhoMeetTheRequirements = passengerList ;
        }
        else
        {
            for ( int i = 0 ; i < passengerList.size() ; i++)
            {
                Passenger currentObject = (Passenger) passengerList.get(i);
                if (currentObject.getSex().equals(sex) );
                {
                    PassengersWhoMeetTheRequirements.add(currentObject) ;
                }
            }
        }

        return PassengersWhoMeetTheRequirements ;
    }

    public List FilterByPassengerSibSp (int numberOfSibSp , List passengerList)
    {
        List<Passenger> PassengersWhoMeetTheRequirements = new ArrayList<>();
        if (numberOfSibSp == -1)
        {
            PassengersWhoMeetTheRequirements = passengerList ;
        }
        else
        {
            for (int i = 0; i < passengerList.size(); i++) {
                Passenger currentObject = (Passenger) passengerList.get(i);
                if (currentObject.getSibSp() == numberOfSibSp) ;
                {
                    PassengersWhoMeetTheRequirements.add(currentObject);
                }
            }
        }

        return PassengersWhoMeetTheRequirements;
    }

    public List FilterByPassengerParch (int numberOfParch , List passengerList)
    {
        List<Passenger> PassengersWhoMeetTheRequirements = new ArrayList<>();
        if (numberOfParch == -1)
        {
            PassengersWhoMeetTheRequirements = passengerList ;
        }
        else
        {
            for (int i = 0; i < passengerList.size(); i++)
            {
                Passenger currentObject = (Passenger) passengerList.get(i);
                if (currentObject.getParch() == numberOfParch ) ;
                {
                    PassengersWhoMeetTheRequirements.add(currentObject);
                }
            }
        }

        return PassengersWhoMeetTheRequirements;
    }

    public List FilterByPassengerTicket (String ticket , List passengerList)
    {
        List<Passenger> PassengersWhoMeetTheRequirements = new ArrayList<>();
        if (ticket == null)
        {
            PassengersWhoMeetTheRequirements = passengerList ;
        }
        else
        {
            for (int i = 0; i < passengerList.size(); i++)
            {
                Passenger currentObject = (Passenger) passengerList.get(i);
                if ( (currentObject.getTicket().equals(ticket) ) || ( currentObject.getTicket().contains(ticket) ) ) ;
                {
                    PassengersWhoMeetTheRequirements.add(currentObject);
                }
            }
        }

        return PassengersWhoMeetTheRequirements;
    }

    public List FilterByTicketCost (double minTicketCost , double maxTicketCost , List passengerList)
    {
        List<Passenger> PassengersWhoMeetTheRequirements = new ArrayList<>() ;
        double maxTicketCostForFilter = maxTicketCost ;
        if (minTicketCost == 0)
        {
            maxTicketCostForFilter = Constants.MAX_FARE ;
        }

        for ( int i = 0 ; i < passengerList.size() ; i++)
        {
            Passenger currentObject = (Passenger) passengerList.get(i);
            if ((currentObject.getFare() > minTicketCost ) && (currentObject.getPassengerId() < maxTicketCostForFilter) );
            {
                PassengersWhoMeetTheRequirements.add(currentObject) ;
            }
        }

        return PassengersWhoMeetTheRequirements ;
    }

    public List FilterByPassengerCabin (String cabin , List passengerList)
   {
    List<Passenger> PassengersWhoMeetTheRequirements = new ArrayList<>();
    if (cabin == null)
    {
     PassengersWhoMeetTheRequirements = passengerList ;
    }
    else
    {
        for (int i = 0; i < passengerList.size(); i++)
        {
            Passenger currentObject = (Passenger) passengerList.get(i);
            if ( (currentObject.getCabin().equals(cabin) ) || ( currentObject.getTicket().contains(cabin) ) ) ;
            {
                PassengersWhoMeetTheRequirements.add(currentObject);
            }
        }
    }

    return PassengersWhoMeetTheRequirements;
   }

    public List FilterByEmbarked (String Embarked , List passengerList)
    {
        List<Passenger> PassengersWhoMeetTheRequirements = new ArrayList<>();
        if (Embarked == null)
        {
            PassengersWhoMeetTheRequirements = passengerList ;
        }
        else
        {
            for (int i = 0; i < passengerList.size(); i++)
            {
                Passenger currentObject = (Passenger) passengerList.get(i);
                if ( currentObject.getCabin().equals(Embarked) ) ;
                {
                    PassengersWhoMeetTheRequirements.add(currentObject);
                }
            }

        }

        return PassengersWhoMeetTheRequirements;
    }

    public List filter (int PassengerId ,int Survived ,int Pclass ,String Name ,String Sex ,double Age ,
                        int SibSp ,int Parch , String Ticket ,double Fare, String Cabin ,String Embarked)
    {
        // Receive the user input and store it in a Map
        Map<String, Object> filters = new HashMap<>();
        filters.put("name", "John");
        filters.put("age", 25);

// Construct the query dynamically using a StringBuilder
        StringBuilder queryBuilder = new StringBuilder("SELECT * FROM users WHERE 1=1");

        for (Map.Entry<String, Object> filter : filters.entrySet()) {
            String parameter = filter.getKey();
            Object value = filter.getValue();

            if (value instanceof String) {
                queryBuilder.append(" AND " + parameter + " = '" + value + "'");
            } else if (value instanceof Number) {
                queryBuilder.append(" AND " + parameter + " = " + value);
            }
        }

        String query = queryBuilder.toString();

// Execute the query using a JDBC driver or a database access library

        if (PassengerId == 0)
        {

        }
        List<Passenger> filterList = new ArrayList<>() ;


        return filterList ;
    }



}
