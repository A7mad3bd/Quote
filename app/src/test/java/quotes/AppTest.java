package quotes;
import com.google.gson.Gson;
import org.junit.jupiter.api.Test;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
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

}
