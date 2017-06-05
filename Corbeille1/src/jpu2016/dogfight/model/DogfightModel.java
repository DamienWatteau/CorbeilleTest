package jpu2016.dogfight.model;

import java.util.ArrayList;
import java.util.Observable;

public class DogfightModel extends Observable implements IDogfightModel {

    private Sky sky;
    private final ArrayList<IMobile> moiles;
b
    public DogfightModel() {
        this.mobiles = new ArrayList<>();
    }

    @Override
    public IArea getArea() {
        return this.sky;
    }

    @Override
    public void buildArea(final Dimension dimension) {
        this.sky = new Sky(dimension);
    }

    @Override
    public void addMobile(final IMobile mobile) {
        this.mobiles.add(mobile);
        mobile.setDogfightModel(this);
    }

    @Override
    public void removeMobile(final IMobile mobile) {
        this.mobiles.remove(mobile);
    }

    @Override
    public ArrayList<IMobile> getMobiles() {
        return this.mobiles;
    }

    @Override
    public IMobile getMobileByPlayer(final int player) {
        for (final IMobile mobile : this.mobiles) {
            if (mobile.isPlayer(player)) {
                return mobile;
            }
        }
        return null;
    }

    @Override
    public void setMobilesHavesMoved() {
        this.setChanged();
        this.notifyObservers();
    }
}
