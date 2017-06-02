/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpu2016.dogfight.model;

import javax.swing.text.Position;

public class Missile extends Mobile {
	
	int SPEED = 4;
	int WIDTH = 30;
	int HEIGHT = 10 ;
	int MAX_DISTANCE_TRAVELED = 1400;
	String IMAGE = "Missile";
	int distance_traveled = 0 ;
	

	public Missile(Direction direction, Position position, Dimension dimension, int speed, String image) {
		super(direction, position, dimension, speed, image);
		// TODO Auto-generated constructor stub
	}
	
	public int getWidthWithADirection(Direction direction){
		return HEIGHT;
		
	}
	
	public int getHeightithADirection(Direction direction){
		return HEIGHT;
		
	}
	
	public void move(){
		
	}

	public boolean isWeapon(){
		return false;
		
	}
}