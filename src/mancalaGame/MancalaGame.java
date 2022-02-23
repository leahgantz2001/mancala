package mancalaGame;


import java.lang.reflect.Array;
import java.util.*;
public class MancalaGame {  	
		
	//create board
	public static void createBoard() {
		
		//create 2 arraylists
		ArrayList<Pit> arrayPits1 = new ArrayList<Pit>();
		for (int i = 0; i < 6; i++) {
			Pit pit = new Pit(i+1);
			arrayPits1.add(pit);
		}
		
		ArrayList<Pit> arrayPits2 = new ArrayList<Pit>();
		for (int i = 0; i < 6; i++) {
			Pit pit = new Pit(i+1);
			arrayPits2.add(pit);
		}

	
		//create 2 stores
		Store mancala1 = new Store();
		Store mancala2 = new Store();
		
		//create the two players 
		Player player1 = new Player("Player one", mancala1, arrayPits1);
		Player player2 = new Player("Player two", mancala2, arrayPits2);
		
		playGame(arrayPits1, arrayPits2, player1, player2, mancala1, mancala2);
	}
	
	
	//setup the board
	public static void settupBoard(ArrayList<Pit> currentPits, ArrayList<Pit> otherPits, Store currentMancala, Store otherMancala, Player currentPlayer, Player otherPlayer) {
		//print the array list formated nicely 
		System.out.println(currentPlayer.getPlayerName());
		System.out.print("\t");
			for (int i = 5; i >= 0; i--) {
				System.out.print(currentPits.get(i).getPebbles());
				System.out.print("\t");
			}
			
			System.out.println();
			System.out.println();
			
			//print the stores
			System.out.println((currentMancala).getStones() + "\t\t\t\t\t\t\t" + otherMancala.getStones());
			
			//print the arraylist formated nicely
			System.out.print("\t");
			for (int i = 0; i < otherPits.size(); i++) {
				System.out.print(otherPits.get(i).getPebbles());
				System.out.print("\t");
			}
			System.out.println();
			System.out.println(otherPlayer.getPlayerName());
	}
	
