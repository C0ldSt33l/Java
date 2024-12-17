package Shape;

import helpers.Point2D;

import static com.raylib.Raylib.*;

public class Rect implements IShape {
    private Point2D pos;
    private Point2D size;
    private Color col;

    public Rect(Point2D pos, Point2D size, Color c) {
        this.pos = pos;
        this.size = size;
        this.col = c;
    }

    @Override
    public Point2D getPos() {
        return this.pos;
    }

    @Override
    public Point2D getSize() {
        return this.size;
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
        this.size = s;
    }

    @Override
    public void setColor(Color c) {
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
