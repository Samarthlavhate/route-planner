import java.util.Scanner;
public class Routemain {
    public static final String BLUE_BRIGHT = "\033[0;94m";
    public static void main(String[] args) {
        Routeprog rp=new Routeprog();
        rp.display(rp.readDataFromFile("src/main/resources/routes.csv"));
        Scanner sc = new Scanner(System.in);
        System.out.print(BLUE_BRIGHT+"Enter the  Name of city: ");
        String fromCity=sc.nextLine();
        System.out.println(BLUE_BRIGHT+"flight from your location");
        rp.display(rp.fetchFlightsFromCity(rp.readDataFromFile("src/main/resources/routes.csv"),fromCity));
        rp.sortFetchedFlights(rp.fetchFlightsFromCity(rp.readDataFromFile("src/main/resources/routes.csv"),fromCity), fromCity);
        System.out.println(BLUE_BRIGHT+"sorted flights list");
        rp.display(rp.sortFetchedFlights(rp.fetchFlightsFromCity(rp.readDataFromFile("src/main/resources/routes.csv"),fromCity), fromCity));
        System.out.println(BLUE_BRIGHT+"Enter the your destination");
        String tooCity=sc.nextLine();
        System.out.println(BLUE_BRIGHT+"Available flight");
        rp.flightfromdesiredlocation(rp.readDataFromFile("src/main/resources/routes.csv"),fromCity,tooCity);
    }
}