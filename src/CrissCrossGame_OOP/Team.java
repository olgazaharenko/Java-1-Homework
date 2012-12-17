package CrissCrossGame_OOP;

import java.util.ArrayList;
import java.util.List;

public class Team {

	public int gamers;
	
	public List<Player> listOfPlayers = new ArrayList<Player>();
	public List<String> listOfGamersNames = new ArrayList<String>();
	public List<String> listOfPlayersFigures = new ArrayList<String>();
	
	Team() {
		gamers = Speaker.defineGamersPair();
		this.setPlayers(gamers);
		this.setNames();
		this.setTokens();
		
		System.out.println("Team object fields: ");
		System.out.println("gamers = " + gamers);
		System.out.println("Player 1 name is " + listOfGamersNames.get(0).toString());
		System.out.println("Player 2 name is " + listOfGamersNames.get(1).toString());
		System.out.println("We have next figures to play with:" + listOfPlayersFigures.size());
		System.out.println("Player 1 figure is " + listOfPlayersFigures.get(0).toString());
		System.out.println("Player 2 figure is " + listOfPlayersFigures.get(1).toString());
		
	}
	
	public List<Player> setPlayers(int gamers) {

		switch (gamers) {
		case 0: {
			listOfPlayers.add(new HumanPlayer());
			listOfPlayers.add(new HumanPlayer());
			break;
		}
		case 1: {
			listOfPlayers.add(new HumanPlayer());
			listOfPlayers.add(new AIPlayer());
			break;
		}
		case 2: {
			listOfPlayers.add(new AIPlayer());
			listOfPlayers.add(new AIPlayer());
			break;
		}

		}
		return listOfPlayers;
	}

	public List<String> setNames() {
		listOfGamersNames = UserMenu.meetTheGamers();
		return listOfGamersNames;
	}
	public List<String> setTokens() {
		listOfPlayersFigures.add(0, Token.FIRST.getGameToken());
		listOfPlayersFigures.add(1, Token.SECOND.getGameToken());
		return listOfPlayersFigures;
	}
	
	public int getTeam() {
		return gamers;
	}
	public List<Player> getPlayers(int p) {
		return listOfPlayers;
	}
	public String getNames(int winner) {
		return listOfGamersNames.get(winner);
	}
	public List<String> getTokens() {
		return listOfPlayersFigures;
	}
}
