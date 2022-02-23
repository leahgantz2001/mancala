package mancalaGame;

public class Store {
	int stones;

	//constructor
	public Store() {
		this.stones = 0;
		
	}
	
	//getter
	public int getStones() {
		return stones;
	}
	
	//adder
	public void addStone() {
		stones = stones + 1;
	}

}

