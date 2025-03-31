import java.io.PrintStream;
import java.util.Random;
import java.util.Scanner;

public class HolidayCamp {
    public String title;
    public Route[] routes;

    HolidayCamp(String title, Route[] routes){
        this.title = title;
        this.routes = routes;
    }

    HolidayCamp(Scanner in, PrintStream out){
        out.println("Input holiday camp from console");
        out.print("Title: ");
        this.title = in.next();
        
        out.print("Input number of routers");
        int n = in.nextInt();
        this.routes = new Route[n];
        for(int i=0; i<n; i++){
            this.routes[i] = new Route(in, out);
        }
    }

    HolidayCamp(Scanner in){
        this.title = in.next();
        int n = in.nextInt();
        this.routes = new Route[n];
        for(int i=0; i<n; i++){
            this.routes[i] = new Route(in);
        }
    }

    HolidayCamp(){
        this.title = Str.getRandomString(97, 123, 6);
        Random random = new Random(); 
        int n = random.nextInt(1, 5);
        this.routes = new Route[n];
        for(int i=0; i<n; i++){
            this.routes[i] = new Route();
        }    
    }

    public void print(){
        System.out.printf("Holiday camp %s:\n", this.title);
        for (Route route : this.routes) {
            route.print();
        }
    }

    public String toString(){
        return this.title;
    }
}
