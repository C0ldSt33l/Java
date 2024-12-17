package App;

import Pallete.*;
import Shape.Circle;
import Shape.IShape;
import helpers.Point2D;
import Shape.Rect;
import com.raylib.Colors;
import com.raylib.Raylib.Color;

import static com.raylib.Raylib.*;
import static com.raylib.Raylib.CloseWindow;

public class App {
    private IShape selectedShape = null;
    private Color selectedColor = null;

    private Pallete<ColorElement> colorPallete;


    public App(Point2D winSize, String winTitle) {
        InitWindow(winSize.x, winSize.y, winTitle);
        this.colorPallete = new Pallete<ColorElement>(
                new Point2D(50),
                new ColorElement[] {
                        new ColorElement(new Point2D(500), new Point2D(30), Colors.RED),
                        new ColorElement(new Point2D(400), new Point2D(30), Colors.GREEN),
                        new ColorElement(new Point2D(300), new Point2D(30), Colors.BLUE),
                },
                true
        );
    }

    public void run() {
        var shapes = new IShape[] {
                new Rect(new Point2D(50), new Point2D(100), Colors.BLACK),
                new Circle(new Point2D(400, 50), 50, Colors.DARKBLUE),
        };


        while (!WindowShouldClose()) {
            BeginDrawing();
            {
                ClearBackground(Colors.WHITE);
                this.colorPallete.draw();
            }
            EndDrawing();
        }

        CloseWindow();
    }
}
