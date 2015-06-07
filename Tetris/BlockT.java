package Tetris;

import java.awt.Color;


/**Klasa BlockT dziedzicząca po TetrisBlock, reprezentuje 1 z 7 klocków występujących w grze
 * Wszystkie klasy opisujące typy klocków sa zasadniczo bliźniacze, rozróżnia je wartość parametrów konstruktora
 * Bloczek typu T na ekranie widoczny jest w żółtym kolorze
 * 
 */
public class BlockT extends TetrisBlock
{
	BlockT(double dW, double dH,
			double aa) 
	{
		super(0,1,2,4, dW, dH, aa, Color.YELLOW);
		
	}
	
}