package OZA_JAVA1_Homework;

import java.util.*;

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

public class ExpenseRegister {

	private List <Expense> list = new ArrayList <Expense>();
	
	
	public void addExpenseToRegister(Expense n) {
						
		//добавить заполненную строку к списку
		list.add(n);
		
	}
	
	public void removeExpenseFromRegister(Expense q) {
		
		
		list.remove(q);		
	}

}
