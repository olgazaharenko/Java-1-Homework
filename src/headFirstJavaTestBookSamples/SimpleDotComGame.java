package headFirstJavaTestBookSamples;

public class SimpleDotComGame {

	public static void main(String[] args) {
	
		//make a variable to track how many guesses the user make
		int numOfGuesses = 0;
		
		//this is special class we wrote that  we wrote that has the method
		// for getting user input for now, pretend it's part of Java
		GameHelper helper = new GameHelper();
		
		//make the dot com object
		SimpleDotCom theDotCom = new SimpleDotCom();
		
		//make a random number for the first cell 
		//and use it to make the cell locations array
		int randomNum = (int) (Math.random()*5);
		int[] locations = {randomNum, randomNum + 1, randomNum + 2};
		
		//give the dot com its locations (the array)
		theDotCom.setLocationCells(locations);
		
		//make a boolean variable to track whether the game
		//is still alive, to use in the while loop test repeat
		//while game is still alive
		
		boolean isAlive = true;
		while (isAlive == true) {
			
			//get user input String
			String guess = helper.getUserInput("enter a number");
			
			//ask the dot com to check the guess
			//save the returned result as a String
			String result = theDotCom.checkYourself(guess);
			
			//increment guess count
			numOfGuesses++;
			
			//was it a "kill"? if so, set isAlive to false
			//(so we want to re-enter the loop)
			//and print user guess count
			
			if (result.equals("kill")) {
				isAlive = false;
				System.out.println("You took " + numOfGuesses + "guesses");
			}
		}
	}
}
