package OZA_JAVA1_Homework;

//вывести меню пользователя

//0:
//если нет файла для расходов, создать файл (myfinance.txt)
//создать структуру данных ExpenseRegister как список объектов типа Expense

//1:
//искать существующий файл (myfinance.txt) для расходов
//открыть его для редактирования
//считать все записи в структуру данных ExpenseRegister, 
//объявленную как список объектов типа Expense

//СТАНДАРТНАЯ ЧАСТЬ РЕДАКТИРОВАНИЯ
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
		String msg2 = "2 - close program\n";
		String msg21 = "Program is closed.";
		
		msgMenu = msgMenu + msg1 + msg2; 
		
		String userInput = ExpenseInputHelper.getUserInput(msgMenu);
		
		while (userInput != null) {
		
			for (int i = 0; i<3; i++) {
				switch (i) {

				//0:
				//если нет файла для расходов, создать файл (myfinance_ddmmyyyy.txt)
				//создать структуру данных ExpenseRegister как список объектов типа Expense
				case 0: {
					ExpenseRegister myFinance = new ExpenseRegister();
					} //end case 0
			
				//1:
				//искать существующий файл (myfinance.txt) для расходов
				//считать все записи в структуру данных ExpenseRegister, 
				//объявленную как список объектов типа Expense
				case 1: {
				
					} //end case 1
				
				//2:
				//выход из программы
				case 2: {
					System.out.println(msg21);
					break;
				} //end case 2
								
				}//end switch i
			}//end for i loop	
		}//end while loop for empty user' input
	} //end main method 
} //end ExpenseTestClass
