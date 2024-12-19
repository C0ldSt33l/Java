package App;

import Pallete.*;
import Shape.*;
import helpers.Point2D;
import com.raylib.Colors;
import com.raylib.Raylib.Color;

import static com.raylib.Raylib.*;
import static com.raylib.Raylib.CloseWindow;

public class App {
    private Shape selectedShape = null;
    private Color selectedColor = null;

    private Pallete<ColorElement> colorPallete;
    private Pallete<ShapeElement> shapePallete;


    public App(Point2D winSize, String winTitle) {
        InitWindow(winSize.x, winSize.y, winTitle);
        this.colorPallete = new Pallete<ColorElement>(
                new Point2D(50),
                new ColorElement[] {
                        new ColorElement(new Point2D(0), new Point2D(30), Colors.RED),
                        new ColorElement(new Point2D(0), new Point2D(30), Colors.GREEN),
                        new ColorElement(new Point2D(0), new Point2D(30), Colors.BLUE),
                },
               false
        );

        this.shapePallete = new Pallete<ShapeElement>(
                new Point2D(50, 200),
                new ShapeElement[]{
                        new ShapeElement(new Point2D(0), new Point2D(30), "rect"),
                        new ShapeElement(new Point2D(0), new Point2D(30), "circle"),
                },
                true
                );

    }

    public void run() {
        Shape[] shapes = new Shape[] {
                new Rect(new Point2D(100, 50) ,new Point2D(50), Colors.GREEN),
                new Circle(new Point2D(100, 50), new Point2D(50), Colors.YELLOW)
        };
        while (!WindowShouldClose()) {
            BeginDrawing();
            {
                ClearBackground(Colors.WHITE);
                this.colorPallete.draw();
                this.shapePallete.draw();
                for (var s : shapes) {
                    s.draw();
                }
            }
            EndDrawing();
        }

        CloseWindow();
    }
}
