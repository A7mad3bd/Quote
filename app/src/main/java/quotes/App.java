package quotes;

import com.google.gson.Gson;


import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;

public class App {
    public static void main(String[] args) throws IOException {
        try {
            URL ex = new URL("https://codefellows.github.io/code-401-java-guide/curriculum/class-08/recentquotes.json");
            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(ex.openStream()));
            Gson gson1 = new Gson();
            Quote[] Quot = gson1.fromJson(reader, Quote[].class);
            int ind;
            ind = (int) (Math.random() * Quot.length);
            String Author = Quot[ind].getAuthor();
            String Text = Quot[ind].getText();
            System.out.println("Author : " + Author + "\nQuote :  " + Text + " ");
        } catch (Exception e) {
        }

        System.out.println("///////////Lab-9////////////");

        try {
            URL url = new URL("http://api.forismatic.com/api/1.0/?method=getQuote&format=json&lang=en");
            HttpURLConnection HttpURLConnection = (HttpURLConnection) url.openConnection();
            HttpURLConnection.setRequestMethod("GET");
            InputStreamReader InputStreamReader = new InputStreamReader(HttpURLConnection.getInputStream());
            BufferedReader bufferedReader = new BufferedReader(InputStreamReader);
            String Data = bufferedReader.readLine();

            Gson gson = new Gson();
            Favqoutes Quot1 = gson.fromJson(Data, Favqoutes.class);
            System.out.println("From URL");
            System.out.println(Quot1.getAuthor());
            System.out.println(Quot1.getBody());

            File file = new File("./file.json");
            try (FileWriter dittoFileWriter = new FileWriter(file)) {
                gson.toJson(Quot1, dittoFileWriter);
            }

        } catch (Exception e) {
            Gson gson2 = new Gson();
            Reader reader1 = Files.newBufferedReader(Paths.get("file.json"));
            Favqoutes Quot1 = gson2.fromJson(reader1, Favqoutes.class);
            System.out.println("From File");
            System.out.println(Quot1.getAuthor());
            System.out.println(Quot1.getBody());
        }
    }
}
