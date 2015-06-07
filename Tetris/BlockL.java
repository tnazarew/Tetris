package Tetris;

import java.awt.Color;


/**Klasa BlockL dziedzicząca po TetrisBlock, reprezentuje 1 z 7 klocków występujących w grze
 * Wszystkie klasy opisujące typy klocków sa zasadniczo bliźniacze, rozróżnia je wartość parametrów konstruktora
 * Bloczek typu L na ekranie widoczny jest w różowym kolorze
 * 
 */
public class BlockL extends TetrisBlock
{

	BlockL( double dW, double dH, double aa) 
	{
		super(0,3,6,7, dW, dH, aa, Color.PINK);
		
	}

}