package OZA_JAVA1_Homework;

import java.util.Scanner;

public class xoPlayer {


	/*
	 * Объект Игрок-Компьютер
	 * - запрашивает, считывает и возвращает имя игрока-человека - метод doName (String xoPlayerName) 
	 * - запрашивает, считывает и возвращает фигуру игрока - метод doFigure ()
	 * 
	 * - рассчитывает ходы (должен иметь доступ ко всем полям и методам объекта Поле)
	 */

	private String xoPlayerName = "What is your name? Just print it...";
	private String computer1Name = "My name is Dr. Z-z-zlo. ";
	private String computerTalk = "And yours? Just print it...";
	private String computer2Name = "No, it's my name is Dr. Z-z-zlo. ";
	private String HumanXOFigureChoice = "What is your figure to play with? Just print it...";
	
	public static void doAIMove() {

	/*
	 * Запросить множество координат всех свободных клеток у поля
	 * Оценить вероятность выигрыша при ходе на каждую из этих клеток
	 * Выбрать для хода клетку с самой высокой оценкой вероятности выигрыша
	 * Передать координаты выбранной клетки полю для отрисовки хода 
	 * 
	 */
		
		
	}
	
	
	public String doName () {
		
		String userName = "";
		System.out.print(xoPlayerName);
		Scanner reader = new Scanner(System.in);
		while (reader.nextLine() != " ") {
			userName = userName + reader.nextLine();
		}
		return userName;
	}

	public String doFigure () {
		
		String userFigure = "";
		
		System.out.print(HumanXOFigureChoice);
		Scanner reader = new Scanner(System.in);
    	userFigure = reader.nextLine();
		return userFigure;
	}
	
}
