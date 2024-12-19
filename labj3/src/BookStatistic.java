import java.util.stream.Collectors;
import java.util.stream.Stream;

public class BookStatistic {
    public String bookName;
    public int wordCount = 0;
    public String theLongestWord = "";
    public String theShortestWord = Stream.generate(() -> "?").limit(1000).collect(Collectors.joining(""));

    public int charCount = 0;
    public char theMostCommonChar;
    public char theMostRareChar;

    public int theMostCommonCharMatches = 0;
    public int theMostRareCharMatches = 0;

    public int numberCount = 0;

    public BookStatistic(String bookName) {
        this.bookName = bookName;
    }

    public void setTheMostCommonChar(char c, int matches) {
        this.theMostCommonChar = c;
        this.theMostCommonCharMatches = matches;
    }

    public void setTheMostRareChar(char c, int matches) {
        this.theMostRareChar = c;
        this.theMostRareCharMatches = matches;
    }

    @Override
    public String toString() {
        return String.format(
                "Book: %s\nWord count: %d\nThe longest word: %s\nThe shortest word: %s\nChar count: %d\nThe most common char: \"%c\" - %d\nThe most rare char: \"%c\" - %d\nNumber count: %d\n",
                this.bookName,
                this.wordCount,
                this.theLongestWord,
                this.theShortestWord,
                this.charCount,
                this.theMostCommonChar, this.theMostCommonCharMatches,
                this.theMostRareChar, this.theMostRareCharMatches,
                this.numberCount
                );
    }
}
