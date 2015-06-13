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
		super(0,1,4,5, dW, dH, aa, Color.BLUE, false);
		
	}
	public void turn()
	{
		switch(rotation)
		{
		case down:
			nums[0] = 1;
			nums[1] = 4;
			nums[2] = 6;
			nums[3] = 3;
			rotation = state.right;
			break;
		case up:
			nums[0] = 2;
			nums[1] = 4;
			nums[2] = 5;
			nums[3] = 7;
			rotation = state.left;
			break;
		case left:
			nums[0] = 0;
			nums[1] = 1;
			nums[2] = 4;
			nums[3] = 5;
			rotation = state.down;
			break;
		case right:
			nums[0] = 4;
			nums[1] = 5;
			nums[2] = 6;
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