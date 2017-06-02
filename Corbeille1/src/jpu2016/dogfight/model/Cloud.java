/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpu2016.dogfight.model;

import javax.swing.text.Position;

public class Cloud extends Mobile {
	
	int SPEED = 1;
	int WIDTH = 300;
	int HEIGHT = 150 ;
	String IMAGE = "cloud";

	public Cloud(Direction direction, Position position, Dimension dimension, int speed, String image) {
		super(direction, position, dimension, speed, image);
		// TODO Auto-generated constructor stub
	}
	
	

}