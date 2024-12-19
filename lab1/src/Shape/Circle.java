package Shape;

import helpers.Point2D;

import static com.raylib.Raylib.*;
import static com.raylib.Raylib.Color;


public class Circle extends Shape {
    private float radius;

    public Circle(Point2D pos, Point2D size, Color c) {
        super(pos, size, c);
        this.radius = size.x / 2.0f;
    }


    public float getRadius() {
        return this.radius;
    }

    public void setRadius(float r) {
        this.size = new Point2D((int)(r * 2));
        this.radius = r;
    }

    @Override
    public void draw() {
        var position = this.pos.plus(this.pos.div(2));
        DrawCircle(position.x , position.y, this.radius, this.col);
    }
}
