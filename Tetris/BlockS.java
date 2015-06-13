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
		super(1,2,3,4, dW, dH, aa, Color.CYAN,false);
		
	}
	public void turn()
	{
		switch(rotation)
		{
		case down:
			nums[0] = 0;
			nums[1] = 3;
			nums[2] = 4;
			nums[3] = 7;
			rotation = state.right;
			break;
		case up:
			nums[0] = 1;
			nums[1] = 4;
			nums[2] = 5;
			nums[3] = 8;
			rotation = state.left;
			break;
		case left:
			nums[0] = 1;
			nums[1] = 2;
			nums[2] = 3;
			nums[3] = 4;
			rotation = state.down;
			break;
		case right:
			nums[0] = 3;
			nums[1] = 4;
			nums[2] = 7;
			nums[3] = 8;
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