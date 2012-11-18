package ExpensesTask;

import java.io.*;
import java.util.ArrayList;

public class ExpenseMain {

	public static void main(String[] args) throws IOException {
		
		String myFinanceFileName = "myfinance.txt"; 
		String myBackup = "myfinance.bak"; 
		
		//создаем файловую переменную
		File f = new File(myFinanceFileName);
		
		//делаем меню
		String msgUserMenu = "User Menu: \n";
		String msg0 = "1 - add new expense to the list\n";
		String msg1 = "2 - remove expense from the list\n";
		String msg2 = "3 - restore expense list from backup\n";
		String msg3 = "4 - exit\n";
		
		msgUserMenu = msgUserMenu + msg0 + msg1 + msg2 + msg3; 
		
		//ожидаем ввод пользователем выбора из меню
		Integer i = 0; 

		boolean menu = true;
		while (menu) {
		
		String userInput = ReadUserInputHelper.getUserInput(msgUserMenu);
		i = Integer.parseInt(userInput);
		
		switch (i) {
			case 1: { //добавление записи
				
				//создаем переменную для операций с регистром расходов 
				ExpenseRegister myFinance = new ExpenseRegister();
				
				//если файл не существует (первый ввод расхода)
				if (!f.exists()) {

					myFinance.addExpenseToRegister();
					
					String tmpStr = myFinance.getExpenseAsString();
					myFinance.writeStringToFile(tmpStr, myFinanceFileName);
				}
				
				else { //если файл существует
					
					//делаем бекап
					myFile fb = new myFile(myFinanceFileName);
					fb.doBackupFromTo(myFinanceFileName, myBackup);
				
					//создаем временную переменную для хранения строк из файла
					ArrayList<String> tmpFinanceList = new ArrayList<String>();

					//считываем существующие строки 
					tmpFinanceList = myFinance.readStringFromFile(myFinanceFileName);
					
					//добавляем еще одну запись о расходах в память
					myFinance.addExpenseToRegister();
					
					//добавили новую запись последней во временный список строк
					tmpFinanceList.add(myFinance.getExpenseAsString());
					
					//переписываем весь список строк в файл
					FileWriter myFileWriter = new FileWriter(myFinanceFileName);
					BufferedWriter myBufferedWriter = new BufferedWriter(myFileWriter);
					for (int j = 0; j < tmpFinanceList.size(); j++) {
						System.out.println(j + " element = " + tmpFinanceList.get(j));
						myBufferedWriter.write(tmpFinanceList.get(j));
						myBufferedWriter.newLine();
				       }
				      myBufferedWriter.close();
				    
				    //обновляем бекап
					fb.doBackupFromTo(myFinanceFileName, myBackup);
				}
				break;
				}
			case 2: { //удаление записи

				//создаем переменную для операций с регистром расходов 
				ExpenseRegister myFinance = new ExpenseRegister();
				
				//если файл не существует
				if (!f.exists()) {
					myFile fb = new myFile(myFinanceFileName);
					fb.printFileNotFound();
					break;
				}
				
				//если файл существует
				else {
					
					//делаем бекап
					myFile fb = new myFile(myFinanceFileName);
					fb.doBackupFromTo(myFinanceFileName, myBackup);
					
					//создаем временную переменную для хранения строк из файла
					ArrayList<String> tmpFinanceList = new ArrayList<String>();
					
					//TODO: решить вопрос с конструктором объекта myFinance
					//сейчас при создании переменной типа ExpenseRegister
					//создается и переменная типа Expense
					//которая запрашивает данные для ввода
					//как это описано в ее конструкторе
					//а в данном случае она должна считать их из файла
					//и показать пользователю
					//нужен еще один конструктор объекта myFinance, который создаст
					//myFinance и считает туда все строки из файла
					
					//считываем существующие строки 
					tmpFinanceList = myFinance.readStringFromFile(myFinanceFileName);
					
					//выводим весь список строк для просмотра
					for (int j = 0; j < tmpFinanceList.size(); j++) {
						System.out.println(j + " element = " + tmpFinanceList.get(j));
					}
					
					//ожидаем ввод пользователем номера строки для удаления
					String strChoise = ReadUserInputHelper.getUserInput("Enter N of string to remove");
					i = Integer.parseInt(strChoise);
					
					//удалить запись по номеру из myFinance
					tmpFinanceList.remove(i);
					
					//переписываем весь список оставшихся строк в файл
					FileWriter myFileWriter = new FileWriter(myFinanceFileName);
					BufferedWriter myBufferedWriter = new BufferedWriter(myFileWriter);
					for (int j = 0; j < tmpFinanceList.size(); j++) {
						System.out.println(j + " element = " + tmpFinanceList.get(j));
						myBufferedWriter.write(tmpFinanceList.get(j));
						myBufferedWriter.newLine();
				       }
				      myBufferedWriter.close();
				    
				    //обновляем бекап
					fb.doBackupFromTo(myFinanceFileName, myBackup);
					
					break;
				}
			}
			
			case 3: { //восстановление из бекапа
				
				//если файл не существует
				if (!f.exists()) {
					myFile fb = new myFile(myFinanceFileName);
					fb.printFileNotFound();
					break;
				}
				
				//если файл существует
				else {
					myFile fb = new myFile(myFinanceFileName);
					fb.doBackupFromTo(myBackup, myFinanceFileName);
					break;
				}
			}
	
			case 4: { //выход из программы
				String msgExit = "Program closed.";
				System.out.println(msgExit);
				menu = false;
				break;
				}
			
			default: {
				String msgInv = "Invalid menu option.";
				System.out.println(msgInv);
				break;
			}
		} //end of switch
		
		}//end of while
	}
}
