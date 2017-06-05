package jpu2016.dogfight.view;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Transparency;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;

import jpu2016.dogfight.model.IDogfightModel;
import jpu2016.dogfight.model.IMobile;
import jpu2016.gameframe.IGraphicsBuilder;

class GraphicsBuilder implements IGraphicsBuilder {

    private final IDogfightModel dogfightModel;
    private BufferedImage emptySky;

    public GraphicsBuilder(final IDogfightModel dogfightModel) {
        this.dogfightModel = dogfightModel;
        this.buildEmptySky();
    }

    @Override
    public void applyModelToGraphic(final Graphics graphics, final ImageObserver observer) {
        graphics.drawImage(this.emptySky, 0, 0, observer);

        for (final IMobile mobile : this.dogfightModel.getMobiles()) {
            this.drawMobile(mobile, graphics, observer);
        }
    }

    @Override
    public int getGlobalWidth() {
        return this.dogfightModel.getArea().getWidth();
    }

    @Override
    public int getGlobalHeight() {
        return this.dogfightModel.getArea().getHeight();
    }

    private void buildEmptySky() {
        this.emptySky = new BufferedImage(this.dogfightModel.getArea().getWidth(), this.dogfightModel.getArea().getHeight(), BufferedImage.TYPE_INT_RGB);
        final Graphics2D graphics = (Graphics2D) this.emptySky.getGraphics();
        graphics.drawImage(this.dogfightModel.getArea().getImage(), 0, 0, this.dogfightModel.getArea().getWidth(), this.dogfightModel.getArea().getHeight(), null);
    }

    private void drawMobile(final IMobile mobile, final Graphics graphics, final ImageObserver observer) {
        final BufferedImage imageMobile = new BufferedImage(mobile.getWidth(), mobile.getHeight(), Transparency.TRANSLUCENT);
        final Graphics graphicsMobile = imageMobile.getGraphics();

        graphicsMobile.drawImage(mobile.getImage(), 0, 0, mobile.getWidth(), mobile.getHeight(), observer);
        graphics.drawImage(imageMobile, mobile.getPosition().getX(), mobile.getPosition().getY(), observer);

        final boolean isHorizontalOut = (mobile.getPosition().getX() + mobile.getWidth()) > this.dogfightModel.getArea().getWidth();
        final boolean isVerticalOut = (mobile.getPosition().getY() + mobile.getHeight()) > this.dogfightModel.getArea().getHeight();

        if (isHorizontalOut) {
            final BufferedImage imageMobileH = imageMobile.getSubimage(this.dogfightModel.getArea().getWidth() - mobile.getPosition().getX(), 0,
                    (mobile.getWidth() - this.dogfightModel.getArea().getWidth()) + mobile.getPosition().getX(), mobile.getHeight());
            graphics.drawImage(imageMobileH, 0, mobile.getPosition().getY(), observer);
        }

        if (isVerticalOut) {
            final BufferedImage imageMobileV = imageMobile.getSubimage(0, this.dogfightModel.getArea().getHeight() - mobile.getPosition().getY(), mobile.getWidth(),
                    (mobile.getHeight() - this.dogfightModel.getArea().getHeight()) + mobile.getPosition().getY());
            graphics.drawImage(imageMobileV, mobile.getPosition().getX(), 0, observer);
        }

        if (isHorizontalOut && isVerticalOut) {
            final BufferedImage imageMobileHV = imageMobile.getSubimage(this.dogfightModel.getArea().getWidth() - mobile.getPosition().getX(),
                    this.dogfightModel.getArea().getHeight() - mobile.getPosition().getY(),
                    (mobile.getWidth() - this.dogfightModel.getArea().getWidth()) + mobile.getPosition().getX(),
                    (mobile.getHeight() - this.dogfightModel.getArea().getHeight()) + mobile.getPosition().getY());
            graphics.drawImage(imageMobileHV, 0, 0, observer);
        }
    }
}
