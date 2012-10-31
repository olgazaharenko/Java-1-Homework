/*
 * The Package with implementation of Task1 for Lecture 1, Java 1.
 */
/*
 * @author Olga Zaharenko
 *
 */

package OZA_JAVA1_Homework;


public class MyTask2Class {

	/*
	 * Task 2. Количество четных и нечетных чисел. 
	 * В программе задан массив целых чисел. 
	 * Программа должна сообщить, сколько в нем четных чисел и 
	 * сколько нечетных.
	 * ---------------------------------------------------------------
	 * Решение. Объявляем массив типа int, 
	 * создаем экземпляр массива, 
	 * объявляем 2 целые переменные 4et и ne4et, 
	 * инициализируем нулем обе переменные и 
	 * в цикле for проверяем все элементы массива на остаток деления на 2. 
	 * Есть остаток - увеличиваем счетчик ne4et на единицу, 
	 * нет остатка - увеличиваем счетчик 4et на единицу. 
	 * После завершения цикла сравнения 
	 * выводим на экран значения переменных 4et и ne4et. 
	 * -----------------------------------------------------------------------
	 * 
	 */
	public static void main(String[] args) {
		
		/* Declare and initialize integer variables: 4et and ne4et: */

		int even = 0;
		int odd = 0;

		/* Declare and create array as integer, 11 elements: */

		int[] myArray;

		myArray = new int[11];
		
		/* Predefine array */

		myArray[0]=1;
		myArray[1]=22;
		myArray[2]=14;
		myArray[3]=41;
		myArray[4]=5;
		myArray[5]=82;
		myArray[6]=38;
		myArray[7]=56;
		myArray[8]=66;
		myArray[9]=69;
		myArray[10]=78;
		
		/* Compare all array's elements with result of %2 within FOR cycle: */

		for (int j = 0; j <= 10; j++) {
			if (myArray[j]%2 != 0) {

				odd++;

			}
			else {
				even++;
			}
		}

		/* Output result: */
		System.out.println("Amount of even numbers from the array = " + even);
		System.out.println("Amount of odd numbers from the array = " + odd);
	
	}
	
	}
