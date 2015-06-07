package Tetris;

import java.awt.Color;


/**Klasa BlockS dziedzicząca po TetrisBlock, reprezentuje 1 z 7 klocków występujących w grze
 * Wszystkie klasy opisujące typy klocków sa zasadniczo bliźniacze, rozróżnia je wartość parametrów konstruktora
 * Bloczek typu S na ekranie widoczny jest w kolorze cyjanowym (morski)
 * 
 */
public class BlockS extends TetrisBlock
{

	BlockS(double dW, double dH,
			double aa) 
	{
		super(1,2,3,4, dW, dH, aa, Color.CYAN);
		
	}

}