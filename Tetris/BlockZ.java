package Tetris;

import java.awt.Color;


/**Klasa BlockZ dziedzicząca po TetrisBlock, reprezentuje 1 z 7 klocków występujących w grze
 * Wszystkie klasy opisujące typy klocków sa zasadniczo bliźniacze, rozróżnia je wartość parametrów konstruktora
 * Bloczek typu Z na ekranie widoczny jest w niebieskim kolorze
 * 
 */

public class BlockZ extends TetrisBlock
{

	BlockZ(double dW, double dH,
			double aa) 
	{
		super(0,1,4,5, dW, dH, aa, Color.BLUE);
		
	}

}