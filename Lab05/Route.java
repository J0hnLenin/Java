import java.io.PrintStream;
import java.util.Scanner;

public class Route{
    public String pointOfDeparture;
    public String pointOfDestination; 
    public String number;

    Route(String pointOfDeparture, String pointOfDestination, String number){
        this.pointOfDeparture = pointOfDeparture;
        this.pointOfDestination = pointOfDestination;
        this.number = number;
    }

    Route(String pointOfDeparture, String pointOfDestination, int number){
        this.pointOfDeparture = pointOfDeparture;
        this.pointOfDestination = pointOfDestination;
        this.number = String.valueOf(number);
    }

    Route(Scanner in, PrintStream out){
        out.println("Input route from console");
        out.print("Point of departure: ");
        this.pointOfDeparture = in.next();
        out.print("Point of destination: ");
        this.pointOfDestination = in.next();
        out.print("Number: ");
        this.number = in.next();
    }

    Route(Scanner in){
        this.pointOfDeparture = in.next();
        this.pointOfDestination = in.next();
        this.number = in.next();
    }

    Route(){
        this.number = Str.getRandomString(97, 123, 2) + 
                    '-' + 
                    Str.getRandomString(48, 58, 5);
        this.pointOfDeparture = Str.getRandomString(97, 123, 4);
        this.pointOfDestination = Str.getRandomString(97, 123, 4);
    }

    public void print(){
        System.out.printf("Route № %s: %s - %s\n", 
            this.number, 
            this.pointOfDeparture, 
            this.pointOfDestination);
    }
}
