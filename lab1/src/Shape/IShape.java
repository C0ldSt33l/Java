package Shape;

import helpers.Point2D;

import static com.raylib.Raylib.Color;

public interface IShape {
    Point2D getPos();
    Point2D getSize();
    Color getColor();

    void setPos(Point2D p);
    void setSize(Point2D s);
    void setColor(Color c);

    void draw();
}
