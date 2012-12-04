package ExpensesTask;

import java.util.ArrayList;
import java.util.List;

public class MainForExpense {

	public static void main(String[] args) {

		//делаем главное меню
		String msgMainMenu = "User Menu: \n";
		String msg0 = "1 - add new expense to the list\n";
		String msg1 = "2 - remove expense from the list\n";
		String msg2 = "3 - view list of expenses\n";
		String msg3 = "4 - restore expense list from backup\n";
		String msg4 = "5 - exit\n";
		
		msgMainMenu = msgMainMenu + msg0 + msg1 + msg2 + msg3 + msg4; 
		
		//делаем меню приглашения ко вводу
		String msgEnterData = "Введите дату:";
		String msgEnterSum = "Введите сумму:";
		String msgEnterDescription = "Введите комментарий к расходам:";
		
		//запрос номера строки для удаления
		String recordToDelete = "Введите номер записи, которую хотите удалить.";
		
		List <Expense> list = new ArrayList <Expense>();
		
		//ожидаем ввод пользователем выбора из главного меню
		Integer i = 0; 

		boolean menu1 = true;
		while (menu1) {
			String userInput = ReadUserInputHelper.getUserInput(msgMainMenu);
			i = Integer.parseInt(userInput);
			
			switch (i) {
				case 1: { //добавление одной записи, данные из ввода пользователя

						String date = ReadUserInputHelper.getUserInput(msgEnterData);
						String sum = ReadUserInputHelper.getUserInput(msgEnterSum);
						String desc = ReadUserInputHelper.getUserInput(msgEnterDescription);
						
						Expense myExpense = new Expense(date,sum,desc);
						list.add(myExpense);
						break;
					}
					
				
				case 2: {//удаление одной записи из списка расходов 
					
					Integer l;
					String userWantDelete = ReadUserInputHelper.getUserInput(recordToDelete);
					l = Integer.parseInt(userWantDelete);
					System.out.println(l);
					
					list.remove(l);
					break;
						
				}
				
				//просмотреть список расходов (если список расходов 
				//в памяти пуст, загрузить из файла
				//иначе загрузить из памяти)
				case 3: {
					int j;
					for (j = 0; j < list.size(); j++) {
					String q = list.get(j).getDate() + list.get(j).getSum() +list.get(j).getDescription();
					System.out.println(j + " : " + q);
					}
					break;
				}
				case 4: {//восстановить список расходов из бекапа
					break;
				}
				//выход из программы
				case 5: { 
					String msgExit = "Program closed.";
					System.out.println(msgExit);
					menu1 = false;
					break;
					}
				
				default: {
					String msgInv = "Invalid menu option.";
					System.out.println(msgInv);
					break;
				}
				}
			}
		}
	}
