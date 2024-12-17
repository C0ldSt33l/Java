package Pallete;

import static com.raylib.Raylib.*;

import com.raylib.Colors;
import helpers.Point2D;

public class Pallete<E extends PalleteElement> {
    private Rectangle rect;

    private E[] elements;
    private E selected = null;
    private boolean isHorizontal;
    private int sepSize = 10;
    private int widthSep = 2;

    public Pallete(Point2D pos, E[] elems, boolean isHorizontal) {
        this.elements = elems;
        this.isHorizontal = isHorizontal;

        this.rect = new Rectangle();
        this.rect.x(pos.x);
        this.rect.y(pos.y);
        if (isHorizontal) {
            this.rect.width(elems.length * elems[0].getSize().x + (elems.length + 2) * this.sepSize);
            this.rect.height(elems[0].getSize().y + 2 * this.widthSep);

            var sep = new Point2D(sepSize, 0);
            var elSize = new Point2D(elems[0].size.x, 0);
            var startPos =
                    new Point2D((int)this.rect.x(), (int)this.rect.y())
                    .plus(new Point2D(elems[0].getSize().x, this.widthSep));
            for (var i = 0; i < this.elements.length; i++) {
                System.out.println(startPos.toString());
                this.elements[i].pos = startPos;
                System.out.println(this.elements[i].pos);
                startPos = startPos.plus(elSize).plus(sep);
            }
        }
    }

    public void update() {

    }

    public void chooseElement(E el) {
        if (this.selected != null) this.selected.makeUnselected();
        this.selected = el;
        this.selected.makeSelected();
    }

    public void draw() {
//        DrawRectangleRounded(this.rect, 0.5f, 0, Colors.GRAY);
//        DrawRectangleRoundedLines(this.rect, 0.5f, 0, Colors.BLACK);
        for (var el : this.elements) {
            el.draw();
        }
    }
}
