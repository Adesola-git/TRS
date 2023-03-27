package AirportPack;
import java.util.InputMismatchException;
import java.util.Scanner;


public class Client {
    static String id;
    static String name;
    static String country;
    static Integer timeZone;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String error = "Invalid input, try again";

        System.out.println("Welcome To Flight Reservation");
        System.out.println("---------------------------------");
        System.out.println("Enter The Airport ID: ");
        id = nextLine(scan,error);
        System.out.println("Enter Name Of Airport: ");
        name = nextLine(scan,error);
        System.out.println("Enter Country of Airport: ");
        country = nextLine(scan,error);
        System.out.println("Enter Timezone of Airport: ");
        timeZone = nextInt(scan,error);

        Airport airportA = new Airport(id, name, country, timeZone);
//        Airport airportB = new Airport("LOS","Muritala M","Nigeria",100);

        Terminal terminalA1 = new Terminal("A1");
        Terminal terminalA2 = new Terminal("A2");
        Terminal terminalB1 = new Terminal("B1");

        airportA.add(terminalA1);
        airportA.add(terminalA2);
//        airportB.add(terminalB1);

        airportA.display();
//        airportB.display();


    }

    public static String nextLine(Scanner scan, String error){
        // loop forever
        for (; ; ) {
            try {
                String v = scan.nextLine();
                return v;
            } catch (InputMismatchException ie) {
                scan.nextLine(); // clear input buffer
                System.out.print(error);

            }

        }


    }

    public static Integer nextInt(Scanner scan, String error){
        // loop forever
        for (; ; ) {
            try {
                int v = scan.nextInt();
                return v;
            } catch (InputMismatchException ie) {
                scan.nextLine(); // clear input buffer
                System.out.print(error);

            }

        }


    }

}
