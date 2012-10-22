package OZA_JAVA1_Homework;

import java.util.Scanner;

public class MyTask3Class {

	/*
	 * Task 3. На бумаге: переворот массива. 
	 * На бумаге написать функцию на Java, которая получает в качестве аргумента массив 
	 * и разворачивает его задом наперед, т.е. первый элемент становится последним, 
	 * второй  - предпоследним и т.д. Результатом должен быть перевёрнутый массив, 
	 * а не вывод элементов исходного в обратном порядке. 
	 * В качестве ответа сдать фотографию листочка с программой.
	 * ---------------------------------------------------------------
	 * Решение (логика). Возьмем массив x[n]. Рассматриваем 2 случая - четное число элементов 
	 * массива и нечетное число элементов массива. 
	 * В случае четного числа элементов массива последовательно
	 * меняем: 
	 * 1 c n
	 * 2 c n-1
	 * 3 c n-2
	 * ...
	 * всего понадобится n/2 шагов в цикле замены.
	 * В случае, когда в массиве нечетное число элементов, 
	 * понадобится (n/2 + 1) шагов в цикле замены.
	 * Для удобства (чтобы было во всех случаях одинаковое число шагов в цикле) 
	 * введем переменную cчетчика цикла i = n%2 .
	 * 
	 * Программа.
	 * 
	 * Декларировать вспомогательные переменные: 
	 * 
	 * n для размерности массива:
	 * 
	 * int n;
	 * 
	 * k для временного хранения переворачиваемого элемента:
	 * 
	 * int k;
	 * 
	 * Задать размерность массива числом n.
	 * 
	 * n=12;
	 * 
	 * Рассчитать предельное значение счетчика цикла i = n/2 операцией целого деления;
	 * 
	 * i=n/2;
	 * 
	 * Декларировать и инициализировать массив, который будет переворачиваться:
	 *  
	 * int[] s;
	 * s = new int[13];
	 * 
	 * s[0]=0;
	 * s[1]=1;
	 * s[2]=2;
	 * s[3]=3;
	 * s[4]=4;
	 * s[5]=5;
	 * s[6]=6;
	 * s[7]=7;
	 * s[8]=8;
	 * s[9]=9;
	 * s[10]=10;
	 * s[11]=11;
	 * s[12]=12;
	 *  
	 * Декларировать и объявить вспомогательный массив:
	 *  
	 * int[] temp_Array_for_Print;
	 * temp_Array_for_Print = new int[13];
	 *  
	 * Скопировать исходный массив s[n] в temp_Array_for_Print[n]:
	 * 
	 * for (int l=1; l<=n; l++) {
	 *   temp_Array_for_Print[l] = s[l];
	 * }
	 * 
	 * Запустить цикл перестановки:
	 * 
	 * for (int j=1; j<=i; j++) {
	 *   k = s[j];
	 *    
	 *   s[j] = s[n+1-j];
	 *     
	 *   s[n+1-j] = k;
	 *       
	 * }
	 * 
	 * Вывести копию исходного массива:
	 * 
	 * for (int m=1; m<=n; m++) {
	 *   System.out.println {temp_Array_for_Print[n]);
	 * }
	 * 
	 * И перевернутый массив:
	 * 
	 * for (int p=1; p<=n; p++) {
	 *   System.out.println {s[p]);
	 * }
	 * 
	 * -----------------------------------------------------------------------
	 * 
	 */
	public static void main(String[] args) {
	
	/* Declare auxiliary variables: 
	 * n as array's dimension; 
	 * k as temporary storage 
	 * i as cycle counter 
	*/ 
	int n;
	int k;
	int i;
	n = 13;
	
	/* Calculate end value for cycle counter i = n/2 */
	i = n/2;

	/* Declare and initialize array what will transformed: */
	int[] s;
	s = new int[n];
	s[0]=13;
	s[1]=12;
	s[2]=11;
	s[3]=10;
	s[4]=9;
	s[5]=8;
	s[6]=7;
	s[7]=6;
	s[8]=5;
	s[9]=4;
	s[10]=3;
	s[11]=2;
	s[12]=1;

	/* Declare and initialize array what will transformed: */
	int[] temp_Array_for_Print;
	temp_Array_for_Print = new int[n];
	temp_Array_for_Print[0]=0;
	temp_Array_for_Print[1]=0;
	temp_Array_for_Print[2]=0;
	temp_Array_for_Print[3]=0;
	temp_Array_for_Print[4]=0;
	temp_Array_for_Print[5]=0;
	temp_Array_for_Print[6]=0;
	temp_Array_for_Print[7]=0;
	temp_Array_for_Print[8]=0;
	temp_Array_for_Print[9]=0;
	temp_Array_for_Print[10]=0;
	temp_Array_for_Print[11]=0;
	temp_Array_for_Print[12]=0;

	/* Скопировать исходный массив s[n] в temp_Array_for_Print[n]:*/
	for (int l=0; l<=n-1; l++) {
	temp_Array_for_Print[l] = s[l];
	}

	/* Do cycle of transformation: */

	for (int j=0; j<=i; j++) {
		k = s[j];
		s[j] = s[n-1-j];
		s[n-1-j] = k;
	}

	/* Print original array: */
	System.out.println ("---------Original array-----------");
	for (int m=0; m<=n-1; m++) {
		System.out.println (" | " + temp_Array_for_Print[m] + " | ");
	}
	System.out.println ("---------Transformed array----");
	/* Print transformed array: */
	for (int p=0; p<=n-1; p++) {
		System.out.println (" | " + s[p] + " | ");
	}
  }
}
