package Tetris;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.util.Random;

public class PlayingField 
{
	private int highestPoint[];
	private GameField gF;
	private TetrisMove tm;

	private boolean animationOn;
	private double pushX;
	private double pushY;
	private double width;
	private double height;
	public int xkloc[];
    public int ykloc[];
	TetrisBlock tB;
	TetrisSquare tS[][];
	
	PlayingField(GameField g,double pX, double pY, double w, double h, int[] xk, int[] yk)
	{
		gF = g;
		animationOn = false;
		pushX = pX;
		pushY = pY;
		width = w;
		height = h;
		
		tB = new BlockO(pushX, pushY, width/10+1);
		tB.setVisible(true);
		this.highestPoint = new int[10];
		tS = new TetrisSquare[10][20];
		for(int i = 0 ; i < 10 ; i++)
		{
			this.highestPoint[i] = 0;
			for(int j = 0; j < 20 ; j++)
			{
				tS[i][j] = new TetrisSquare(Color.DARK_GRAY, pushX + ((width * i)/10), pushY + ((height * j) / 20), height/20);
			}
		}
		for(int i = 0 ; i < yk.length && i < xk.length; i++)
		{
			tS[xk[i]-1][yk[i]-1].setVisible(true);
			highestPoint[xk[i]-1] = 21 - yk[i];
		}
		
		tm = new TetrisMove(this);
		tm.start();
	}
	
	public void draw(Graphics2D g)
	{
		g.draw(new Rectangle2D.Double(pushX,pushY, width , height));
		tB.draw(g);
		for(TetrisSquare ts[] : tS)	
		{
			for(TetrisSquare t : ts)
			{
				if(t.isVisible())
				{
					t.draw(g);
				}
			}
		}
	    
	}
	
	public void update(double w, double h, double pX, double pY)
	{
		width = w;
		height = h; 
		
		pushX = pX;
		pushY = pY;
		tB.update(pushX, pushY, w/10);
		
		for(int i = 0 ; i < 10; i++)
		{
			for (int j = 0 ; j < 20 ; j++)
			{
				tS[i][j].update(pushX + ((width * i)/10), pushY + ((height * j) / 20), height/20);
			}
		}
	}
	public void nextBlock(int i)
	{
		switch(i)
		{
		case 1:
			tB = new BlockI(pushX, pushY, width/10);
			break;
		case 2:
			tB = new BlockJ(pushX, pushY, width/10);
			break;
		case 3:
			tB = new BlockL(pushX, pushY, width/10);
			break;
		case 4:
			tB = new BlockO(pushX, pushY, width/10);
			break;
		case 5:
			tB = new BlockS(pushX, pushY, width/10);
			break;
		case 6:
			tB = new BlockT(pushX, pushY, width/10);
			break;
		case 7:
			tB = new BlockZ(pushX, pushY, width/10);
			break;
		
		}
	
	}
	public void move()
	{
		if(animationOn)
		{	
			tB.moveDown();
			//////////////
		
			if(checkCollision(tB.getCoordinates()))
			{
				Random r = new Random();
				nextBlock(r.nextInt(7)+1);
			}
			VanishRowsIfFull();
			/////////////
			gF.repaint();

		}
	}
	
	public void startStopAnimation(boolean b)
	{
		this.animationOn = b;
	}
	
	private boolean checkCollision(double[] d)
	{
		
		//double startOfPreviousBlock;
		//double endOfNextBlock; 
		for(int i = 0 ; i < 10 ; i ++)
		{
			for(int j = 0 ; j < 4; j++)
			{
				//startOfPreviousBlock = pushX + (i-1)*width/10 + 1;
				//endOfNextBlock = pushX + (i+1)*width/10 - 1;
				//if(d[2*j] > startOfPreviousBlock && d[2*j] < endOfNextBlock)
				if(d[2*j]  == pushX + i*width/10)
				{
					if(d[2*j + 1] >= pushY + ((19-this.highestPoint[i]))*height/20)
					{
						unmobilizeBlock(d, pushX +(i-1)*width/10 - d[2*j]);
						return true;
					}
				}
			}
			
		}
		return false;
	}

	private void unmobilizeBlock(double[] d, double r)
	{
		int x;
		int y;
		for( int i = 0 ; i < 8; i+=2)
		{
			x = (int)( ( ( d[i]  - pushX + 1 )/width ) * 10 );
			y = (int)( ( ( d[i+1] - pushY)/height )*20 );
			tS[x][y].setVisible(true);
			tS[x][y].setColor(tB.getColor());
			this.highestPoint[x] =(20 - y > this.highestPoint[x]) ? 20 - y :  this.highestPoint[x];
			
		}
		
	}
	//Funkcja sprawdzająca czy zadany wiersz jest pełny
	public boolean checkIfRowFull(int i)
	{
		//TODO
		
		return false;
	}
	
	public void VanishRowsIfFull()
	{
		for(int i = 0 ; i < 20 ; i++)
		{
			if(checkIfRowFull(i))
			{
				makeRowDissapear(i);
			}
		}
	}
	
	public void makeRowDissapear(int i)
	{
		//TODO
		
	}
	
	public void moveSide(boolean rightLeft)
	{
		tB.moveSide(rightLeft);
	}
	
	public void turn()
	{
		tB.turn();
	}
}
