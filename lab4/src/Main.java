import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        var reader = new BookReader("D:\\Univer\\Java\\lab4\\text\\text.txt");
        try {
            reader.read();
            System.out.println(reader.getStatistic());
        }
        catch (IOException e) {
            System.out.println("YOU GOT EXCEPTION");
            System.out.println(e.getCause());
        }
    }
}