package helpers;

import com.raylib.Raylib;

public class Point2D {
    public int x;
    public int y;

    public Point2D(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Point2D(int val) {
        this.x = val;
        this.y = val;
    }

    public Point2D plus(Point2D other) {
        return new Point2D(this.x + other.x, this.y + other.y);
    }
    public Point2D minus(Point2D other) {
        return new Point2D(this.x - other.x, this.y - other.y);
    }

    public Raylib.Vector2 toVector2() {
        var vec = new Raylib.Vector2();
        vec.x(this.x);
        vec.y(this.y);

        return vec;
    }

    @Override
    public String toString() {
        return "(" + this.x + ", " + this.y + ")";
    }
}
