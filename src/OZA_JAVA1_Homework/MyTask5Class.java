package OZA_JAVA1_Homework;

import java.util.Scanner;

public class MyTask5Class {

	/*
	 * Task 5. !Угадайка. 
	 * 1. Пользователь загадывает число от 1 до 100. 
	 * 2. Программа выводит число. 
	 * Пользователь отвечает, было ли это число больше, меньше или равно загаданному. 
	 * 3. Если число не отгадано, переход к шагу 2. 
	 * Возможны 2 реализации - 
	 * 1. Программа стремится сделать минимальное число ходов. 
	 * 2. Программа делает случайные ходы. 
	 * (При этом не делаются попытки угадать заранее неправильное число. 
	 * Если пользователь на число 50 ответил, что загаданное число больше, 
	 * то программа не станет называть числа меньше 50.)
	 * ---------------------------------------------------------------
	 */
	public static void main(String[] args) {
			int start = 0;
			int end = 100; 
			
			int newLimit;
			newLimit = (end-start)/2;
			
			int keyToWin;
			keyToWin = askUserToCompareNumber (newLimit);
			
			while (keyToWin != 2) {
				
				switch (keyToWin) {
				
				case 0:
					end = newLimit;
					newLimit = newLimit - findNewTarget(start,end);
					keyToWin = askUserToCompareNumber (newLimit);
				break;
				
				case 1:
					start = newLimit;
					newLimit = newLimit + findNewTarget(start,end);
					keyToWin = askUserToCompareNumber (newLimit);
				break;
				
				}
						
			}
			
			printGuessNumber (newLimit);
						
		}
		
		public static int findNewTarget (int start, int end) {
			int target;
			target=(end - start)/2;
			return target;
		}
		
		public static int askUserToCompareNumber (int lim) {
			int userAnswer;
			userAnswer=5;
			
			while (userAnswer != 0 && userAnswer != 1 && userAnswer != 2) { 
		    	System.out.println ("I may guess the number in your head. Please think about it and answer me either your number is less (0), more (1) or equal (2) then " + lim + "? Enter 0, 1 or 2.");
		    	Scanner reader = new Scanner(System.in);
		    	userAnswer = reader.nextInt();
			} 
		return userAnswer;
		}
		
		public static void printGuessNumber (int guessNumber) {
			System.out.println("I guess your number. It was " + guessNumber);
		}
		
}
