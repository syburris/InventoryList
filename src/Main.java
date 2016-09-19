import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by stevenburris on 9/19/16.
 */
public class Main {


    public static void main(String[] args) {

        HashMap<String, ArrayList<Tank>> engineers = new HashMap<>();
        Scanner scanner = new Scanner(System.in);

        while (true){
            System.out.println("Please enter your name");
            String name = scanner.nextLine();

            ArrayList<Tank> tanks = engineers.get(name);
            if(tanks == null) {
                tanks = new ArrayList<>();
                engineers.put(name, tanks);
            }

            boolean isLoggedIn = true;
            while (isLoggedIn) {

                for (int t = 0; t < tanks.size(); t++) {
                    Tank tank3 = tanks.get(t);
                    int number = t + 1;
                    String checkbox = " {Has not been cleaned.} ";
                    if (tank3.hasBeenCleaned) {
                        checkbox = " {Has been cleaned.} ";
                    }
                    System.out.printf("%s %s %s", checkbox, number, tank3.tankNames);
                    System.out.println();
                }

                System.out.println("1: Add another tank to your hospital's inventory.");
                System.out.println("2: Check/uncheck which tanks have been cleaned.");
                System.out.println("3: View a list of all tanks currently added to your hospital's inventory.");
                System.out.println("4: Remove a tank from your hospital's inventory list.");
                System.out.println("5: Log Out");

                String option = scanner.nextLine();

                switch (option) {

                    case "1":
                        System.out.println("Enter the name of your tank.");
                        String tankName = scanner.nextLine();
                        Tank tank = new Tank(tankName,false);
                        tanks.add(tank);
                        break;

                    case "2":
                        System.out.println("Which tank would you like to check off as cleaned or not yet cleaned?");
                        int i = Integer.valueOf(scanner.nextLine());
                        Tank tank2 = tanks.get(i - 1);
                        tank2.hasBeenCleaned = !tank2.hasBeenCleaned;
                        break;

                    case "3":
//                        for (int t = 0; t < tanks.size(); t++) {
//                            Tank tank3 = tanks.get(t);
//                            int number = t + 1;
//                            String checkbox = " {Has not been cleaned.} ";
//                            if (tank3.hasBeenCleaned) {
//                                checkbox = " {Has been cleaned.} ";
//                            }
//                            System.out.printf("%s %s %s", checkbox, number, tank3.tankNames);
//                            System.out.println();
//                        }
                        break;

                    case "4":
                        System.out.println("Which tank would you like to remove?");
                        int removal = Integer.valueOf(scanner.nextLine());
                        tanks.remove(removal - 1);
                        break;

                    case "5":
                        isLoggedIn = false;
                        break;

                    default:
                        System.out.println("You can't do that!");
                        break;

                }

            }






        }









    }
}
