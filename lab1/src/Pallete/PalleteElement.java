package Pallete;

import com.raylib.Raylib;
import helpers.Clickable;
import helpers.Point2D;

public abstract class PalleteElement implements Clickable {
    protected Raylib.Rectangle rect = new Raylib.Rectangle();
    protected boolean isSelected = false;

    public PalleteElement(Point2D pos, Point2D size) {
        this.rect.x(pos.x);
        this.rect.y(pos.y);
        this.rect.width(size.x);
        this.rect.height(size.y);
    }

    public void makeSelected() {
        this.isSelected = true;
    }
    public void makeUnselected() {
        this.isSelected = false;
    }

    public Point2D getPos() {
        return new Point2D((int)this.rect.x() ,(int)this.rect.y());
    }
    public Point2D getSize() {
        return new Point2D((int)this.rect.width(), (int)this.rect.height());
    }

    public void setPos(Point2D pos) {
        this.rect.x(pos.x);
        this.rect.y(pos.y);
    }
    public void setSize(Point2D size) {
        this.rect.width(size.x);
        this.rect.height(size.y);
    }

    @Override
    public void onClick() {}
    @Override
    public boolean isPointInside() { return false; }


    public void draw() {

    }
}
