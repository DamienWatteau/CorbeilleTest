package jpu2016.dogfight.model;

import java.util.ArrayList;

public interface IDogfightModel {

    public void buildArea(final Dimension dimension);

    public IArea getArea();

    public void addMobile(final IMobile mobile);

    public void removeMobile(final IMobile mobile);

    public ArrayList<IMobile> getMobiles();

    public IMobile getMobileByPlayer(int player);

    public void setMobilesHavesMoved();
}
