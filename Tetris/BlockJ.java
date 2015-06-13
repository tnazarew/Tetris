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
		super(1,4,6,7, dW, dH, aa, Color.GREEN, false);
		
	}
	public void turn()
	{
		switch(rotation)
		{
		case down:
			nums[0] = 3;
			nums[1] = 6;
			nums[2] = 7;
			nums[3] = 8;
			rotation = state.right;
			break;
		case up:
			nums[0] = 3;
			nums[1] = 4;
			nums[2] = 5;
			nums[3] = 8;
			rotation = state.left;
			break;
		case left:
			nums[0] = 1;
			nums[1] = 4;
			nums[2] = 6;
			nums[3] = 7;
			rotation = state.down;
			break;
		case right:
			nums[0] = 0;
			nums[1] = 1;
			nums[2] = 4;
			nums[3] = 7;
			rotation = state.up;
			break;
		}
		for(int i = 0; i < 4; i++)
		{
			sq[i].update(x + a*(nums[i]%3),y + a*(nums[i]/3),a);
		}
		keepInBounds();
	}
	
}