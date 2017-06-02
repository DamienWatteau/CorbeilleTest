/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpu2016.dogfight.model;

import java.util.ArrayList;

/*
 * @author DamienWatteau
 */

    /**
     * @param args the command line arguments
     */
    public class DogfightModel implements IDogfightModel{ // UML : La destrution de la classe entre la destruction de Sky (+Croix)
        private Sky sky;
            private DogfightModel(){
                sky = new Sky();
            }
      
        public IArea getArea(){
            return null;

        }
        public void buildArea(Dimension dimension){

        }
        public void addMobile(IMobile Mobile){

        }
        public void removeMobile(IMobile Mobile){

        }
        public ArrayList<IMobile> getMobiles(){
            return null;

        }
        public IMobile getMobileByPlayer(int player){
            return null;

        }
        public void setMobilesHavesMoved(){

        }
}
