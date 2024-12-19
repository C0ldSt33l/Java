package Pallete;

import Shape.*;
import com.raylib.Colors;
import helpers.Drawable;
import helpers.Point2D;

import static com.raylib.Raylib.DrawRectangleRounded;
import static com.raylib.Raylib.DrawRectangleRoundedLinesEx;

public class ShapeElement extends PalleteElement implements Drawable {
    private float outlineThickness;
    private Shape shape;

    public ShapeElement(Point2D pos, Point2D size, String shape) {
        super(pos, size);
        this.outlineThickness = size.x / 10.0f;
        var offset = new Point2D(size.x / 100 * 5);
        var shapeSize = size.minus(offset);
        var shapePos = pos.plus(offset);

        this.shape = ShapeFactory.createShape(shape, shapePos, shapeSize, Colors.RED);
    }

    @Override
    public void setPos(Point2D p) {
        super.setPos(p);
        var offset = new Point2D(this.getSize().x / 100 * 5);
        this.shape.setPos(this.getPos().plus(offset));
    }

    @Override
    public void draw() {
        DrawRectangleRounded(this.rect, 0.2f, 4, Colors.GRAY);
        DrawRectangleRoundedLinesEx(this.rect, 0.2f, 4, this.outlineThickness, Colors.BLACK);
        this.shape.draw();
    }
}
