package xoGame;

import java.util.Random;

public class xoPlayer {


	/*
	 * Объект Игрок-Компьютер
	 * - запрашивает, считывает и возвращает имя игрока-человека - метод doName (String xoPlayerName) 
	 * - запрашивает, считывает и возвращает фигуру игрока - метод doFigure ()
	 * - рассчитывает ходы (должен иметь доступ ко всем полям и методам объекта Поле)
	 */

	private String xoPlayerName = "What is your name? Just print it...";
	private String computer1Name = "My name is Dr. Z-z-zlo. ";
	private String computerTalk = "And yours? Just print it...";
	private String computer2Name = "No, it's my name is Dr. Z-z-zlo. ";
	private String HumanXOFigureChoice = "What is your figure to play with? Just print it...";
	
	public static int[] doAIMove(xoGameBoard xoBoard, char xFishka, char oFishka) {

	/*
	 * Запросить множество координат всех свободных клеток у поля
	 * Оценить вероятность выигрыша при ходе на каждую из этих клеток
	 * Выбрать для хода клетку с самой высокой оценкой вероятности выигрыша
	 * Передать координаты выбранной клетки полю для отрисовки хода 
	 *
	 * Реализация критерия выбора хода компьютером
	 *
	 * определим функцию p выиграть, сделав ход в клетку с координатами (x,y) = (i,j)
	 * как (1, 0, -1)
	 * p = 1, если на одной линии с клеткой (i,j) есть клетки, где уже поставлена своя фигура
	 * p = 0, если все клетки на одной линии с клеткой (i,j) пусты
	 * p = -1, если на одной линии с клеткой (i,j) более 0 клеток 
	 * уже заняты противоположной фигурой
	 *  
	 * выбираем для хода компьютера клетку с наибольшим значением функции p
	 *
	 * определим линии относительно клеток, которые нужно проверять на наличие либо
	 * своей фигуры, либо фигуры противника 
	 * и присваивать клетке значение функции p по результату проверки
	 * 
	 * (0,0):
	 * {(1,1),(2,2)}
	 * {(0,1),(0,2)}
	 * {(1,0),(2,0)}
	 * 
	 * (1,0):
	 * {(0,0),(2,0)}
	 * {(1,1),(1,2)}
	 * 
	 * (2,0):
	 * {(0,0),(1,0)}
	 * {(2,1),(2,2)}
	 * {(1,1),(0,2)}
	 * 
	 * (0,1):
	 * {(0,0),(0,2)}
	 * {(1,1),(2,1)}
	 * 
	 * (1,1):
	 * {(0,0),(2,2)}
	 * {(0,2),(2,0)}
	 * {(0,1),(2,1)}
	 * {(1,0),(1,2)}
	 *
	 * (2,1):
	 * {(2,0),(2,2)}
	 * {(0,1),(2,1)}
	 * 
	 * (0,2):
	 * {(0,0),(0,1)}
	 * {(1,1),(2,0)}
	 * {(1,2),(2,2)}
	 * 
	 * (1,2):
	 * {(1,0),(1,1)}
	 * {(0,2),(2,2)}
	 *
	 * (2,2):
	 * {(0,0),(1,1)}
	 * {(0,2),(1,2)}
	 * {(2,0),(2,1)}
	 * 
	 */
	
	int moveAI[] = new int[2];
	int xAI = 0;
	int yAI = 0;
	
	//Получить состояние поля на момент оценки
	char t[][] = new char [3][3];
	t = xoBoard.returnFinalGameFieldBox();
	
	for (int i = 0; i <= 2; i++) {
		for (int j = 0; j <= 2; j++) {
			
			//берем незанятую клетку
			if ((t[i][j] != xFishka) && (t[i][j] != oFishka)) {
			
			//изначально считаем, что линии пусты и готовимся к ходу
			int p = 0;

			//в зависимости от координат выбранной клетки пробегаем по линиям:

			//(0,0):
			//{(1,1),(2,2)}
			//{(0,1),(0,2)}
			//{(1,0),(2,0)}
			//
			
			if ((i==0) && (j==0)) {
				if ((t[1][1] == xFishka) || (t[2][2] == xFishka) || (t[0][1] == xFishka) || (t[0][2] == xFishka || (t[1][0] == xFishka) || (t[2][0] == xFishka))) { 
					//если есть своя фигура на клетках линий
					p = 1;
				} else if ((t[1][1] == oFishka) || (t[2][2] == oFishka) || (t[0][1] == oFishka) || (t[0][2] == oFishka || (t[1][0] == oFishka) || (t[2][0] == oFishka))) {
					//если есть фигура противника на клетках линий
					p = -1;
				}
			}
			
			//
			//(1,0):
			//{(0,0),(2,0)}
			//{(1,1),(1,2)}
			//
			
			if ((i==1) && (j==0)) {
				if ((t[0][0] == xFishka) || (t[2][0] == xFishka) || (t[1][1] == xFishka) || (t[1][2] == xFishka)) { 
					//если есть своя фигура на клетках линий
					p = 1;
				} else if ((t[0][0] == oFishka) || (t[2][0] == oFishka) || (t[1][1] == oFishka) || (t[1][2] == oFishka)) {
					//если есть фигура противника на клетках линий
					p = -1;
				}
			}
			
			//(2,0):
			//{(0,0),(1,0)}
			//{(2,1),(2,2)}
			//{(1,1),(0,2)}
			
			if ((i==2) && (j==0)) {
				if ((t[0][0] == xFishka) || (t[1][0] == xFishka) || (t[2][1] == xFishka) || (t[2][2] == xFishka) || (t[1][1] == xFishka) || (t[0][2] == xFishka)) { 
					//если есть своя фигура на клетках линий
					p = 1;
				} else if ((t[0][0] == oFishka) || (t[1][0] == oFishka) || (t[2][1] == oFishka) || (t[2][2] == oFishka) || (t[1][1] == oFishka) || (t[0][2] == oFishka)) {
					//если есть фигура противника на клетках линий
					p = -1;
				}
			}
			
			//
			//(0,1):
			//{(0,0),(0,2)}
			//{(1,1),(2,1)}
			//
			
			if ((i==0) && (j==1)) {
				if ((t[0][0] == xFishka) || (t[0][2] == xFishka) || (t[1][1] == xFishka) || (t[2][1] == xFishka)) { 
					//если есть своя фигура на клетках линий
					p = 1;
				} else if ((t[0][0] == oFishka) || (t[0][2] == oFishka) || (t[1][1] == oFishka) || (t[2][1]) == oFishka) {
					//если есть фигура противника на клетках линий
					p = -1;
				}
			}			
			
			//(1,1):
			//{(0,0),(2,2)}
			//{(0,2),(2,0)}
			//{(0,1),(2,1)}
			//{(1,0),(1,2)}
			//

			if ((i==1) && (j==1)) {
				if ((t[0][0] == xFishka) || (t[2][2] == xFishka) || (t[0][2] == xFishka) || (t[0][1] == xFishka)  || (t[2][1] == xFishka)  || (t[1][0] == xFishka)  || (t[1][2] == xFishka)) { 
					//если есть своя фигура на клетках линий
					p = 1;
				} else if ((t[0][0] == oFishka) || (t[2][2] == oFishka) || (t[0][2] == oFishka) || (t[0][1] == oFishka)  || (t[2][1] == oFishka)  || (t[1][0] == oFishka)  || (t[1][2] == oFishka)) {
					//если есть фигура противника на клетках линий
					p = -1;
				}
			//если вероятность выиграть равна 0 или 1, то делаем ход в проверенную клетку
				if (p >= 0) {
					xAI = 1;
					yAI = 1;
				}
			}			

			//(2,1):
			//{(2,0),(2,2)}
			//{(0,1),(2,1)}
			//

			if ((i==2) && (j==1)) {
				if ((t[2][0] == xFishka) || (t[2][2] == xFishka) || (t[0][1] == xFishka) || (t[2][1] == xFishka)) { 
					//если есть своя фигура на клетках линий
					p = 1;
				} else if ((t[2][0] == oFishka) || (t[2][2] == oFishka) || (t[0][1] == oFishka) || (t[2][1]) == oFishka) {
					//если есть фигура противника на клетках линий
					p = -1;
				}
			}			
			
			//(0,2):
			//{(0,0),(0,1)}
			//{(1,1),(2,0)}
			//{(1,2),(2,2)}
			//
			
			if ((i==0) && (j==2)) {
				if ((t[0][0] == xFishka) || (t[0][1] == xFishka) || (t[1][1] == xFishka) || (t[2][0] == xFishka) || (t[1][2] == xFishka) || (t[2][2] == xFishka)) { 
					//если есть своя фигура на клетках линий
					p = 1;
				} else if ((t[0][0] == oFishka) || (t[0][1] == oFishka) || (t[1][1] == oFishka) || (t[2][0] == oFishka) || (t[1][2] == oFishka) || (t[2][2] == oFishka)) {
					//если есть фигура противника на клетках линий
					p = -1;
				}
			}
			
			//(1,2):
			//{(1,0),(1,1)}
			//{(0,2),(2,2)}
			//
			
			if ((i==1) && (j==2)) {
				if ((t[1][0] == xFishka) || (t[1][1] == xFishka) || (t[0][2] == xFishka) || (t[2][2] == xFishka)) { 
					//если есть своя фигура на клетках линий
					p = 1;
				} else if ((t[1][0] == oFishka) || (t[1][1] == oFishka) || (t[0][2] == oFishka) || (t[2][2]) == oFishka) {
					//если есть фигура противника на клетках линий
					p = -1;
				}
			}
			
			//(2,2):
			//{(0,0),(1,1)}
			//{(0,2),(1,2)}
			//{(2,0),(2,1)}
			//

			if ((i==2) && (j==2)) {
				if ((t[0][0] == xFishka) || (t[1][1] == xFishka) || (t[0][2] == xFishka) || (t[1][2] == xFishka) || (t[2][0] == xFishka) || (t[2][1] == xFishka)) { 
					//если есть своя фигура на клетках линий
					p = 1;
				} else if ((t[0][0] == oFishka) || (t[1][1] == oFishka) || (t[0][2] == oFishka) || (t[1][2] == oFishka) || (t[2][0] == oFishka) || (t[2][1] == oFishka)) {
					//если есть фигура противника на клетках линий
					p = -1;
				}
			}
	
			//если вероятность выиграть равна 0 или 1,
			//то делаем ход в проверенную клетку
			if (p >= 0)  {
				xAI = i;
				yAI = j;
			}
			
				moveAI[0] = xAI;
				moveAI[1] = yAI;
			//	System.out.println("xAI = " + xAI);
			//	System.out.println("yAI = " + yAI);
			}
		}
		
	}
	
	//Передать координаты выбранной клетки полю для отрисовки хода 
	return moveAI;
	}
	
	public String doName () {
		String userName = "";
		userName = ReadUserInputHelper.getUserInput(xoPlayerName);
		return userName;
	}

	public String doFigure () {
		String userFigure = "";
		userFigure = ReadUserInputHelper.getUserInput(HumanXOFigureChoice);
		return userFigure;
	}
}
