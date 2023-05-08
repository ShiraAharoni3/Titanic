public class Passenger
{
        private double PassengerId;
        private double Survived;
        private double Pclass;
        private String Name;
        private String Sex;
        private double Age;
        private double SibSp;
        private double Parch;
        private String Ticket;
        private double Fare;
        private String Cabin;
        private String Embarked;
        private int    onlyCabinNumber ;
        private int    onlyTicketNumber ;

       public Passenger(  double PassengerId ,double Survived ,double Pclass ,String Name ,String Sex ,double Age ,
                           double SibSp ,double Parch , String Ticket ,double Fare, String Cabin ,String Embarked )
        {
            this.PassengerId = PassengerId;
            this.Survived = Survived;
            this.Pclass = Pclass;
            this.Name = Name;
            this.Sex = Sex ;
            this.Age = Age ;
            this.SibSp = SibSp ;
            this.Parch = Parch ;
            this.Ticket = Ticket ;
            this.Fare = Fare;
            this.Cabin = Cabin ;
            this.Embarked = Embarked ;

            if (!Cabin.equals("null")) {
                try {
                    this.onlyCabinNumber = Integer.parseInt(Cabin);
                } catch (NumberFormatException e) {
                    // handle the exception here, e.g. set a default value for int_value
                    this.onlyCabinNumber = -1 ;
                }
            }
            if (!Ticket.equals("null")) {
                try {
                    this.onlyTicketNumber = Integer.parseInt(Ticket);
                } catch (NumberFormatException e) {
                    // handle the exception here, e.g. set a default value for int_value
                    this.onlyTicketNumber = -1 ;
                }
            }
/*            if (Cabin.equals(null))
            {
                this.onlyCabinNumber = -1 ;
            }
            else {
                this.onlyCabinNumber = Integer.parseInt(Cabin);
            }
            if (Ticket.equals(null))
            {
                this.onlyTicketNumber = -1 ;
            }
            else {
                this.onlyTicketNumber = Integer.parseInt(Ticket);
            }*/

        }


    public Double getPassengerId ()
    {
        return this.PassengerId ;
    }


    public Double getSurvived ()
    {
        return this.Survived ;
    }

    public Double getPclass ()
    {
        return this.Pclass ;
    }

    public String getName ()
    {
        return this.Name ;
    }

    public String getSex ()
    {
        return this.Sex ;
    }

    public Double getAge ()
    {
        return this.Age ;
    }

    public int getSibSp ()
    {
        return (int) this.SibSp;
    }

    public int getParch ()
    {
       return (int) this.Parch;
    }
    public String getTicket ()
    {
        return this.Ticket ;
    }

    public Double getFare ()
    {
        return this.Fare ;
    }
    public String getCabin ()
    {
        return this.Cabin ;
    }
    public int getIntCabin ()
    {
        return this.onlyCabinNumber ;
    }
    public int getOnlyTicketNumber ()
    {
        return this.onlyTicketNumber ;
    }

    public String getEmbarked ()
    {
        return this.Embarked ;
    }








    public String getFormattedName( String name )
        {
            String SourceName  ;
            String title  ;
            String NameWithoutTitle = null ;
            boolean result = false ;
            if (name.contains(".") == true)
            {
                NameWithoutTitle = name.substring(0, name.indexOf(",")+1) + name.substring(name.indexOf(".") , name.length());
            }
            else
            {
                NameWithoutTitle = name ;
            }
            return NameWithoutTitle ;

        }


    }

