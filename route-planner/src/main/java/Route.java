public class Route {
    private final String fromCity;
    private final String toCity;
    private final int dist;
    private final String time;
     private final String fare;
    public Route(String fromCity, String toCity, int dist, String time, String fare) {
        this.fromCity = fromCity;
        this.toCity = toCity;
        this.dist = dist;
        this.time = time;
        this.fare = fare;
    }
    public String getFromCity() {
        return fromCity;
    }
    public String getToCity() {
        return toCity;
    }
    @Override
    public String toString() {
        return "Route{" +
                "fromCity='" + fromCity + '\'' +
                ", toCity='" + toCity + '\'' +
                ", dist=" + dist +
                ", time='" + time + '\'' +
                ", fare='" + fare + '\'' +
                '}';
    }



}
