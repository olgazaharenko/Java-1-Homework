/**
 * The Package with implementation of tasks for Lecture 1, Java 1.
 */
/**
 * @author Olga Zaharenko
 *
 */
package OZA_JAVA1_Homework;

import java.util.Scanner;

public class MyTasksClass {
/**
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
 /** Declare array as integer: */
 
int x[];

 /** Create instance of array, 3 elements: */
int x[] = new x[2];
  
 /** Prepare data for array - invite the user to enter data from keyboard: */

Scanner scanner = new Scanner(System.in)
for (int i=0, i<=2, i++) {
	System.out.println ("Enter an integer number and press enter");
	x[i] = Scanner.nextInt();
};
 
/** Declare integer variable max: */

int max;

/** Save 1-st array's element as max:*/

max = x[0];

/** Compare all array's elements with max within FOR cycle:*/

for (int i=1; i<=2; i++) {
	if (x[i] - max) < 0 then max = x[i];
};
 
/** Output result:*/
System.out.println ("Max number from the array = " + max);
}
}
