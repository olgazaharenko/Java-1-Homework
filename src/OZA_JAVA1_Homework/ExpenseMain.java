package OZA_JAVA1_Homework;

import java.io.*;
import java.nio.channels.FileChannel;
import java.util.ArrayList;

/**вывести меню пользователя
*
* 1: ввод расходов и сохранение их в файл
*  
* если нет файла для расходов, создать файл (myfinance.txt)
* создать структуру данных ExpenseRegister как список объектов типа Expense
* считать ввод пользователя в элемент списка
* открыть файл для записи
* записать ввод пользователя в файл
* сохранить и закрыть файл
* 
* если файл есть, создать бекап.
* работаем с оригинальным файлом.
* считать все записи из файла во временный список 
* закрыть файл
* считать ввод пользователя 
* записать ввод пользователя последним элементом списка
* открыть оригинальный файл для записи
* записать список в файл
* сохранить и закрыть файл 
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
* выйти в меню пользователя
*
* 3:
* ожидаемый выход из программы
* 
*/
public class ExpenseMain {

	public static void main(String[] args) throws IOException {
		//TODO: вынести все операции с файлами в отдельный класс
		//наследующий от File
		
		String myFinanceFileName = "myfinance.txt"; //скопировано в myOperationsWithFile
		String myBackup = "myfinance.bak"; //скопировано в myOperationsWithFile

		//создаем файловую переменную
		File f = new File(myFinanceFileName);
		
		//делаем меню
		String msgUserMenu = "User Menu: \n";
		String msg0 = "1 - add new expense to the list\n";
		String msg1 = "2 - remove expense from the list\n";
		String msg2 = "3 - exit\n";
		
		msgUserMenu = msgUserMenu + msg0 + msg1 + msg2; 
		
		Integer i = 0; 
		String userInput = ReadUserInputHelper.getUserInput(msgUserMenu);
		i = Integer.parseInt(userInput);
		
		//TODO: исправить цикл, чтобы меню висело стабильно, 
		//а не выключалось после первого ввода - while ниже зацикливает на вводе, и не дает выйти
		//из ситуации 1
		//while (i != 3) {
		switch (i) {
			case 1: {
				
				if (!f.exists()) {
				
				//создаем переменную для операций с регистром расходов 
				ExpenseRegister myFinance = new ExpenseRegister();
								
				myFinance.addExpenseToRegister();
				
				//составляем строку из значений переменных объекта Expense и пишем ее в файл 
				BufferedWriter myFileWriter = new BufferedWriter(new FileWriter(myFinanceFileName));
				myFileWriter.write(myFinance.getExpenseAsString());
				myFileWriter.close();
				
				}
				
				else { //если файл существует
					
					FileChannel fChannel = new FileInputStream(myFinanceFileName).getChannel();
					FileChannel fbChannel = new FileOutputStream(myBackup).getChannel();
					fChannel.transferTo(0, fChannel.size(), fbChannel);
					fChannel.close();
					fbChannel.close();
					
					//создаем временный список строк
					ArrayList<String> tmpFinanceList = new ArrayList<String>();
					
					//Построчно читаем файл 
					//Записываем строки во временный список строк
					   OutputStreamWriter OSW = new OutputStreamWriter(System.out, "UTF-8");
					   PrintWriter         PW = new PrintWriter(OSW, true);
				       FileReader myFileReader = new FileReader(myFinanceFileName);
				       BufferedReader myBufferedReader = new BufferedReader(myFileReader);
				       String stroka="\n";
				       int j = 0;
				       do
				        {
				        stroka=myBufferedReader.readLine();
				        	if(stroka!=null) {
				        	tmpFinanceList.add(j, stroka);
				        	PW.println(j + ". В файле: " + stroka + ". В памяти: " + tmpFinanceList.get(j));
					        j++;
				        	}
				        }
				       	while(stroka!=null);
				       myBufferedReader.close();
					
				    //создаем переменную для операций с регистром расходов 
					ExpenseRegister myFinance = new ExpenseRegister();
						
					//вводим новую и единственную запись о расходах в память
					myFinance.addExpenseToRegister();
					
					//добавили новую запись последней во временный список строк
					tmpFinanceList.add(j, myFinance.getExpenseAsString());
					
					//переписываем список строк в файл
					FileWriter myFileWriter = new FileWriter(myFinanceFileName);
					BufferedWriter myBufferedWriter = new BufferedWriter(myFileWriter);
					
					for (j = 0; j < tmpFinanceList.size(); j++) {
				    	myBufferedWriter.write(tmpFinanceList.get(j));
				    	myBufferedWriter.newLine();
				        }
				        myBufferedWriter.close();
				}
				break;
				}
			
			case 2: {
								
				//TODO: открыть существующий файл (myfinance.txt) для расходов
				//TODO: считать все записи из файла как строки в структуру данных 
				//TODO: ExpenseRegister, 
				//TODO: объявленную как список объектов типа Expense	
				//TODO: определить, что удалять
				//TODO: удалить запись из ExpenseRegister
				//TODO: перезаписать файл с новыми данными.
				break;
			}
			case 3: {
				String msgExit = "Program closed.";
				System.out.println(msgExit);
				break;
				}
			}
		//}
	}
}