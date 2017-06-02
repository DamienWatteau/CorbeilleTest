/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpu2016.dogfight.model;

import java.awt.Image;

public class Sky implements IArea {
	
	protected Dimension dimension;

        @Override
	public Dimension getDimension() {
		return dimension;
	}
	
	public Sky (Dimension dimension){
		
	}
	
	public Image getImage(){
		return null;
		
	}

}