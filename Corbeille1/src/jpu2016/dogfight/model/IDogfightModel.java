package jpu2016.dogfight.model;

import java.util.ArrayList;
import jpu2016.dogfight.view.GraphicsBuilder;



public interface IDogfightModel {
	
	public IArea getIArea();

	public void buildArea(Dimension dimension);
	
	public void addMobile(IMobile Mibile);
	
	public void removeMobile(IMobile Mobile);
	
	public ArrayList<IMobile> getMobiles();
	
	public IMobile getMobileByPlayer(int player);

	public void setMobilesHavesMoved();

	public void setGraphicsBuilder(GraphicsBuilder graphicsBuilder);

}