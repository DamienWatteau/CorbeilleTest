/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpu2016.dogfight.model;
import java.awt.Color;
import java.awt.Image;
import java.awt.Point;
import javax.swing.text.Position;

/**
 *
 * @author DamienWatteau
 */
public class Mobile implements IMobile {
	
	protected Dimension dimension;
	protected Direction direction;
	protected Position position ;
	
	
	
	
public  Mobile(Direction direction , Position position , Dimension dimension , int speed , String image){
	
}

	public Direction getDirection() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setDirection(Direction direction) {
		// TODO Auto-generated method stub
		
	}

	public Point getPosition() {
		// TODO Auto-generated method stub
		return null;
	}

	public Dimension getDimension() {
		// TODO Auto-generated method stub
		return null;
	}

	public int getWidth() {
		// TODO Auto-generated method stub
		return 0;
	}

	public int getHeight() {
		// TODO Auto-generated method stub
		return 0;
	}

	public int getSpeed() {
		// TODO Auto-generated method stub
		return 0;
	}

	public Image getImage() {
		// TODO Auto-generated method stub
		return null;
	}

	public void move() {
		// TODO Auto-generated method stub
		
	}
	
	public void moveRight() {
		
	}
	
	public void moveUp() {
		
	}
	public void moveDown() {
	
}
	public void moveLeft() {
	
}
	
	public Color getColor(){
		return null;
		
	}
	
	

	public void PlaceInArea(IArea area) {
		// TODO Auto-generated method stub
		
	}

	public boolean isPlayer(int player) {
		// TODO Auto-generated method stub
		return false;
	}
	
	
	public DogfightModel getDogfightModel() {
		return null;
	
		
	}

	public void setDogfightModel(DogfightModel dogfightModel) {
		// TODO Auto-generated method stub
		
	}

	public boolean hit() {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean isWeapon() {
		// TODO Auto-generated method stub
		return false;
	}

}
