package Pallete;

import helpers.Clickable;
import helpers.Point2D;

public abstract class PalleteElement implements Clickable {
    protected Point2D pos;
    protected Point2D size;
    protected boolean isSelected = false;

    public PalleteElement(Point2D pos, Point2D size) {
        this.pos = pos;
        this.size = size;
    }

    public void makeSelected() {
        this.isSelected = true;
    }
    public void makeUnselected() {
        this.isSelected = false;
    }

    public Point2D getSize() {
        return this.size;
    }

    @Override
    public void onClick() {}
    @Override
    public boolean isPointInside() { return false; }


    public void draw() {

    }
}
