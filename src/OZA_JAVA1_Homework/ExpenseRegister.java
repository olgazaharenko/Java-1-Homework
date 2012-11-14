package OZA_JAVA1_Homework;

import java.util.*;

public class ExpenseRegister {
	
	Expense myExpense = new Expense();
	private String d = ";"; //разделитель значений
	
	private List <Expense> list = new ArrayList <Expense>();
	
	public void addExpenseToRegister() {
		list.add(myExpense);
	}
	
	public void removeExpenseFromRegister(Expense q) {
		list.remove(q);	
	}
	
	public String getExpenseAsString () {
		String myExpenseAsString = myExpense.getDate() + d + myExpense.getSum() + d + myExpense.getDescription() + d;
		return myExpenseAsString;
	}
	
}
