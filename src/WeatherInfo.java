public class WeatherInfo {

    private String city;
    private String description;
    private int temp;

    public WeatherInfo(String city, String description, int temp) {
        this.city = city;
        this.description = description;
        this.temp = temp;
    }

    @Override
    public String toString() {
        String result = city+";"+description+";"+temp+";";
        return result;
    }
}
