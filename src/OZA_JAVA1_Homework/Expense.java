package OZA_JAVA1_Homework;

import java.util.*;
//data structure for 1 record about expense, like:
//9 Nov 2012, 10 LVL, топливо
//7 Nov 2012, 5 LVL, билет в кино
//

public class Expense {

	private Date date;
	private float sum;
	private String description;
	
	
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public float getSum() {
		return sum;
	}
	public void setSum(float sum) {
		this.sum = sum;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
	
}
