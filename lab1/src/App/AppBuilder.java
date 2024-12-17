package App;

import helpers.Point2D;

public class AppBuilder {
    private Point2D winSize;
    private String winTitle;

    public AppBuilder() {
            this
                .setWinSize(new Point2D(800, 600))
                .setWinTitle("Paint-like editor");
    }

    public AppBuilder setWinSize(Point2D s) {
        this.winSize = s;
        return this;
    }

    public AppBuilder setWinTitle(String title) {
        this.winTitle = title;
        return this;
    }

    public App build() {
        return new App(this.winSize, this.winTitle);
    }
}
