package jpu2016.dogfight.model;

import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

class Sky implements IArea {

    private static String IMAGE = "sky.png";
    private final Dimension dimension;
    private Image image;

    public Sky(final Dimension dimension) {
        this.dimension = dimension;
        try {
            this.image = ImageIO.read(new File("images/" + IMAGE));
        } catch (final IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Dimension getDimension() {
        return this.dimension;
    }

    @Override
    public int getWidth() {
        return this.getDimension().getWidth();
    }

    @Override
    public int getHeight() {
        return this.getDimension().getHeight();
    }

    @Override
    public Image getImage() {
        return this.image;
    }
}
