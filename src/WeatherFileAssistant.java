import java.io.*;
import java.util.LinkedList;
import java.util.List;

public class WeatherFileAssistant {

    private File citiesList;


    public WeatherFileAssistant() {

        citiesList = new File("Cities.txt");
        if (!citiesList.exists()){
            System.out.println("Brak pliku konfiguracyjnego");
        }
    }

    public List createListfromFile() throws IOException {
        FileReader fr = new FileReader(citiesList);
        BufferedReader br = new BufferedReader(fr);
        List <String> citiesList = new LinkedList();
        String city = null;
        while ((city = br.readLine()) != null){
            citiesList.add(city);
        }
        return citiesList;
    }

    public void writeToFile(List<WeatherInfo> list){
        File weather = new File("Weather.csv");
        BufferedWriter bw = null;

        if (!weather.exists()){
            try {
                weather.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        try {
            FileWriter fw = new FileWriter(weather);
            bw = new BufferedWriter(fw);
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (WeatherInfo weatherInfo : list) {
            try {
                bw.write(weatherInfo.toString()+"\n");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try {
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}
