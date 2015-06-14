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
		super(0,3,6,9, dW, dH, aa, Color.RED, false);
		
	}
	
	
	public void turn()
	{
	
		switch(rotation)
		{
		case down:
			nums[0] = 3;
			nums[1] = 4;
			nums[2] = 5;
			nums[3] = 5;
			this.takenOutside = true;
			rotation = state.right;
			break;
		case right:
			nums[0] = 1;
			nums[1] = 4;
			nums[2] = 7;
			nums[3] = 10;
			this.takenOutside = false;
			rotation = state.down;
			break;
		default:
				
		}
		for(int i = 0; i < 4; i++)
		{
			if(takenOutside && i == 3)
				sq[i].update(x + a*((nums[i]%3) + 1),y + a*(nums[i]/3),a);
			else
				sq[i].update(x + a*(nums[i]%3),y + a*(nums[i]/3),a);
		}
		keepInBounds();
	}
	

}