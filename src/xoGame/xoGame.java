package xoGame;

import java.util.Scanner;

public class xoGame {

	/*
	 * Объект КрестикиНоликиИгра (По псевдокоду = Игра)
	 * - запрашивает, считывает и возвращает тип игроков: 
	 * (человек-человек, человек-компьютер, компьютер-компьютер)  - метод DefineGamers()
	 */
	
	private String gameXOWinnerIs = "Tadam! The Game Winner's Name Is... ";
	private String gamersPairs = "You with your friend (press 1), you with me (press 2) or me with my AI (press 3)...";

	public void GameStart(int g) {
 		
		switch(g) {
			//Human with Human
			case 1: {
				System.out.println("Human with Human Game");
				//создаем 1-го игрока-человека
				xoPlayer x1Player = new xoPlayer();
				xoPlayer x2Player = new xoPlayer();
				
				//создаем доску
				xoGameBoard xoBoard = new xoGameBoard();
				
				//выводим правила игры
				String x1Pl = x1Player.doName();
				String x2Pl = x2Player.doName();
				xoBoard.GameRules(x1Pl, x2Pl);
				
				//выводим приглашение выбрать фигуру
				String mf = x1Player.doFigure();
				char myFishka[] = mf.toCharArray();
				
				char aiFishka; //оставшейся фигурой будет играть второй игрок
				if (myFishka[0] == 'X') {
					aiFishka = 'O';	
				}
				else {
					aiFishka = 'X';
				}
				
				//отрисовываем пустое поле
				xoBoard.drawField();
				
				//в начале игры доступно для хода 9 пустых клеток
				int m = 9; 

				//в начале игры еще нет линии крестиков или ноликов
				boolean human1Win = false; 
				boolean human2Win = false;

				//массивы координат для передачи полю ходов
				int human1XY[] = new int[2];
				int human2XY[] = new int[2];
				
				while (m > 0) { //пока есть пустые клетки на поле
					//ход игрока
					System.out.println("Игрок делает ход:");
					human1XY[0] = xoBoard.readXMove(); //x
					human1XY[1] = xoBoard.readYMove(); //y
					
					System.out.println("Игрок сделал ход, новое поле:");
					xoBoard.drawField(human1XY, human2XY, myFishka[0], aiFishka);
					
					//проверка, нет ли уже выигрыша
					System.out.println("Проверка, нет ли уже выигрыша.");
					human1Win = xoBoard.returnLines(myFishka[0]);
					human2Win = xoBoard.returnLines(aiFishka);
					System.out.println("humanWin = " + human1Win);
					System.out.println("aiWin = " + human2Win);
			
					while (m > 0) { //пока есть пустые клетки на поле
						//ход игрока 1
						System.out.println("Игрок делает ход:");
						human1XY[0] = xoBoard.readXMove(); //x
						human1XY[1] = xoBoard.readYMove(); //y
						
						System.out.println("Игрок сделал ход, новое поле:");
						xoBoard.drawField(human1XY, human2XY, myFishka[0], aiFishka);
						
						//проверка, нет ли уже выигрыша
						System.out.println("Проверка, нет ли уже выигрыша.");
						human1Win = xoBoard.returnLines(myFishka[0]);
						human2Win = xoBoard.returnLines(aiFishka);
						System.out.println("humanWin = " + human1Win);
						System.out.println("aiWin = " + human2Win);
						
						if (human1Win) {
							System.out.println("Сложилась линия." + myFishka[0]);
							break;
							} //если выигрыш случился - выходим из while
						
						if (human2Win) {
							System.out.println("Сложилась линия." + aiFishka);
							break;
							} //если выигрыш случился - выходим из while
						
						//пересчет количества доступных пустых клеток
						m = xoBoard.returnEmptyBoxesInTheField();
						System.out.println("Доступных для хода клеток " + m);
						
						System.out.println("Игрок делает ход:");
						human1XY[0] = xoBoard.readXMove(); //x
						human1XY[1] = xoBoard.readYMove(); //y
						
						System.out.println("Игрок сделал ход, новое поле:");
						xoBoard.drawField(human1XY, human2XY, myFishka[0], aiFishka);
						
						//проверка, нет ли уже выигрыша
						human1Win = xoBoard.returnLines(myFishka[0]);
						human2Win = xoBoard.returnLines(aiFishka);
						if (human1Win) {
							System.out.println("Сложилась линия." + myFishka[0]);
							break;
							} //если выигрыш случился - выходим из while
						
						if (human2Win) {
							System.out.println("Сложилась линия." + aiFishka);
							break;
							} //если выигрыш случился - выходим из while
						
						//отрисовка поля после хода игрока и хода компьютера
						System.out.println("Компьютер сделал ход, новое поле:");
						xoBoard.drawField(human1XY, human2XY, myFishka[0], aiFishka);
						
						//пересчет количества доступных пустых клеток
						m = xoBoard.returnEmptyBoxesInTheField();
						System.out.println("Доступных для хода клеток " + m);
						
					} //end while
					if (human1Win) {this.GameWinnerNameIs(x1Pl);}
					else if (human2Win) {this.GameWinnerNameIs(x2Pl);
					break; //выход из case 1
					}
				}
			}
			//Human with AI
			case 2: {
				System.out.println("Human with AI Game: \n");
				//создаем игрока-человека
				xoPlayer xPlayer = new xoPlayer();
				
				//создаем доску
				xoGameBoard xoBoard = new xoGameBoard();
				
				//выводим правила игры
				String xPl = xPlayer.doName();
				xoBoard.GameRules(xPl, "Dr. Zlo");
				
				//выводим приглашение выбрать фигуру
				String mf = xPlayer.doFigure();
				char myFishka[] = mf.toCharArray();
				
				char aiFishka; //оставшейся фигурой будет играть компьютер
				if (myFishka[0] == 'X') {
					aiFishka = 'O';	
				}
				else {
					aiFishka = 'X';
				}
				
				//отрисовываем пустое поле
				xoBoard.drawField();
				
				//в начале игры доступно для хода 9 пустых клеток
				int m = 9; 

				//в начале игры еще нет линии крестиков или ноликов
				boolean humanWin = false; 
				boolean aiWin = false;

				//массивы координат для передачи полю ходов
				int humanXY[] = new int[2];
				int aiXY[] = new int[2];
				
				while (m > 0) { //пока есть пустые клетки на поле
					//ход игрока
					System.out.println("Игрок делает ход:");
					humanXY[0] = xoBoard.readXMove(); //x
					humanXY[1] = xoBoard.readYMove(); //y
					
					System.out.println("Игрок сделал ход, новое поле:");
					xoBoard.drawField(humanXY, aiXY, myFishka[0], aiFishka);
					
					//проверка, нет ли уже выигрыша
					System.out.println("Проверка, нет ли уже выигрыша.");
					humanWin = xoBoard.returnLines(myFishka[0]);
					aiWin = xoBoard.returnLines(aiFishka);
					System.out.println("humanWin = " + humanWin);
					System.out.println("aiWin = " + aiWin);
					
					if (humanWin) {
						System.out.println("Сложилась линия." + myFishka[0]);
						break;
						} //если выигрыш случился - выходим из while
					
					if (aiWin) {
						System.out.println("Сложилась линия." + aiFishka);
						break;
						} //если выигрыш случился - выходим из while
					
					//пересчет количества доступных пустых клеток
					m = xoBoard.returnEmptyBoxesInTheField();
					System.out.println("Доступных для хода клеток " + m);
					
					//ход компьютера
					System.out.println("Компьютер делает ход:");
					aiXY = xoPlayer.doAIMove(xoBoard, myFishka[0], aiFishka);
					
					//проверка, нет ли уже выигрыша
					humanWin = xoBoard.returnLines(myFishka[0]);
					aiWin = xoBoard.returnLines(aiFishka);
					if (humanWin) {
						System.out.println("Сложилась линия." + myFishka[0]);
						break;
						} //если выигрыш случился - выходим из while
					
					if (aiWin) {
						System.out.println("Сложилась линия." + aiFishka);
						break;
						} //если выигрыш случился - выходим из while
					
					//отрисовка поля после хода игрока и хода компьютера
					System.out.println("Компьютер сделал ход, новое поле:");
					xoBoard.drawField(humanXY, aiXY, myFishka[0], aiFishka);
					
					//пересчет количества доступных пустых клеток
					m = xoBoard.returnEmptyBoxesInTheField();
					System.out.println("Доступных для хода клеток " + m);
					
				} //end while
				if (humanWin) {this.GameWinnerNameIs(xPl);}
				else if (aiWin) {this.GameWinnerNameIs("Dr.Zlo");
				break; //выход из case 2
				}
			}
			//AI with AI
			case 3: {
				System.out.println("AI with AI Game");
				break;
			}
		}
	}
	
	public void GameWinnerNameIs (String WinnerName){
		gameXOWinnerIs = gameXOWinnerIs + WinnerName;
		System.out.print (gameXOWinnerIs);		
	}

	//выбрать, кто с кем играет
	public int DefineGamers () {
		Integer who = 0;
		who = Integer.parseInt(ReadUserInputHelper.getUserInput(gamersPairs));
		return who;
	}
}