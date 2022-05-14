import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class Routeprog {
    public static final String YELLOW_BOLD = "\033[1;33m";
    public static final String RED_BRIGHT = "\033[0;91m";

    int count(String path){
        int word=0;
        try {
            BufferedReader bf = new BufferedReader(new FileReader(path));
            while (bf.readLine() != null) {
                word++;
            }
        }
        catch(IOException e){
            System.err.println(e.getMessage());
        }
        return word;
    }

    Route[] readDataFromFile(String path){
        Route[] routes=new Route[count(path)];
        try {
            BufferedReader bf = new BufferedReader(new FileReader(path));
            String line;
            int i = 0;
            while ((line = bf.readLine()) != null) {
                String[] arr = line.split(", ");
                Route r = new Route(arr[0],arr[1], Integer.parseInt(arr[2]), arr[3], arr[4]);
                routes[i] = r;
                i++;
            }
        }
        catch (IOException ioe){
            System.err.println(ioe.getMessage());
        }
        return routes;
    }

    void display(Route[] routes){
        System.out.println(YELLOW_BOLD+"From \t To \t Distance In Km \t  Timing \t Typical Airfare");
        for(Route i:routes){
            System.out.println(RED_BRIGHT+""+i);
        }
    }

    Route[] fetchFlightsFromCity(Route[] routes, String fromCity){
        int size=0;
        for(Route i:routes){
            if(i.getFromCity().equalsIgnoreCase(fromCity)){
                size++;
            }
        }
        Route[] flightfromcity=new Route[size];
        int j=0;
        for(Route i:routes){
            if(i.getFromCity().equalsIgnoreCase(fromCity)){
                    flightfromcity[j]=i;
                    j++;

                }
            }

        return flightfromcity;
    }

    Route[] sortFetchedFlights(Route[] fetchedFlight, String fromCity){
        for(int pass=1;pass< fetchedFlight.length;pass++){
            for(int i=0;i<fetchedFlight.length-pass;i++){
                if(fetchedFlight[i].getToCity().compareToIgnoreCase(fetchedFlight[i+1].getToCity())>0){
                    Route temp=fetchedFlight[i];
                    fetchedFlight[i]=fetchedFlight[i+1];
                    fetchedFlight[i+1]=temp;
                }
            }
        }
        return fetchedFlight;
    }
     void flightfromdesiredlocation(Route[] routes,String fromCity,String tooCity) {
          int z=0;

           for (Route i : routes) {
            if (i.getFromCity().equalsIgnoreCase(fromCity) && i.getToCity().equalsIgnoreCase(tooCity)) {

                 System.out.println(i);

                 break;

        }}


            for (Route l : routes) {
            if (l.getFromCity().equalsIgnoreCase(fromCity)) {
                String temp = l.getToCity();

                for (Route k : routes) {

                    if (k.getFromCity().equalsIgnoreCase(temp) && k.getToCity().equalsIgnoreCase(tooCity)) {
                        flightfromdesiredlocation(routes, fromCity, temp);
                        flightfromdesiredlocation(routes, temp, tooCity);


            } }
            }
        }
    }}