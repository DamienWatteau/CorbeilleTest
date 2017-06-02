package jpu2016.gameframe;

import java.awt.Graphics;
import java.awt.image.ImageObserver;

public interface IGraphicsBuilder {

    public void applyModelToGraphic(Graphics graphics, ImageObserver observer);

    public int getWidth();

    public int getHeight();

    public void setGamePanel(GamePanel gamePanel);

}
