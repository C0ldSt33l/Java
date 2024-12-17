import App.AppBuilder;
import helpers.Point2D;

public class Main {
    public static void main(String[] args) {
        var app = new AppBuilder()
                .setWinTitle("Paint-like editor")
                .setWinSize(new Point2D(800, 600))
                .build();

        app.run();
    }
}