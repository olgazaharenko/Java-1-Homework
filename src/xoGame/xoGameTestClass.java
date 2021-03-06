package xoGame;

public class xoGameTestClass {

	/**
	 * Объектная модель.
	 * -------------------------------------------------------------------------------------
	 *
	 * Объект КрестикиНоликиИгра (По псевдокоду = Игра)
	 * - выводит правила игры - метод GameRules()
	 * - выводит предложение сыграть - метод GameInvitation()
	 * - запрашивает, считывает и возвращает тип игроков: 
	 * (человек-человек, человек-компьютер, компьютер-компьютер)  - метод DefineGamers()
	 * - запрашивает, считывает и возвращает фигуры игроков - метод LetMeKnowWhatIsYourFigure ()
	 * - запрашивает, считывает и возвращает имена игроков - метод LetMeKnowWhatIsYourName (String ComputerXOPlayerName) 
	 * - выводит имя победителя -  метод GameWinnerNameIs (String WinnerName)
	 * - завершает игру - метод GameOver ()
	 * 
	 * Объект Поле
	 * - отрисовывает графику поля (пустого или с ходом) одним перегруженным методом drawField ()
	 * или drawField (int x, int y, char F)
	 * - возвращает массив координат элементов множества пустых Клеток - EmptyFieldBoxes()
	 * - считывает ходы Игрока (неважно какого) - ReadXMove(), ReadYMove()
	 * - хранит и возвращает информацию о максимальном количестве Клеток в поле - maxBoxInTheField
	 * - хранит и возвращает доступное количество пустых Клеток после каждого хода - returnEmptyBoxInTheField()
	 * - хранит и возвращает информацию о количестве заполненных Х линиях поля - returnLinesX()
	 * - хранит и возвращает информацию о количестве заполненных О линиях поля - returnLinesO()
	 *  
	 * Объект Игрок-Компьютер
	 * - рассчитывает ходы (должен иметь доступ ко всем полям и методам объекта Поле)
	 * 
	 * Игровая логика. 
	 * -------------------------------------------------------------------------------------
	 * Создаем объект Игра.
	 * 
	 * Игра.Вывести правила игры в крестики - нолики на поле 3*3 из 9 клеток
	 * Игра.Предложить сыграть.
	 * 
	 * Если получено согласие, то
	 * 		Игра.Определить пару игроков
	 * 		Игра.Знакомство и записать имена игроков
	 * 		Игра.Предложить выбрать фигуры и записать фигуры игроков
	 * 		 
	 * 		Создать объект Поле
	 * 		For (i = 0, 9) Игра.Поле.Создать объект Клетка (i) EndFor
	 * 		Считаем число ходов j = 9
	 *		Поле.Отрисовать графику пустого поля.
	 * 
	 * 		Если выбрана пара игроков Человек-Компьютер, То 
	 * 			
	 * 			Создать один объект Игрок-Компьютер;
	 * 		
	 * 			Пока (Поле.Число заполненных Х линий поля < 1) и (Поле.Число заполненных О линий поля < 1) и (j > 0) Выполнять
	 * 				
	 * 				Игрок-Компьютер.Рассчитать Ход
	 * 				Игрок-Компьютер.Передать Ход в Клетку
	 * 				Число ходов j = j-1
	 *
	 * 				Поле.Отрисовать графику хода
	 *				Поле.Ожидать ввода хода Игрока-Человека.
	 * 				Поле.Считать X координаты хода		
	 * 				Поле.Считать Y координаты хода
	 *				Число ходов j = j-1
	 *				Поле.Отрисовать графику хода
	 *
	 * 			Цикл Пока
	 * 			
	 * 			Игра.Определить и вывести Имя Победителя
	 * 			Выход
	 * 		
	 * 		Если выбрана пара игроков Компьютер-Компьютер, То 
	 * 
	 * 			Создать объект Игрок-Компьютер1;
	 * 			Создать объект Игрок-Компьютер2;
	 * 
	 * 			Пока (Поле.Число заполненных Х линий поля < 1) и (Поле.Число заполненных О линий поля < 1) и (j > 0) Выполнять
	 * 		
	 * 				Игрок-Компьютер1.Рассчитать Ход
	 * 				Игрок-Компьютер1.Передать Ход в Клетку		
	 * 				Поле.Отрисовать графику хода
	 * 				Число ходов j = j-1
	 *				
	 * 				Игрок-Компьютер2.Рассчитать Ход
	 * 				Игрок-Компьютер2.Передать Ход в Клетку		
	 * 				Поле.Отрисовать графику хода
	 * 				Число ходов j = j-1
	 * 
	 * 			Цикл Пока
	 * 			
	 * 			Игра.Определить и вывести Имя Победителя
	 * 			
	 * 		Если выбрана пара игроков Человек-Человек, То 
	 * 
	 * 			Пока (Поле.Число заполненных Х линий поля < 1) и (Поле.Число заполненных О линий поля < 1) и (j > 0) Выполнять
	 * 		
	 * 				Поле.Ожидать ввода хода Игрока-Человека1.
	 * 				Поле.Считать X координаты хода		
	 * 				Поле.Считать Y координаты хода
	 * 				Поле.Отрисовать графику хода
	 * 				Число ходов j = j-1
	 *				Поле.Ожидать ввода хода Игрока-Человека1.
	 * 				Поле.Считать X координаты хода		
	 * 				Поле.Считать Y координаты хода
	 *				Поле.Отрисовать графику хода
	 * 				Число ходов j = j-1
	 *
	 * 			Цикл Пока
	 * 			
	 * 			Игра.Определить и вывести Имя Победителя
	 * 
	 * Нет 
	 * 		Выводим сообщение об отказе от игры. 
	 * 
	 * Завершение программы.
	 */
	public static void main(String[] args) {
		
		xoSpeaker xoVoice = new xoSpeaker();
		
		if (xoVoice.GameInvitation() == true) {
			xoGame xoParty = new xoGame();
			xoParty.GameStart(xoParty.DefineGamers());	
		}
		else {
			xoVoice.GameOver();
		}
	}
}
 