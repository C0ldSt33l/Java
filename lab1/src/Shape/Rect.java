package Shape;

import helpers.Point2D;

import static com.raylib.Raylib.*;

public class Rect extends Shape {

    public Rect(Point2D pos, Point2D size, Color c) {
        super(pos, size, c);
        this.pos = pos;
        this.size = size;
        this.col = c;
    }

    @Override
    public void draw() {
        DrawRectangle(
                this.pos.x, this.pos.y,
                this.size.x, this.size.y,
                this.col
        );
    }
}
