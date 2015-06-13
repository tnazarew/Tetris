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
		super(0,1,2,4, dW, dH, aa, Color.YELLOW,false);
		
	}
	public void turn()
	{
		switch(rotation)
		{
		case down:
			nums[0] = 0;
			nums[1] = 3;
			nums[2] = 6;
			nums[3] = 4;
			rotation = state.right;
			break;
		case up:
			nums[0] = 2;
			nums[1] = 5;
			nums[2] = 8;
			nums[3] = 4;
			rotation = state.left;
			break;
		case left:
			nums[0] = 0;
			nums[1] = 1;
			nums[2] = 2;
			nums[3] = 4;
			rotation = state.down;
			break;
		case right:
			nums[0] = 6;
			nums[1] = 7;
			nums[2] = 8;
			nums[3] = 4;
			rotation = state.down;
			break;
		}
		for(int i = 0; i < 4; i++)
		{
			sq[i].update(x + a*(nums[i]%3),y + a*(nums[i]/3),a);
		}
		keepInBounds();
	}
}