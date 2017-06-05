package jpu2016.dogfight.model;

public class Position {

    private int x;
    private int y;
    private int maxX = 1;
    private int maxY = 1;

    public Position(final int x, final int y) {
        this.x = x;
        this.y = y;
    }

    public Position(final Position position) {
        this(position.getX(), position.getY());
    }

    public int getX() {
        return this.x;
    }

    public void setX(final int x) {
        this.x = (x + this.maxX) % this.maxX;
    }

    public int getY() {
        return this.y;
    }

    public void setY(final int y) {
        this.y = (y + this.maxY) % this.maxY;
    }

    protected void setMaxX(final int maxX) {
        this.maxX = maxX;
    }

    protected void setMaxY(final int maxY) {
        this.maxY = maxY;
    }
}
