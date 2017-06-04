package jpu2016.dogfight.view;

import java.lang.Runnable;
import java.util.Observable;

import jpu2016.gameframe.GameFrame;
import jpu2016.gameframe.IEventPerformer;
import jpu2016.gameframe.IGraphicsBuilder;
import jpu2016.dogfight.controller.IOrderPerformer;
import jpu2016.dogfight.model.IDogfightModel;

public class DogfightView implements IViewSystem, Runnable {

    protected GraphicsBuilder graphicsBuilder;
    protected EventPerformer eventPerformer;
    protected GameFrame gameFrame;
    protected IEventPerformer performer;
    String title;

    public DogfightView(IOrderPerformer orderPerformer, IDogfightModel dogfight, Observable observable) {

        this.graphicsBuilder = new GraphicsBuilder(dogfight);
        this.graphicsBuilder.setDogfightView(this);

        this.eventPerformer = new EventPerformer(orderPerformer);
        this.eventPerformer.setDogfightView(this);

        this.gameFrame = new GameFrame(title, performer, graphicsBuilder, observable);
        this.gameFrame.setDogfightView(this);
        //(String title, IEventPerformer performer)

    }

    public void run() {

    }

    public String displayMessage(String message) {
        return message;

    }

    public void closeAll() {

    }

}
