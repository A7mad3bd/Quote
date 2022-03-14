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

            URL Url = new URL("http://api.forismatic.com/api/1.0/?method=getQuote&format=json&lang=en");
            HttpURLConnection HttpURLConnection = (HttpURLConnection) Url.openConnection();
            HttpURLConnection.setRequestMethod("GET");
            InputStreamReader InputStreamReader = new InputStreamReader(HttpURLConnection.getInputStream());
            BufferedReader BufferedReader = new BufferedReader(InputStreamReader);
            String Data = BufferedReader.readLine();
            System.out.println(Data);
            Gson gson = new Gson();
            Favqoutes Quote = gson.fromJson(Data, Favqoutes.class);
            System.out.println(Quote);
            File dittoFile = new File("./ditto.json");
            try (FileWriter dittoFileWriter = new FileWriter(dittoFile)) {
                gson.toJson(Quote, dittoFileWriter);

            }
        } catch (Exception e) {
            Gson gson2 = new Gson();
            Reader reader1 = Files.newBufferedReader(Paths.get("C:\\Users\\Ahmad Abdallah\\Desktop\\401\\Quote\\app\\src\\test\\java\\quotes\\ditto.json"));
            Favqoutes Quot1 = gson2.fromJson(reader1, Favqoutes.class);
            System.out.println("Author" + Quot1.getAuthor());
            System.out.println("Quot" + Quot1.getBody());
            assertNotNull(Quot1.getAuthor());
            assertNotNull(Quot1.getBody());
        }

    }

}
