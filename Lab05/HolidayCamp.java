import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Random;
import java.util.Scanner;

public class HolidayCamp {
    private String title;
    private ArrayList<Route> routes = new ArrayList<>();

    HolidayCamp(String title, ArrayList<Route> routes){
        this.title = title;
        this.routes = routes;
    }

    HolidayCamp(Scanner in, PrintStream out){
        out.println("Input holiday camp from console");
        out.print("Title: ");
        this.title = in.next();
        
        out.print("Input number of routers: ");
        int n = in.nextInt();
        this.routes = new ArrayList<>();
        for(int i=0; i<n; i++){
            this.routes.add(new Route(in, out));
        }
    }

    HolidayCamp(Scanner in){
        this.title = in.next();
        int n = in.nextInt();
        this.routes = new ArrayList<>();
        for(int i=0; i<n; i++){
            this.routes.add(new Route(in));
        }
    }

    HolidayCamp(){
        this.title = Str.getRandomString(97, 123, 6);
        Random random = new Random(); 
        int n = random.nextInt(1, 5);
        this.routes = new ArrayList<>();
        for(int i=0; i<n; i++){
            this.routes.add(new Route());
        }    
    }

    public void print(){
        System.out.printf("Holiday camp %s:\n", this.title);
        for (Route route : this.routes) {
            route.print();
        }
        System.out.println();
    }

    public void compareSort(){
        this.routes.sort(null);
    }

    public void comparatorSort(){
        Comparator<Route> comparator = new Comparator<Route>() {
            public int compare(Route route1, Route route2){
                return route2.getNumber().compareTo(route1.getNumber());
            }
        };
        this.routes.sort(comparator);
    }

    public void lambdaSort() {
        Comparator<Route> comparator = (route1, route2) -> route1.getNumber().compareTo(route2.getNumber());
        this.routes.sort(comparator);
    }

    public void destinationSort(){
        Comparator<Route> comparator = (route1, route2) -> route1.getPointOfDestination().compareTo(route2.getPointOfDestination());
        this.routes.sort(comparator);
    }

    public void departureSort(){
        Comparator<Route> comparator = (route1, route2) -> route1.getPointOfDeparture().compareTo(route2.getPointOfDeparture());
        this.routes.sort(comparator);
    }
}
