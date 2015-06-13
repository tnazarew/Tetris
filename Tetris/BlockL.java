package Tetris;

import java.awt.Color;

/**Klasa BlockL dziedzicząca po TetrisBlock, reprezentuje 1 z 7 klocków występujących w grze
 * Wszystkie klasy opisujące typy klocków sa zasadniczo bliźniacze, rozróżnia je wartość parametrów konstruktora
 * Bloczek typu L na ekranie widoczny jest w różowym kolorze
 * 
 */
public class BlockL extends TetrisBlock
{

	BlockL(double dW, double dH, double aa) 
	{
		super(1,4,7,8, dW, dH, aa, Color.PINK, false);
		
	}

	public void turn()
	{
		switch(rotation)
		{
		case down:
			nums[0] = 6;
			nums[1] = 7;
			nums[2] = 8;
			nums[3] = 5;
			rotation = state.right;
			break;
		case up:
			nums[0] = 3;
			nums[1] = 4;
			nums[2] = 5;
			nums[3] = 6;
			rotation = state.left;
			break;
		case left:
			nums[0] = 1;
			nums[1] = 4;
			nums[2] = 7;
			nums[3] = 8;
			rotation = state.down;
			break;
		case right:
			nums[0] = 1;
			nums[1] = 2;
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