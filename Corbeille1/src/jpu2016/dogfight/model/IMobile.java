/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpu2016.dogfight.model;

import java.awt.Image;
import java.awt.Point;

public interface IMobile {
	
	public Direction getDirection();

	public void setDirection (Direction direction);
	
	public Point getPosition();
	
	public Dimension getDimension();

	public int getWidth();
	
	public int getHeight();
	
	public int getSpeed();
	
	public Image getImage();
	
	public void move();
	
	public void PlaceInArea(IArea area);
	
	public boolean isPlayer(int player);
	
	public void setDogfightModel(DogfightModel dogfightModel) ;
	
	
	public boolean hit();
	
	public boolean isWeapon();
	
	
	
	
}