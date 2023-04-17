public class Passenger {
    private int PassengerId;
    private int Survived;
    private int Pclass;
    private String Name;
    private String Sex;
    private int Age;
    private int SibSp;
    private int Parch;
    private int Ticket;
    private double Fare;
    private int Cabin;
    private String Embarked;


    public Passenger(int passengerId, int survived, int pclass, String name, String sex, int age,
              int sibSp, int parch, int ticket, double fare, int cabin, String embarked) {
        this.PassengerId = passengerId;
        this.Survived = survived;
        this.Pclass = pclass;
        this.Name = getFormattedName(name);
        this.Sex = sex ;
        this.Age = age ;
        this.SibSp = sibSp ;
        this.Parch = parch ;
        this.Ticket = ticket ;
        this.Fare = fare ;
        this.Cabin = cabin ;
        this.Embarked = embarked ;
    }

    private String getFormattedName( String name)
    {
        String SourceName = name ;
        String title = null ;
        String NameWithoutTitle = null ;
        boolean result = false ;
        if (SourceName.contains(",") == true)
        {
            title = SourceName.substring(SourceName.indexOf(","), SourceName.indexOf(".")+1);
            System.out.println(title);
            NameWithoutTitle = SourceName.replaceAll(title , " ") ;
        }
        else
        {
            NameWithoutTitle = SourceName ;
        }
        return NameWithoutTitle ;

    }
}


