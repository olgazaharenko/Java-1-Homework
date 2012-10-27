package OZA_JAVA1_Homework;

import java.util.Scanner;

public class GameXOField {

	/*
	 * Объект Поле
	 * - отрисовывает графику поля (пустого или с ходом)
	 * - считывает ходы Игрока (неважно какого)
	 * - хранит и возвращает информацию о максимальном количестве Клеток в поле
	 * - хранит и возвращает информацию о доступном количестве пустых Клеток после каждого хода
	 * - пересчитывает доступное количество пустых Клеток после каждого хода
	 * - хранит и возвращает информацию о количестве заполненных Х линиях поля
	 * - хранит и возвращает информацию о количестве заполненных О линиях поля
	 */
	
	public int maxBoxesInTheField;
	public int emptyBoxesInTheField;
	public int linesX;
	public int linesO;
	
	public int returnMaxBoxesInTheField (){
		return maxBoxesInTheField;
	}

	public int returnEmptyBoxesInTheField (){
		return emptyBoxesInTheField;
	}
	
	public int returnLinesX (){
		return linesX;
	}
	
	public int returnLinesO (){
		return linesO;
	}
	
	
	
}
