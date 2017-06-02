package jpu2016.dogfight.controller;



public class UserOrder implements IUserOrder{
	private Order order;
	
	private int player;
	
	public UserOrder(int player, Order order){
		
	}
	
	public Order getOrder(){
		return order;
	}
	

	public int getPlayer() {
		return player;
	}

	//probleme help
}
