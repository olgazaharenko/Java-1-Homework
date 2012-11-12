package OZA_JAVA1_Homework;

import java.util.*;
//data structure for 1 record about expense, like:
//9 Nov 2012, 10 LVL, топливо
//7 Nov 2012, 5 LVL, билет в кино
//

public class Expense {

	private String date;
	private String sum;
	private String description;
	
	private String msgEnterData = "Введите дату:";
	private String msgEnterSum = "Введите сумму:";
	private String msgEnterDescription = "Введите комментарий к расходам:";
		
	Expense() {
		setDate(ExpenseInputHelper.getUserInput(msgEnterData));
		setSum(ExpenseInputHelper.getUserInput(msgEnterSum));
		setDescription(ExpenseInputHelper.getUserInput(msgEnterDescription));
	}
	
	public String getDate() {
		return this.date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getSum() {
		return this.sum;
	}
	public void setSum(String sum) {
		this.sum = sum;
	}
	public String getDescription() {
		return this.description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
	
}
