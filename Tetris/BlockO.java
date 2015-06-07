package Tetris;

import java.awt.Color;


/**Klasa BlockO dziedzicząca po TetrisBlock, reprezentuje 1 z 7 klocków występujących w grze
 * Wszystkie klasy opisujące typy klocków sa zasadniczo bliźniacze, rozróżnia je wartość parametrów konstruktora
 * Bloczek typu O na ekranie widoczny jest w pomarańczowym kolorze 
 * 
 */
public class BlockO extends TetrisBlock
{

	BlockO(double dW, double dH, double aa) 
	{
		super(0,1,3,4, dW, dH, aa, Color.ORANGE);
		
	}

}