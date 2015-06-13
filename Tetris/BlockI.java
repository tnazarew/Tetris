package Tetris;

import java.awt.Color;

/**Klasa BlockI dziedzicząca po TetrisBlock, reprezentuje 1 z 7 klocków występujących w grze
 * Wszystkie klasy opisujące typy klocków sa zasadniczo bliźniacze, rozróżnia je wartość parametrów konstruktora
 * Bloczek typu I na ekranie widoczny jest w czerwonym kolorze
 * 
 */
public class BlockI extends TetrisBlock
{
	BlockI( double dW, double dH,
			double aa) 
	{
		super(0,3,6,9, dW, dH, aa, Color.RED, true);
		
	}
	
	
	public void turn()
	{
		
	}

}