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
			
			String keyToWin;
			keyToWin = askUserToCompareNumber (newLimit);
			
			while (keyToWin != "E") {
				
				keyToWin = askUserToCompareNumber (newLimit);
				
				switch (keyToWin) {
				
				case "Y":
					end = newLimit;
					newLimit = newLimit - findNewTarget(start,end);
				break;
				
				case "N":
					start = newLimit;
					newLimit = newLimit + findNewTarget(start,end);
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
		
		public static String askUserToCompareNumber (int lim) {
			String userAnswer;
			userAnswer=null;
			
			while (userAnswer != "Y" || userAnswer != "N" || userAnswer != "E") {
			
			System.out.println ("Your number is less (Y), more (N) or equal (E) then " + lim + "? Use Y, N or E symbols only");
			Scanner reader = new Scanner(System.in);
			userAnswer = reader.nextLine();
			}
			
			return userAnswer;
		}
		
		public static void printGuessNumber (int guessNumber) {
			System.out.println("I guess your number. It was " + guessNumber);
		}
		
}
