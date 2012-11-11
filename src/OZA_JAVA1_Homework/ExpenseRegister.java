package OZA_JAVA1_Homework;

import java.util.*;

//makes objects Expenses, gets user input, add it to the file
//
public class ExpenseRegister {

	private List <Expense> list = new ArrayList <Expense>();

	String msgUser = "3 - add new";
	String msgU1 = "";
	
	String userToDo = ExpenseInputHelper.getUserInput(msgUser);

	
	//СТАНДАРТНАЯ ЧАСТЬ РЕДАКТИРОВАНИЯ
	//вывести меню для ввода данных (введите дату расходов, введите сумму, введите описание)
	//создать новую структуру данных (Expense)
	//ожидать ввода пользователя
	//если ввод ненулевой, записать дату, сумму и описание в поля структуры данных
	//с помощью сеттеров класса Expense
	//добавить созданный объект класса Expense в список ExpenseRegister
	//записать список ExpenseRegister в файл
	//сохранить файл
	//выйти в меню пользователя
	
			for (int j = 3; j<6; j++) {
				switch (j) {
	
					case 3: {
			
					} //end case 3
					case 4: {
			
					} //end case 4
					case 5: {
			
					}// end case 5
				} //end switch j
			} //end for j
					default: {
					} //end default
	
	private Expense myExpense = new Expense(); 
	
	public void addExpenseToRegister(Expense n) {
		list.add(myExpense);
	}
	
	public void removeExpenseFromRegister(Expense q) {
		list.remove(myExpense);		
	}

}
