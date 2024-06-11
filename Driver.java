import java.util.Scanner;

public class Driver {
    public static void main(String[] args) {
        StudentData rawData = new StudentData("RawIncomeData.csv");

        System.out.println("Greetings! Welcome to the Gini Index calculator!");
        Scanner scan = new Scanner(System.in);
        String x = "";
        while (!x.equals("q")) {
            System.out.println("Which country would you like to know the Gini index of (type q to quit)? Make sure to capitalize countries. "); 
            x = scan.nextLine();
            if (x.equals("q")) {
                break;
            }
            System.out.println("Which year?");
            String t = scan.nextLine();
            if (t.equals("q")) {
                break;
            }
            CountryData country = new CountryData(rawData, x, t);
            if (rawData.getRow(x, t) != -1) {
                double b = country.giniIndex();
                System.out.println(x + "'s Gini Index in " + t + " was " + b);
            } 
            else {
                System.out.println("That country does not exist.");
            }
        }
        scan.close();
        System.out.println("Thank you for using the Gini Index Calculator!");
    }
}
