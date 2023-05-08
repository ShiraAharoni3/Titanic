import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import static javax.swing.text.html.HTML.Tag.P;

public class Statistics
{
    private static int txtNumbers = 0;

    public int StatisticsHandler(  List<Passenger> passengers) throws FileNotFoundException
    {
        String toWrite = ( byEmbarked(passengers) + "\n" + byAge(passengers) + "\n" +
                           bySex(passengers) + "\n" + bySibParch(passengers) + "\n" +
                               byPrice(passengers) + "\n" + byPClass(passengers)   );

        txtNumbers++;
        String fileName = String.valueOf(txtNumbers);
        File file = new File("./" +fileName + "txt");
        PrintWriter printWriter = new PrintWriter(file);
        printWriter.println(toWrite);
        printWriter.close();

        return 0 ;
    }

    private String byPClass(List<Passenger> passengers)
    {
        int wasInFirstClass = 0 ;
        int survivedFirstClass = 0 ;
        int wasInSecondClass = 0 ;
        int survivedSecondClass = 0;
        int wasInThirdClass = 0 ;
        int survivedThirdClass = 0;
        float PercentSurvived1 = 0;
        float PercentSurvived2 = 0;
        float PercentSurvived3 = 0;

        for (int i = 0 ; i < passengers.size() ; i++)
        {
            if (passengers.get(i).getPclass() == 1)
            {
                wasInFirstClass++;
                if (isSurvived(passengers.get(i)))
                    survivedFirstClass++;
            }
            else if (passengers.get(i).getPclass() == 2)
            {
                wasInSecondClass++;
                if (isSurvived(passengers.get(i)))
                    survivedSecondClass++;
            }
            else
            {
                wasInThirdClass++;
                if (isSurvived(passengers.get(i)))
                    survivedThirdClass++;

            }
        }

        if (wasInFirstClass != 0)
            PercentSurvived1 = (float)(survivedFirstClass * 100/ wasInFirstClass) ;

        if (wasInSecondClass != 0 )
            PercentSurvived2 = (float)(survivedSecondClass * 100/ wasInSecondClass) ;

        if (wasInThirdClass != 0)
            PercentSurvived3 = (float)(survivedThirdClass * 100/ wasInThirdClass) ;

            return "Total survived per class: \n" + "First class " + PercentSurvived1 + "%\n"
                    + "Second class" + PercentSurvived2 + " %\n" + "Third class" + PercentSurvived3 + "%\n";
    }


        private String byEmbarked (List < Passenger > passengers)
        {
            int wasInCEmbarked = 0;
            int survivedCEmbarked = 0;
            int wasInQEmbarked = 0;
            int survivedQEmbarked = 0;
            int wasInSEmbarked = 0;
            int survivedSEmbarked = 0;
            float PercentSurvivedCEmbarked = 0 ;
            float PercentSurvivedQEmbarked = 0 ;
            float PercentSurvivedSEmbarked = 0 ;


            String conclusion = "Total survived from embarked: ";
            for (int i = 1; i < passengers.size(); i++)
            {
                if (passengers.get(i).getEmbarked().equals(Constants.PASSENGER_EMBARKED_OPTIONS[1]))
                {
                    wasInCEmbarked++;
                    if (isSurvived(passengers.get(i)))
                        survivedCEmbarked++;

                }
                else if (passengers.get(i).getEmbarked().equals(Constants.PASSENGER_EMBARKED_OPTIONS[2]))
                {
                    wasInQEmbarked++;
                    if (isSurvived(passengers.get(i)))
                        survivedQEmbarked++;
                }
                else if (passengers.get(i).getEmbarked().equals(Constants.PASSENGER_EMBARKED_OPTIONS[3]))
                {
                    wasInSEmbarked++;
                    if (isSurvived(passengers.get(i)))
                        survivedSEmbarked++;
                }
            }
            if (wasInCEmbarked != 0)
                PercentSurvivedCEmbarked = (float)(survivedCEmbarked * 100/ wasInCEmbarked) ;

            if (wasInQEmbarked != 0 )
                PercentSurvivedQEmbarked = (float)(survivedQEmbarked * 100/ wasInQEmbarked) ;

            if (wasInSEmbarked != 0)
                PercentSurvivedSEmbarked = (float)(survivedSEmbarked * 100/ wasInSEmbarked) ;

            return "Total survived per embarked: \n" + "C Embarked " + PercentSurvivedCEmbarked + "%\n"
                    + "Q Embarked" + PercentSurvivedQEmbarked + " %\n" + "S Embarked" + PercentSurvivedSEmbarked + "%\n";

        }


