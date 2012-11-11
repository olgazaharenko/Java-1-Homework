package OZA_JAVA1_Homework;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

//вывести меню пользователя

//0:
//если нет файла для расходов, создать файл (myfinance.txt)
//создать структуру данных ExpenseRegister как список объектов типа Expense

//1:
//искать существующий файл (myfinance.txt) для расходов
//открыть его для редактирования
//считать все записи в структуру данных ExpenseRegister, 
//объявленную как список объектов типа Expense

//СТАНДАРТНАЯ ЧАСТЬ для ввода данных
//вывести меню для ввода данных (введите дату расходов, введите сумму, введите описание)
//создать новую структуру данных (Expense)
//ожидать ввода пользователя
//если ввод ненулевой, записать дату, сумму и описание в поля структуры данных
//с помощью сеттеров класса Expense
//добавить созданный объект класса Expense в список ExpenseRegister
//перезаписать новый список ExpenseRegister в файл
//сохранить файл
//выйти в меню пользователя

//2:
//выход из программы

public class ExpenseTestClass {

	public static void main(String[] args) {

		String msgMenu = "User Menu: \n";
		String msg0 = "0 - create new expense register\n";
		String msg1 = "1 - edit existed expense register\n";
		String msg2 = "2 - exit\n";
		String msgExit = "Program closed.";
		
		//создать новую структуру для 1 записи (Expense)
		private Expense myExpense = new Expense(); 

		//создать структуру данных ExpenseRegister как список объектов типа Expense
		ExpenseRegister myFinance = new ExpenseRegister();
		
		//дать имя файлу для записи расходов
		String nameMyFile = "myfinances.txt";
		
		//вывести меню пользователя и ожидать выбора:
		msgMenu = msgMenu + msg0 + msg1 + msg2; 
		Integer i = 0; 
		String userInput = ExpenseInputHelper.getUserInput(msgMenu);
		i = i.parseInt(userInput);

			switch (i) {

				//0:
				//если нет файла для расходов, создать файл (myfinance_ddmmyyyy.txt)
				case 0: {
					
					File myFile = new File(nameMyFile);
					
					myFinance.addExpenseToRegister(myExpense);
					
					myFile.write();
					
					System.out.println("do case 0");
					break;
				
				} //end case 0
					
				//1:
				//искать существующий файл (myfinance.txt) для расходов
				//считать все записи из файла в структуру данных ExpenseRegister, 
				//объявленную как список объектов типа Expense
				case 1: {
					
					myFinance.addExpenseToRegister(myExpense);
					
					System.out.println("do case 1");
					break;
					} //end case 1
				
				case 2: {
					System.out.println(msgExit);
				}
				
				}//end switch i
		} //end main method 
} //end ExpenseTestClass