	public static void playGame(ArrayList<Pit> arrayPits1, ArrayList<Pit>arrayPits2, Player player1, Player player2, Store mancala1, Store mancala2) {
		Player winner = null;
		boolean anotherTurn = false;
		Player currentPlayer = new Player(player2);
		Player otherPlayer = new Player(player1);
		boolean turnOver = false;
		boolean isWinner = false;
				
		
		takeTurn(currentPlayer, otherPlayer, isWinner, anotherTurn); 
			
		
	}
		
		
		
			
	//take turn method
	public static void takeTurn(Player currentPlayer, Player otherPlayer,  boolean isWinner, boolean anotherTurn) {
		//have the peices move around here
		//get the starting pit from the player
		int startPit;
		int pebblesInPit;
		isWinner = false;
			
		while (!isWinner) {
			if (anotherTurn == false) {
				Player playerNow = new Player(currentPlayer);
				Player other = new Player(otherPlayer);
				currentPlayer = other;
				otherPlayer = playerNow;
			}
			// display the board 
			ArrayList<Pit> currentPits = currentPlayer.getArrayPits(); 
			ArrayList<Pit> otherPits = otherPlayer.getArrayPits();
			Store currentMancala = currentPlayer.getMancala();
			Store otherMancala = otherPlayer.getMancala();

			settupBoard(currentPits, otherPits, currentMancala, otherMancala, currentPlayer, otherPlayer);
			System.out.println();
			System.out.println(currentPlayer.getPlayerName() + ":");
			System.out.println("Please choose a pit to start from:");
			Scanner keyboard = new Scanner(System.in);
			startPit = keyboard.nextInt();
			while ((startPit > 6) || (startPit < 1)) {
				System.out.println("Invalid input!! You must enter a pit between 1 and 6.");
				System.out.println("Please enter a pit between 1 and 6: ");
				startPit = keyboard.nextInt();
				while (currentPits.get(startPit - 1).getPebbles() == 0) {
					System.out.println("You must choose a pit that has pebbles!!");
					startPit = keyboard.nextInt();
				}
			}
			while (currentPits.get(startPit - 1).getPebbles() == 0) {
				System.out.println("You must choose a pit that has pebbles!!");
				startPit = keyboard.nextInt();
				while ((startPit > 6) || (startPit < 1)) {
					System.out.println("Invalid input!! You must enter a pit between 1 and 6.");
					System.out.println("Please enter a pit between 1 and 6: ");
					startPit = keyboard.nextInt();
				}
			}
				
									
				//get the number of pebbles in the pit and make it zero
				int numPebbles = (currentPits.get(startPit - 1)).getPebbles();
				currentPits.get(startPit - 1).removePebbles();
				
					
				
				while (numPebbles != 0) {
					
					//loop through the players side
				
					for (int i = (startPit); i < currentPits.size(); i++) {
						if (numPebbles != 0) {
						currentPits.get(i).addPebble();
						numPebbles--;
					}			
						//check if you dropped it into an empty hole
						if (numPebbles == 0) {
							if(currentPits.get(i).getPebbles() == 1) {
								//take the pebble and the pebbles across from the pit into your mancala  //MAYBE NOT WORKING BECAUSE THE ARRAY IS NOT ACTUALLY BACKWARDS JUST DISPLAYS ITSELF BACKWARDS
								
								int pebblesToTake = 0;
								switch(currentPits.get(i).getPitNumber()) {
								case 1:
									pebblesToTake = otherPits.get(5).getPebbles();
									otherPits.get(5).removePebbles();
									break;
								case 2:
									pebblesToTake = otherPits.get(4).getPebbles();
									otherPits.get(4).removePebbles();
									break;
								case 3:
									pebblesToTake = otherPits.get(3).getPebbles();
									otherPits.get(3).removePebbles();
									break;
								case 4:
									pebblesToTake = otherPits.get(2).getPebbles();
									otherPits.get(2).removePebbles();
									break;
								case 5:
									pebblesToTake = otherPits.get(1).getPebbles();
									otherPits.get(1).removePebbles();
									break;
								case 6:
									pebblesToTake = otherPits.get(0).getPebbles();
									otherPits.get(0).removePebbles();
									break;
								}
								
								for(int k = 1; k <= pebblesToTake + 1; k++) {
									currentMancala.addStone();
								}
								currentPits.get(i).removePebbles();
							}
							i = currentPits.size();
						}
				}
										
					// add one to the mancala
					if(numPebbles != 0) {
						currentMancala.addStone();
						numPebbles--;
						//if the last one is in his own store, he gets another turn
						if (numPebbles == 0)  {
							System.out.println("Horray! You get another turn!!");
							anotherTurn = true;
							takeTurn(currentPlayer, otherPlayer, isWinner, anotherTurn);						
						}
					
					}
					anotherTurn = false;
						
					//loop through the other side 
					for (int j = 0; j < otherPits.size(); j++) {
						if (numPebbles != 0) {
						otherPits.get(j).addPebble();
						numPebbles--;
					}
						//quit the loop when the pebbles run out
										
				}	
					if (numPebbles != 0) {
						startPit = 0;
					}
				}
		
			// check if one side is empty
			int sum1 = 0;
			for(int i = 0; i < currentPits.size(); i++) {
				sum1 += currentPits.get(i).getPebbles();
			}
			int sum2 = 0;
			for(int i = 0; i < otherPits.size(); i++) {
				sum2 += otherPits.get(i).getPebbles();
			}
			if ((sum1 == 0) || (sum2 == 0)) {
				isWinner = true;
				isWinner(currentMancala, otherMancala, currentPlayer, otherPlayer);
			}
			
				

			}				
		}
		
		public static void isWinner(Store currentMancala, Store otherMancala, Player currentPlayer, Player otherPlayer) {
			int sum = 0;
			
			for (int i = 0; i < currentMancala.getStones(); i++) {
				sum += 1;
			}
			
			int sum2 = 0;
			for (int j = 0; j < otherMancala.getStones(); j++) {
				sum2 += 1;
			}
			
			if(sum > sum2) {
					System.out.println("Horray!! " + currentPlayer.getPlayerName() + " won the game!!!");
			}
			else if (sum2 > sum) {
				System.out.println("Horray!! " + otherPlayer.getPlayerName() + " won the game!!!");
			}
			else {
				System.out.println("Horray!! It is a tie!! Both players are winners!!");
			}
			
		}

	}			
		
		

