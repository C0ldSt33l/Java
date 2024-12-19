package Shape;

import helpers.Drawable;
import helpers.Movable;
import helpers.Point2D;
import helpers.Sizable;

import static com.raylib.Raylib.Color;

public abstract class Shape
implements Drawable, Sizable, Movable {
    protected Point2D pos;
    protected Point2D size;
    protected Color col;

    public Shape(Point2D pos, Point2D size, Color c) {
        this.pos = pos;
        this.size = size;
        this.col = c;
    }

    @Override
    public void setPos(Point2D p) {
        this.pos = p;
    }
    @Override
    public void setSize(Point2D s) {
        this.size = s;
    }
    public void setColor(Color c) {
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
    public Color getColor() {
        return this.col;
    }

    @Override
    public void draw() {}

}
