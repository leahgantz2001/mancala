package mancalaGame;

public class Pit {
	private int pitNumber;
	private int pebbles;
	
	//constructor
	public Pit(int pitNumber) {
		this.pitNumber = pitNumber;
		pebbles = 4;
	}
	
	//getter
	public int getPebbles() {
		return pebbles;
	}
	
	public int getPitNumber() {
		return pitNumber;
	}
	
	//setter
	public void setPebbles(int pebbles) {
		this.pebbles = pebbles;
	}
	
	// add a pebble
	public void addPebble() {
		pebbles++;
	}
	
	//remove the pebbles
	public void removePebbles() {
		pebbles = 0;
	}
	
	
	}

