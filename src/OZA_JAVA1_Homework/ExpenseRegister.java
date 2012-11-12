package OZA_JAVA1_Homework;

import java.util.*;

public class ExpenseRegister {

	Expense myExpense = new Expense();
	String d = ";";
	
	private List <Expense> list = new ArrayList <Expense>();
	
	public void addExpenseToRegister() {
		list.add(myExpense);
	}
	
	public void removeExpenseFromRegister(Expense q) {
		list.remove(q);	
	}
	
	public String readExpenseFromRegister() {
		String strExpense = "";
		strExpense = myExpense.getDate() + d + myExpense.getSum() + d + myExpense.getDescription() + d;
		return strExpense;
	}
}
