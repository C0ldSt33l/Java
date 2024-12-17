package Shape;

import helpers.Point2D;

import static com.raylib.Raylib.*;
import static com.raylib.Raylib.Color;


public class Circle implements IShape {
    private Point2D pos;
    private float radius;
    private Color col;

    public Circle(Point2D pos, float radius, Color c) {
        this.pos = pos;
        this.radius = radius;
        this.col = c;
    }

    @Override
    public Point2D getPos() {
        return this.pos;
    }

    @Override
    public Point2D getSize() {
        return null;
    }

    @Override
    public Color getColor() {
        return this.col;
    }

    @Override
    public void setPos(Point2D p) {
        this.pos = p;
    }

    @Override
    public void setSize(Point2D s) {
        this.radius = s.x / 2.0f;
    }

    @Override
    public void setColor(Color c) {
        this.col = c;
    }

    public float getRadius() {
        return this.radius;
    }

    public void setRadius(float r) {
        this.radius = r;
    }

    @Override
    public void draw() {
        DrawCircle(this.pos.x, this.pos.y, this.radius, this.col);
    }
}
