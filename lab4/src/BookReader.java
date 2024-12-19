import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class BookReader {
    private String path;
    private BookStatistic statistic;

    public BookReader(String path) {
        this.path = path;
        this.statistic = new BookStatistic(path);
    }

    public void read() throws IOException {
        var path = Paths.get(this.path);
        var lines = Files.lines(path);

        var charMap = new HashMap<Character,Integer>();
        lines.forEach(l -> {
            var words = Pattern.compile("[\\s.,\\/\\(\\):\\n]+").splitAsStream(l);
            words.forEach(w -> {
                try {
                    var _ = Integer.parseInt(w);
                    this.statistic.numberCount++;
                }
                catch (Exception e) {
                    if (w.length() > this.statistic.theLongestWord.length()) this.statistic.theLongestWord = w;
                    if (w.length() < this.statistic.theShortestWord.length()) this.statistic.theShortestWord = w;
                    this.statistic.wordCount++;
                }
            });

            Stream<Character> chars = l.chars().mapToObj(i -> (char)i);
            chars.forEach(c -> {
                if (charMap.containsKey(c)) {
                    charMap.compute(c, (k, v) -> v + 1);
                } else {
                    charMap.put(c, 1);
                }
                this.statistic.charCount++;
            });
        });
        for (var pair : charMap.entrySet()) {
            System.out.println("key: " + pair.getKey() + " val: " + pair.getValue());
        }

        var theMostCommonChar = Collections.max(charMap.entrySet(), Map.Entry.comparingByValue());
        this.statistic.setTheMostCommonChar(theMostCommonChar.getKey(), theMostCommonChar.getValue());
        var theMostHiddenChar = Collections.min(charMap.entrySet(), Map.Entry.comparingByValue());
        this.statistic.setTheMostRareChar(theMostHiddenChar.getKey(), theMostHiddenChar.getValue());

    }

    public BookStatistic getStatistic() {
        return this.statistic;
    }
}
