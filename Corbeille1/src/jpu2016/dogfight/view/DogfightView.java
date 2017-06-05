package jpu2016.dogfight.view;

import java.util.Observable;

import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

import jpu2016.dogfight.controller.IOrderPerformer;
import jpu2016.dogfight.model.IDogfightModel;
import jpu2016.gameframe.GameFrame;

public class DogfightView implements IViewSystem, Runnable {

    private final GraphicsBuilder graphicsBuilder;
    private final EventPerformer eventPerformer;
    private final Observable observable;
    private GameFrame gameFrame;

    public DogfightView(final IOrderPerformer orderPerformer, final IDogfightModel dogfightModel, final Observable observable) {
        this.observable = observable;
        this.graphicsBuilder = new GraphicsBuilder(dogfightModel);
        this.eventPerformer = new EventPerformer(orderPerformer);
        SwingUtilities.invokeLater(this);
    }

    @Override
    public void run() {
        this.gameFrame = new GameFrame("Dogfight", this.eventPerformer, this.graphicsBuilder, this.observable);
    }

    @Override
    public void displayMessage(final String message) {
        JOptionPane.showMessageDialog(null, message);
    }

    @Override
    public void closeAll() {
        this.gameFrame.dispose();
    }
}
