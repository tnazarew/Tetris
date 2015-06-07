package Tetris;

import java.awt.Color;


/**Klasa BlockJ dziedzicząca po TetrisBlock, reprezentuje 1 z 7 klocków występujących w grze
 * Wszystkie klasy opisujące typy klocków sa zasadniczo bliźniacze, rozróżnia je wartość parametrów konstruktora
 * Bloczek typu J na ekranie widoczny jest w zielonym kolorze
 * 
 */
public class BlockJ extends TetrisBlock
{

	BlockJ(double dW, double dH,
			double aa) 
	{
		super(1,4,6,7, dW, dH, aa, Color.GREEN);
		
	}
	
}