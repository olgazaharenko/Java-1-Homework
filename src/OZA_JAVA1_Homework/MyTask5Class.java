package OZA_JAVA1_Homework;

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
	 * Решение. Загадайте число от 1 до 100
	 * Скажите мне, оно больше 50?
	 * Варианты: >, <, =
	 * ответ: <
	 * Считаем половину от 50
	 * и задаем новый вопрос:
	 * Скажите мне, оно больше 25?
	 * Варианты: >, <, =
	 * ответ: >
	 * Считаем расстояние от 25 до 50, делим пополам, прибавляем к 25 - получаем 37.5, округляем до 37 и задаем новый вопрос
	 * Скажите мне, оно больше 37? Варианты: >, <, =
	 * ответ: <
	 * Считаем расстояние от 25 до 37, делим пополам, прибавляем к 25 - получаем 31, округлять не надо, задаем новый вопрос
	 * Скажите мне, оно больше 31? Варианты: >, <, =
	 * ну и так до угадывания
	 * надо обеспечить сходимость к точке 
	 * 
	 * Алгоритм
	 * 
	 * Определить временную переменную temp
	 * Инициализировать ее temp = 50
	 * 
	 * Определить временную переменную Flag
	 * 
	 * Определить граничные переменные Start и End
	 * Инициализировать их как Start = 0, End = 100 	 
	 * 
	 *     
	 * Функция Ask вызова приглашения и получения ответа: 
	 * Ask (Start, End, temp, Flag): {
	 * 
	 * Вывести приглашение загадать число от Start до End
	 * Вывести вопрос "Загаданное число больше temp?
	 * Варианты ответов: Flag = да (Y), Flag = нет (N), Flag = равно (=)"
	 * Return Flag;
	 * }
	 * 
	 * Обработать варианты ответов
	 * 
	 * Вариант Flag = да (Y): работаем с отрезком числовой прямой от temp до End, включая End
	 * 
	 * While (End - temp)/2 != 0 do: {
	 * Вызываем Ask (temp, End, (End - temp)/2);
	 * 
	 * }
	 *   
	 * Вариант Flag = нет (N): работаем с отрезком числовой прямой от Start до temp, включая Start:
	 * 
	 * Вариант Flag = равно (=): Выводим ответ "Вы загадали число " + temp 
	 * 
	 * 
	 * Запомнить введенное число во вспомогательной переменной temp
	 * 
	 * 
	 * -----------------------------------------------------------------------
	 * 
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
