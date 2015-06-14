package Tetris;

import java.awt.Graphics2D;
import java.awt.Paint;


/**Klasa TetrisBlock jest klasą, której obiekty są poszczególnymi klockami Tetrisa
 * g jest to obiekt klasy Graphics2D
 * defaultWidth parametr określający szerokość planszy na jakiej znajduje się klocek w momencie pojawienia
 * defaultHeight parametr określający wysokość planszy na jakiej znajduje się klocek w momencie pojawienia
 * a parametr mówiący o długości boku kwadratu, w którym zawiera się klocek
 * nums tablica zawierająca parametry fi, s, t, fo
 * rec[] to obiekt klasy Rectangle2D określa ilość prostokątów składających się na klocek
 * Klasa TetrisBlock jest szablonem wedle którego powstają klocki rysowane na planszy
 * Parametry fi, s, t, fo są informacją, które małe kwadraty (ponumerowane od 0-11) wewnątrz dużego kwadratu 3x3 należy zakolorować aby otrzymac dany klocek
 * W klasie znajdują się dwie pętle for po zmiennej iteracyjnej i (i rośnie od 0 do 3) które wywołują 4 razy metody odpowiedzialne za rysowanie klocka
 */

public abstract class TetrisBlock 
{

	double anchorX;
	double anchorY;
	boolean visible;
	protected boolean takenOutside;
	protected double x;
	protected double y;
	protected double a;
	private Paint color;
	protected int nums[]; /// 
	protected enum state {down, right, left, up} 
	protected state rotation;
	//private Rectangle2D rec[];
	protected TetrisSquare[] sq;
	TetrisBlock(int fi, int s, int t, int fo, double xx, double yy, double aa, Paint c, boolean to)
	{
		color = c;
		visible= true;
		a = aa;
		anchorX = xx;
		anchorY = yy;
		x = xx;
		y = yy;
		nums = new int[4];
		nums[0] = fi;
		nums[1] = s;
		nums[2] = t;
		nums[3] = fo;
		sq = new TetrisSquare[4];
		takenOutside = to;
		rotation = state.down;
		for (int i = 0; i < 4; i ++)
		{
			sq[i] = new TetrisSquare(color, x + a*(nums[i]%3),y + a*(nums[i]/3),a);
			sq[i].setVisible(visible);
		}
	}
        
        /**Metoda rysująca dany typ klocka
         * Parametr koloru w metodzie setPaint jest przekazywany w poszczególnych konstruktorach jako c
         * 
         */
	public void draw(Graphics2D g)
	{
		for (int i = 0 ; i < 4; i++)
		{
			sq[i].draw(g);
		}
	}
	
	// reaguje na zmiane wielkosci planszy
	public void update(double xx, double yy, double aa)
	{
		//System.out.println("anchorX" + anchorX + " anchorY " + anchorY + " x " + x + " y " + y + " a " + a + " aa " + aa);
		x = xx + (x - anchorX)*(aa/a);
		y = yy + (y - anchorY)*(aa/a); 
		anchorX = xx;
		anchorY = yy;
		a = aa;
		for(int i = 0; i < 4; i++)
		{
			if(takenOutside && i == 3)
				sq[i].update(x + a*((nums[i]%3) + 1),y + a*(nums[i]/3),a);
			else
				sq[i].update(x + a*(nums[i]%3),y + a*(nums[i]/3),a);
		}
	}

	
	public void moveDown(double yy)
	{
		y+=yy;
		for(int i = 0; i < 4; i++)
		{
			if(takenOutside && i == 3)
				sq[i].update(x + a*((nums[i]%3) + 1),y + a*(nums[i]/3),a);
			else
				sq[i].update(x + a*(nums[i]%3),y + a*(nums[i]/3),a);
		}
	}
	
	public void setVisible(boolean v)
	{
		for(TetrisSquare t : sq)
		{
			t.setVisible(v);
		}
	}
	
	public double[] getCoordinates()
	{
		double[] d = new double[8];
		for(int i = 0; i < 4; i++)
		{
			d[2*i] = x + a*(nums[i]%3);
			d[2*i+1] = y + a*(nums[i]/3);	
		}
		if(takenOutside)
			d[6] += a;
		return d;
	}
	
	public Paint getColor()
	{
		return color;
	}
	
	public void setTakeOutside(boolean b)
	{
		this.takenOutside = b;
	}
	
	public abstract void turn();
	
	public void keepInBounds()
	{
		while(maxX() > anchorX + 9*a)
			moveSide(false);
		while(minX() < anchorX)
			moveSide(true);
	}
	
	public void moveSide(boolean rightLeft)
	{
		if(maxX() + a > anchorX + 9*a && rightLeft)
		{
			System.out.println(maxX());
			System.out.println(anchorX);
			System.out.println(a);
		}
		if((maxX() + a <= anchorX + 9*a && rightLeft) || (minX() - a >= anchorX && !rightLeft))
		{
			double aa = (rightLeft) ? a : -a;
			System.out.println(x);
			x+=aa;
			System.out.println(x);
			for(int i = 0; i < 4; i++)
			{
				if(takenOutside && i == 3)
					sq[i].update(x + a*((nums[i]%3) + 1),y + a*(nums[i]/3),a);
				else
					sq[i].update(x + a*(nums[i]%3),y + a*(nums[i]/3),a);
			}
		}
	}
	public double maxX()
	{
		double max = 0;
		double d[] = getCoordinates();
		for(int i = 0; i < d.length ; i+=2)
		{
			
			max = (max < d[i]) ? d[i] : max;
		}
		return max;
	}
	
	public double minX()
	{
		double min = 100000;
		double d[] = getCoordinates();
		for(int i = 0; i < d.length ; i+=2)
		{
			min = (min > d[i]) ? d[i] : min;
		}
		return min;
	}
	public void fastFall()
	{
		moveDown(a);

	}
	
	
}