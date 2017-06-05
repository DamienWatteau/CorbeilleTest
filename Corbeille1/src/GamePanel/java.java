package jpu2016.gameframe;

import java.awt.Graphics;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;

class GamePanel extends JPanel implements Observer {

    private static final long serialVersionUID = 3987064896591403626L;
    private final IGraphicsBuilder graphicsBuilder;

    public GamePanel(final IGraphicsBuilder graphicsBuilder) {
        this.graphicsBuilder = graphicsBuilder;
    }

    @Override
    public void update(final Observable arg0, final Object arg1) {
        this.repaint();
    }

    @Override
    protected void paintComponent(final Graphics graphics) {
        this.graphicsBuilder.applyModelToGraphic(graphics, this);
    }

}