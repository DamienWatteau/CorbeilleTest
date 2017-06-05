package jpu2016.dogfight.model;

import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

class Mobile implements IMobile {

    private Direction direction;
    private final Position position;
    private final Dimension dimension;
    private final int speed;
    private IDogfightModel dogfightModel;
    private Image images[];

    public Mobile(final Direction direction, final Position position, final Dimension dimension, final int speed, final String image) {
        this.direction = direction;
        this.position = position;
        this.dimension = dimension;
        this.speed = speed;
        try {
            this.buildAllimages(image);
        } catch (final IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Direction getDirection() {
        return this.direction;
    }

    @Override
    public void setDirection(final Direction direction) {
        this.direction = direction;
    }

    @Override
    public Position getPosition() {
        return this.position;
    }

    @Override
    public Dimension getDimension() {
        return this.dimension;
    }

    @Override
    public void placeInArea(final IArea area) {
        this.position.setMaxX(area.getDimension().getWidth());
        this.position.setMaxY(area.getDimension().getHeight());
    }

    @Override
    public void move() {
        switch (this.direction) {
            case UP:
                this.moveUp();
                break;
            case RIGHT:
                this.moveRight();
                break;
            case DOWN:
                this.moveDown();
                break;
            case LEFT:
                this.moveLeft();
                break;
            default:
                break;
        }
    }

    private void moveUp() {
        this.position.setY(this.position.getY() - this.speed);
    }

    private void moveRight() {
        this.position.setX(this.position.getX() + this.speed);
    }

    private void moveDown() {
        this.position.setY(this.position.getY() + this.speed);
    }

    private void moveLeft() {
        this.position.setX(this.position.getX() - this.speed);
    }

    @Override
    public boolean isPlayer(final int player) {
        return false;
    }

    public IDogfightModel getDogfightModel() {
        return this.dogfightModel;
    }

    @Override
    public void setDogfightModel(final IDogfightModel dogfightModel) {
        this.dogfightModel = dogfightModel;
        this.getPosition().setMaxX(this.getDogfightModel().getArea().getDimension().getWidth());
        this.getPosition().setMaxY(this.getDogfightModel().getArea().getDimension().getHeight());
    }

    @Override
    public boolean hit() {
        return false;
    }

    @Override
    public boolean isWeapon() {
        return false;
    }

    @Override
    public int getWidth() {
        switch (this.direction) {
            case UP:
            case DOWN:
                return this.getDimension().getHeight();
            case RIGHT:
            case LEFT:
            default:
                return this.getDimension().getWidth();
        }
    }

    @Override
    public int getHeight() {
        switch (this.direction) {
            case UP:
            case DOWN:
                return this.getDimension().getWidth();
            case RIGHT:
            case LEFT:
            default:
                return this.getDimension().getHeight();
        }
    }

    @Override
    public int getSpeed() {
        return this.speed;
    }

    private void buildAllimages(final String imageName) throws IOException {
        this.images = new Image[4];
        this.images[Direction.UP.ordinal()] = ImageIO.read(new File("images/" + imageName + "_UP.png"));
        this.images[Direction.RIGHT.ordinal()] = ImageIO.read(new File("images/" + imageName + "_RIGHT.png"));
        this.images[Direction.DOWN.ordinal()] = ImageIO.read(new File("images/" + imageName + "_DOWN.png"));
        this.images[Direction.LEFT.ordinal()] = ImageIO.read(new File("images/" + imageName + "_LEFT.png"));
    }

    @Override
    public Image getImage() {
        return this.images[this.direction.ordinal()];
    }
}
