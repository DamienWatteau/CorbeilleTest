package jpu2016.dogfight.model;

public class Missile extends Mobile {

    private static int SPEED = 4;
    private static int WIDTH = 30;
    private static int HEIGHT = 10;
    private static int MAX_DISTANCE_TRAVELED = 1400;
    private static String IMAGE = "missile";

    private int distanceTraveled = 0;

    public Missile(final Direction direction, final Position position) {
        super(direction, position, new Dimension(WIDTH, HEIGHT), SPEED, IMAGE);
    }

    public static int getWidthWithADirection(final Direction direction) {
        switch (direction) {
            case UP:
            case DOWN:
                return HEIGHT;
            case RIGHT:
            case LEFT:
            default:
                return WIDTH;
        }
    }

    public static int getHeightWithADirection(final Direction direction) {
        switch (direction) {
            case UP:
            case DOWN:
                return WIDTH;
            case RIGHT:
            case LEFT:
            default:
                return HEIGHT;
        }
    }

    @Override
    public void move() {
        this.distanceTraveled += SPEED;
        if (this.distanceTraveled >= MAX_DISTANCE_TRAVELED) {
            this.getDogfightModel().removeMobile(this);
        }
        super.move();
    }

    @Override
    public boolean isWeapon() {
        return true;
    }

}
