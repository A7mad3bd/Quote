package quotes;

public class Favqoutes {

    private String quoteAuthor;
    private String quoteText;

    public String getAuthor() {
        return quoteAuthor;
    }

    public String getBody() {
        return quoteText;
    }

    public Favqoutes(String quoteAuthor, String quoteText) {

        this.quoteAuthor = quoteAuthor;
        this.quoteText = quoteText;
    }

    @Override
    public String toString() {
        return "Favqoutes{" +
                "quoteAuthor='" + quoteAuthor + '\'' +
                ", quoteText='" + quoteText + '\'' +
                '}';
    }
}