        private String byPrice (List < Passenger > passengers)
        {
            int LowPrice = 0;
            int LowPriceSurvived = 0;
            int MediumPrice = 0;
            int MediumPriceSurvived = 0;
            int HighPrice = 0;
            int HighPriceSurvived = 0;
            float PercentSurvivedLowPrice = 0;
            float PercentSurvivedMediumPrice = 0 ;
            float PercentSurvivedHighPrice = 0;


            String conclusion = "Total survived per price: ";
            for (int i = 0; i < passengers.size(); i++)
            {
                if ((passengers.get(i).getFare() > Constants.MIN_MEDIUM_PRICE) && (passengers.get(i).getFare() < Constants.MIN_HIGH_PRICE))
                {
                    MediumPrice++;
                    if (isSurvived(passengers.get(i)))
                        MediumPriceSurvived++;
                }
                else if (passengers.get(i).getFare() > Constants.MIN_HIGH_PRICE)
                {
                    HighPrice++;
                    if (isSurvived(passengers.get(i)))
                        HighPriceSurvived++ ;

                }
                else
                {
                    LowPrice++ ;
                    if (isSurvived(passengers.get(i)))
                        LowPriceSurvived++ ;
                }
            }
            if (LowPrice != 0)
                PercentSurvivedLowPrice = (float)(LowPriceSurvived * 100/ LowPrice) ;

            if (MediumPrice != 0 )
                PercentSurvivedMediumPrice = (float)(MediumPriceSurvived * 100/ MediumPrice)  ;

            if (HighPrice != 0)
                PercentSurvivedHighPrice = (float)(HighPriceSurvived * 100/HighPrice) ;


            return "Total survived per price: \n" + "Low Price " + PercentSurvivedLowPrice + "%\n"
                    + "Medium Price " + PercentSurvivedMediumPrice + " %\n" + "High Price" + PercentSurvivedHighPrice + "%\n" ;
            }

        private String bySibParch (List < Passenger > passengers)
        {
            int haveFamily = 0 ;
            int FamilyAlive = 0 ;
            int noFamily = 0 ;
            int noFamilyAlive = 0 ;
            float PercentFamilyAlive = 0 ;
            float PercentNoFamilyAlive = 0;
            for (int i = 0 ; i < passengers.size() ; i++)
            {
                if (passengers.get(i).getSibSp() > 0)
                {
                    haveFamily++ ;
                    if (isSurvived(passengers.get(i)))
                        FamilyAlive++ ;
                }
                else
                {
                    noFamily++ ;
                    if (isSurvived(passengers.get(i)))
                        noFamilyAlive++ ;

                }
            }
            if (haveFamily != 0)
                PercentFamilyAlive = (float)(FamilyAlive * 100/ haveFamily)  ;

            if (noFamily != 0 )
                PercentNoFamilyAlive = (float)(noFamilyAlive * 100/ noFamily) ;

            return "Total people without family who survived are " + PercentNoFamilyAlive + "%\n" +
                    "Total family with family who survived are " + PercentFamilyAlive + "%";
        }

