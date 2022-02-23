package mancalaGame;

import java.util.ArrayList;

public class Player {
	private String name;
	private Store mancala;
	private ArrayList arrayPits;
	
	//Constructor
	public Player(String name, Store mancala, ArrayList arrayPits) {
		this.name = name;
		this.mancala = mancala;
		this.arrayPits= arrayPits;
	}
	
	public Player(Player p) {
		this.arrayPits = p.arrayPits;
		this.name = p.name;
		this.mancala = p.mancala;
	}
	
	//getters
	
	//get the name
	public String getPlayerName() {
		return name;
	}
	
	//get the mancala
	public Store getMancala() {
		return this.mancala;
	}
	
	//get the stones in the player's mancala
	public int getStonesInMancala() {
		return this.mancala.getStones();
	}
	
	//get the player's arraylist
	public ArrayList getArrayPits() {
		return this.arrayPits;
	}
}
		


