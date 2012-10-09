/*
 * The Package with implementation of tasks for Lecture 1, Java 1.
 */
/*
 * @author Olga Zaharenko
 *
 */

package OZA_JAVA1_Homework;

import java.util.Scanner;

public class MyTask1Class {
	/*
	 * Task 1. Find greatest value among 3 variables. 
	 * Write a program which finds a greatest value among 3 integer variables
	 * -----------------------------------------------------------------------
	 * Решение.
	 * Объявляем массив типа int из 3-х элементов, 
	 * создаем экземпляр массива, 
	 * готовим данные для массива (генерим, задаем или считываем с экрана),
	 * объявляем целую переменную max, 
	 * записываем в нее первый элемент массива и 
	 * в цикле for сравниваем с ней все остальные элементы массива. 
	 * Как только находится бОльший элемент, 
	 * перезаписываем его в переменную max. 
	 * После завершения цикла сравнения выводим на печать переменную max.
	 * ---------------------------------------------------------------------
	 */
	public static void main(String[] args) {

		/* Declare and initialize integer variables: mEm, k, j: */

		int mEm = 0;

		/* Declare and create array as integer, 3 elements: */

		int[] myArray;

		myArray = new int[3];
		
		/* Prepare data for array - invite the user to enter data from keyboard: */

		Scanner reader = new Scanner(System.in);
		for (int k = 0; k <= 2; k++) {
			System.out.println("Enter an integer number and press enter:");
			myArray[k] = reader.nextInt();
		}

		/* Save 1-st array's element as max: */

		mEm = myArray[0];

		/* Compare all array's elements with max within FOR cycle: */

		for (int j = 1; j <= 2; j++) {
			if (myArray[j] > mEm) {

				mEm = myArray[j];

			}
		}

		/* Output result: */
		System.out.println("Max number from the array = " + mEm);
	}
}