        private String byAge (List < Passenger > passengers)
        {
            String calculated = "Survived by age ";
            int ChildrenUnder10 = 0 ;
            int SurvivedChildrenUnder10 = 0 ;
            int YoungBoys = 0 ;
            int SurvivedYoungBoys = 0 ;
            int youngGuys = 0 ;
            int SurvivedYoungGuys = 0 ;
            int Guys = 0 ;
            int SurvivedGuys = 0 ;
            int adults = 0 ;
            int SurvivedAdults = 0 ;
            int elders = 0 ;
            int SurvivedElders = 0 ;
            float PercentSurvivedChildrenUnder10 = 0 ;
            float PercentSurvivedYoungBoys = 0 ;
            float PercentSurvivedYoungGuys = 0 ;
            float PercentSurvivedGuys = 0 ;
            float PercentSurvivedAdults = 0 ;
            float PercentSurvivedElders = 0 ;

            for (int i = 0 ; i < passengers.size() ; i++)
            {
                if ( (passengers.get(i).getAge() >= 0 /*Constants.PASSENGER_AGE[0]*/ ) && ( passengers.get(i).getAge() <= 10/*Constants.PASSENGER_AGE[1]*/))
                {
                    ChildrenUnder10++ ;
                    if (isSurvived(passengers.get(i)))
                        SurvivedChildrenUnder10++ ;
                }
                else if ((passengers.get(i).getAge() >= 11/*Constants.PASSENGER_AGE[2]*/ ) && ( passengers.get(i).getAge() <= 20/*Constants.PASSENGER_AGE[3]*/))
                {
                    YoungBoys++ ;
                    if (isSurvived(passengers.get(i)))
                        SurvivedYoungBoys++ ;
                }
                else if ((passengers.get(i).getAge() > 21/*Constants.PASSENGER_AGE[4]*/ ) && ( passengers.get(i).getAge() <= 30/*Constants.PASSENGER_AGE[5]*/))
                {
                    youngGuys++ ;
                    if (isSurvived(passengers.get(i)))
                        SurvivedYoungGuys++ ;
                }
                else if ((passengers.get(i).getAge() >= 31/*Constants.PASSENGER_AGE[6] */) && ( passengers.get(i).getAge() <= 40/*Constants.PASSENGER_AGE[7]*/))
                {
                    Guys++ ;
                    if (isSurvived(passengers.get(i)))
                        SurvivedGuys++ ;
                }
                else if ((passengers.get(i).getAge() >= 41/* Constants.PASSENGER_AGE[8]*/ ) && ( passengers.get(i).getAge() <= 50/*Constants.PASSENGER_AGE[9]*/))
                {
                    adults++ ;
                    if (isSurvived(passengers.get(i)))
                        SurvivedAdults++ ;
                }
                else
                {
                    elders++;
                    if (isSurvived(passengers.get(i)))
                        SurvivedElders++ ;
                }

            }
            if (ChildrenUnder10 != 0)
                PercentSurvivedChildrenUnder10 = (float)(SurvivedChildrenUnder10 * 100/ ChildrenUnder10)  ;
            if (YoungBoys != 0 )
                PercentSurvivedYoungBoys = (float)(SurvivedYoungBoys * 100/ YoungBoys)  ;
            if (youngGuys != 0)
                PercentSurvivedYoungGuys = (float)(SurvivedYoungGuys * 100/ youngGuys)  ;
            if (Guys != 0 )
                PercentSurvivedGuys = (float)(SurvivedGuys * 100/ Guys)  ;
            if (adults != 0)
                PercentSurvivedAdults = (float)(SurvivedAdults * 100 / adults)  ;
            if (elders != 0 )
                PercentSurvivedElders = (float)(SurvivedElders * 100 / elders)  ;


            return "Survived by age:\n " + "Children under the age of ten" + PercentSurvivedChildrenUnder10 + "%\n" +
                "Boys under 20 years old " + PercentSurvivedYoungBoys + "%\n" + "Guys under 30 " + PercentSurvivedYoungGuys + "%\n" +
                "Adults up to the age of 40 " + PercentSurvivedGuys + "%\n" +  "Adults up to age 50 " + PercentSurvivedAdults + "%\n" +
                    "Elders " + PercentSurvivedElders + "%\n"  ;
        }

        private String bySex (List < Passenger > passengers)
        {
            int totalMale = 0 ;
            int survivedMale = 0 ;
            int totalFemale = 0 ;
            int survivedFemale = 0 ;
            float PercentSurvivedMale = 0 ;
            float PercentSurvivedFemale = 0 ;

            for (int i = 0; i < passengers.size(); i++) {
                if (passengers.get(i).getSex().equals("male"))
                {
                    totalMale++;
                    if (isSurvived(passengers.get(i)))
                        survivedMale++;
                }
                else
                {
                    totalFemale++;
                    if (isSurvived(passengers.get(i))) {
                        survivedFemale++;
                    }
                }
            }

            if (totalMale != 0)
                PercentSurvivedMale = (float)(survivedMale * 100/ totalMale)  ;

            if (totalFemale != 0 )
                PercentSurvivedFemale = (float)(survivedFemale * 100/ totalFemale)  ;

            return "Total male survived " + PercentSurvivedMale + "%, Total female survived " + PercentSurvivedFemale + "%";
        }

    public boolean isSurvived (Passenger passenger)
    {
        boolean survived = false ;
        if (passenger.getSurvived() == 1)
            survived = true ;

        return survived ;
    }
}




