package headFirstJavaTestBookSamples;

import java.util.ArrayList;

public class DotCom {

	private ArrayList<String> locationCells;
	
	public void setLocationCells(ArrayList<String> locs) {
		locationCells = locs;
	}
	
	public String checkYourself(String userInput) {
		
		String result = "miss";
		
		int index = locationCells.indexOf(userInput);
		
		if (index >= 0) {
			
			locationCells.remove(index)
;			if (locationCells.isEmpty()) {
				result = "kill";				
			} else {
				result = "hit";
			} //close if
		} //close outer if
		return result;
	} //close method
} //close class
