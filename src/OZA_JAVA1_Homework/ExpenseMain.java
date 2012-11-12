package OZA_JAVA1_Homework;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**вывести меню пользователя

* 1: ввод расходов и сохранение их в файл
*  
* если нет файла для расходов, создать файл (myfinance.txt)
* создать структуру данных ExpenseRegister как список объектов типа Expense
* если файл есть, открыть его
* считать все записи в структуру данных ExpenseRegister, 
* объявленную как список объектов типа Expense
*
* 2: удаление расходов из файла
* 
* создать структуру данных ExpenseRegister как список объектов типа Expense
* если файл есть, открыть его
* считать все записи в структуру данных ExpenseRegister, 
* объявленную как список объектов типа Expense
* 
* СТАНДАРТНАЯ ЧАСТЬ для ввода данных
* вывести меню для ввода данных (введите дату расходов, введите сумму, введите описание)
* создать новую структуру данных (Expense)
* ожидать ввода пользователя
* если ввод ненулевой, записать дату, сумму и описание в поля структуры данных
* с помощью сеттеров класса Expense
* добавить созданный объект класса Expense в список ExpenseRegister
* перезаписать новый список ExpenseRegister в файл
* сохранить файл
* выйти в меню пользователя
*
* 3:
* ожидаемый выход из программы
* 
*/
public class ExpenseMain {

	public static void main(String[] args) {

		String msgUserMenu = "User Menu: \n";
		String msg0 = "1 - add new expense to the list\n";
		String msg1 = "2 - remove expense from the list\n";
		String msg2 = "3 - exit\n";
		String msgExit = "Program closed.";
		
		String myFinanceFileName = "myfinance.txt";
	
		String tmpExpense = "";
		
		msgUserMenu = msgUserMenu + msg0 + msg1 + msg2; 
		Integer i = 0; 
		String userInput = ReadUserInputHelper.getUserInput(msgUserMenu);
		i = Integer.parseInt(userInput);
		
		//TODO: сделать цикл, чтобы меню висело стабильно, 
		//а не выключалось после первого ввода
		
		switch (i) {
			case 1: {
				ExpenseRegister myFinance = new ExpenseRegister();
				
				myFinance.addExpenseToRegister();
				tmpExpense = myFinance.readExpenseFromRegister();

				WorkWithFiles.CreateNewFile(myFinanceFileName);
				WorkWithFiles.WriteToFile(tmpExpense, myFinanceFileName);
				break;
				} 
			case 2: {
								
				//TODO: открыть существующий файл (myfinance.txt) для расходов
				//TODO: считать все записи из файла в структуру данных ExpenseRegister, 
				//TODO: объявленную как список объектов типа Expense	
				//TODO: определить, что удалять
				//TODO: удалить запись из ExpenseRegister
				//TODO: перезаписать файл с новыми данными.
				
				break;
			}
			case 3: {
				System.out.println(msgExit);
				break;
			}
		}
	}
}