package quotes;

import com.google.gson.Gson;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


import static org.junit.jupiter.api.Assertions.assertNotNull;

class AppTest {
    @Test
    void TestGson() throws IOException {
        URL oracle = new URL("https://codefellows.github.io/code-401-java-guide/curriculum/class-08/recentquotes.json");
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(oracle.openStream()));
        Gson gson = new Gson();
        Quote[] Quot = gson.fromJson(reader, Quote[].class);
        int ind;
        ind = (int) (Math.random() * Quot.length);
        String Author = Quot[ind].getAuthor();
        String Text = Quot[ind].getText();

        assertNotNull(String.valueOf(reader));
        assertNotNull(Author);
        assertNotNull(Text);
    }

    @Test
    void TestGsonApi() throws IOException {
        try {
            URL url = new URL("http://api.forismatic.com/api/1.0/?method=getQuote&format=json&lang=en");
            HttpURLConnection HttpURLConnection = (HttpURLConnection) url.openConnection();
            HttpURLConnection.setRequestMethod("GET");
            InputStreamReader InputStreamReader = new InputStreamReader(HttpURLConnection.getInputStream());
            BufferedReader bufferedReader = new BufferedReader(InputStreamReader);
            String Data = bufferedReader.readLine();
            Gson gson = new Gson();
            Favqoutes Quot1 = gson.fromJson(Data, Favqoutes.class);

            assertNotNull(Quot1.getAuthor());
            assertNotNull(Quot1.getBody());
            File file = new File("./file.json");
            try (FileWriter dittoFileWriter = new FileWriter(file)) {
                gson.toJson(Quot1, dittoFileWriter);
            }

        } catch (Exception e) {
            Gson gson2 = new Gson();
            Reader reader1 = Files.newBufferedReader(Paths.get("file.json"));
            Favqoutes Quot1 = gson2.fromJson(reader1, Favqoutes.class);
            assertNotNull(Quot1.getAuthor());
            assertNotNull(Quot1.getBody());
        }

    }

}
