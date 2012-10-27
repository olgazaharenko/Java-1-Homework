package OZA_JAVA1_Homework;

public class GameXOBox {

	/*
	 * Объект Клетка
	 * - хранит и возвращает адрес клетки (в условных координатах сетки 3*3)
	 * - хранит и возвращает состояние (свободна, занята)
	 * - хранит и возвращает содержимое (Х, О или пусто)
	 * - хранит и возвращает число значимых для принятия решения о ходе соседей первого круга (3 для угловых, либо 5 для серединок, либо 8 для центра)
	 * - хранит и возвращает число значимых для принятия решения о ходе соседей второго круга (3 для угловых, либо 1 для серединок, либо 0 для центра)
	 */

	public String BoxAdress[][] = new String [3][3];
	
	public boolean BoxState;
	public String BoxContent;
	
	public int circleFirst[] = new int [] {3,5,8};
	public int circleSecond[] = new int [] {3,1,0};

	public boolean returnBoxState (){
		return BoxState;
	}

	public String returnContent (){
		return BoxContent;
	}
	
	public int returnCircleFirst (int i) {
		return circleFirst[i];
	}

	public int returnCircleSecond (int i) {
		return circleSecond[i];
	}

	public String returnBoxAddress (int i, int j) {
		for (i = 0; i<=2; i++) {
			for (j = 0; j<=2; j++) {
				BoxAdress [i][j] = i + "," + j;
			}
		}
		return BoxAdress [i][j];
	}
}