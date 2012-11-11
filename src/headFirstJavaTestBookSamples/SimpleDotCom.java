package headFirstJavaTestBookSamples;

public class SimpleDotCom {

	int[] locationCells;
	int numOfHits = 0;
	
	public void setLocationCells(int[] locs) {
	
		locationCells = locs;
	}
	
	public String checkYourself(String stringGuess) {
		
		//convert the String to an int
		int guess = Integer.parseInt(stringGuess);
		
		//make a variable to hold the result we'll return.
		//put "miss" in as the default (i.e., we assume the "miss"(
		String result = "miss";
		
		//repeat with each cell in the locationCells
		//array (each cell location of the object)
		for (int cell : locationCells) {
			
			//compare the user guess to this element (cell) in the array
			if (guess == cell) {
				
				//we got a hit!
				result = "hit";
				numOfHits++;
				
				//get out the loop, no needs to test the other cells
				break;
			}
		}
		
		//we are out of the loop, but let's see if we were 
		//now "dead" (hit 3 times) and change the result string to "kill"
		if (numOfHits == locationCells.length) {
			
			result = "kill";
			
		}
		
		System.out.println(result);
		
		//return the result back to calling method
		return result;
	}

}
