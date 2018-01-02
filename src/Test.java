import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class Test {
    public static void main(String[] args) {

        WeatherFileAssistant wfa = new WeatherFileAssistant();
        List <String> cities = null;
        List <WeatherInfo> weather = new LinkedList<>();
        WeatherApi api= null;

        try {
            cities = wfa.createListfromFile();
            System.out.println(cities);
            api = new WeatherApi();
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (String city : cities) {

            try {

                int temperature = api.getTemperature(city);
                String description = api.getDescription(city);
                System.out.printf("Pogoda w mieście %s: %s, ", city.toUpperCase(), description);
                System.out.printf("temp: %d stopni\n\n", temperature);
                weather.add(new WeatherInfo(city,description,temperature));
            } catch (IOException e) {
                System.err.println("Nie udało się pobrać informacji dla miasta " + city);
            }
        }


        wfa.writeToFile(weather);


    }
}
