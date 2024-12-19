package Pallete;

import static com.raylib.Raylib.*;

import com.raylib.Colors;
import helpers.Point2D;

public class Pallete<E extends PalleteElement> {
    private Rectangle rect = new Rectangle();

    private E[] elements;
    private E selected = null;
    private boolean isHorizontal;
    private int elemSep = 8;
    private int widthSep = 5;

    public Pallete(Point2D pos, E[] elems, boolean isHorizontal) {
        this.elements = elems;
        this.isHorizontal = isHorizontal;

        this.rect.x(pos.x);
        this.rect.y(pos.y);


        var width = elems.length * elems[0].getSize().x + (elems.length - 1) * this.elemSep + 2 * this.elemSep / 2;
        var height = elems[0].getSize().y + 2 * this.widthSep;

        var starPos = this.getPos();

        Point2D dist;
        if (isHorizontal) {
           this.rect.width(width);
           this.rect.height(height);
           starPos = starPos.plus(new Point2D(this.elemSep / 2, this.widthSep));
           dist = new Point2D(elems[0].getSize().x + this.elemSep, 0);
        } else {
            this.rect.width(height);
            this.rect.height(width);
            starPos = starPos.plus(new Point2D(this.widthSep, this.elemSep / 2));
            dist = new Point2D(0, elems[0].getSize().x + this.elemSep);
        }

        for (var el : this.elements) {
            el.setPos(starPos);
            starPos = starPos.plus(dist);
        }
    }

    public void update() {

    }

    public void chooseElement(E el) {
        if (this.selected != null) this.selected.makeUnselected();
        this.selected = el;
        this.selected.makeSelected();
    }

    public Point2D getPos() {
        return new Point2D((int)this.rect.x() ,(int)this.rect.y());
    }

    public void draw() {
        DrawRectangleRounded(this.rect, 0.2f, 4, Colors.GRAY);
        DrawRectangleRoundedLinesEx(this.rect, 0.2f, 4, 3f, Colors.BLACK);
        for (var el : this.elements) {
            el.draw();
        }
    }
}
