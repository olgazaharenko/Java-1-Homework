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
				break;
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
				
				int m = 9; //в начале игры доступно для хода 9 пустых клеток

				//проверим, нет ли уже линии крестиков или ноликов
				boolean humanWin = false; 
				boolean aiWin = false; 
				int humanXY[] = new int[2];
				int aiXY[] = new int[2];

				while (m > 0) { //пока есть пустые клетки на поле
					//ход игрока
					System.out.println("Игрок делает ход:");
					humanXY[0] = xoBoard.readXMove(); //x
					humanXY[1] = xoBoard.readYMove(); //y
					xoBoard.returnFinalGameFieldBox();
					
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
					xoBoard.returnFinalGameFieldBox();
					
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