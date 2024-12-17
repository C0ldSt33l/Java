package Pallete;

import com.raylib.Colors;
import com.raylib.Raylib.Color;
import static com.raylib.Raylib.*;
import helpers.Point2D;

public class ColorElement extends PalleteElement {
    private Rectangle rect;
    private Color col;
    private float outlineThickness;

    public ColorElement(Point2D pos, Point2D size, Color c) {
        super(pos, size);
        this.col = c;
        this.rect = new Rectangle();
        this.rect.x(pos.x);
        this.rect.y(pos.y);
        this.rect.width(size.x);
        this.rect.height(size.y);

        this.outlineThickness = size.x / 10.0f;
    }

    @Override
    public void draw() {
        DrawRectangleRounded(this.rect, 0.2f, 4, this.col);
        DrawRectangleRoundedLinesEx(this.rect, 0.2f, 4, this.outlineThickness, Colors.BLACK);
    }
}
