package Shape;

import com.raylib.Raylib;
import helpers.Point2D;

public class ShapeFactory {
    public static Shape createShape(String shape, Point2D pos, Point2D size, Raylib.Color c) {
         switch (shape.toLowerCase()) {
            case "rect": return new Rect(pos, size, c);
            case "circle": return new Circle(pos, size, c);
        }

        System.out.println("ERROR WHILE CREATE FIGURE");
        return null;
    }
}
