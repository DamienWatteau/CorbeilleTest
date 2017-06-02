package jpu2016.gameframe;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Observable;

import javax.swing.JFrame;

import dogfight.view.DogfightView;

public class GameFrame extends JFrame implements KeyListener {

    protected IEventPerformer ieventPerformer;

    public GameFrame(String title, IEventPerformer performer, IGraphicsBuilder graphicsBuilder, Observable observable) {

    }

    public IEventPerformer getIEventPerformer() {
        return ieventPerformer;
    }

    public void setIEventPerformer(IEventPerformer ieventPerformer) {
        this.ieventPerformer = ieventPerformer;
        ieventPerformer.setGameFrame(this);
    }

    public void keyPressed(KeyEvent keyEvent) {

    }

    public void keyReleased(KeyEvent keyEvent) {

    }

    public void keyTyped(KeyEvent keyEvent) {

    }

    public void setDogfightView(DogfightView dogfightView) {
        // TODO Auto-generated method stub

    }
}
