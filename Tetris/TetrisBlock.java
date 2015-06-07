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

public class TetrisBlock 
{

	double anchorX;
	double anchorY;
	boolean visible;
	private double x;
	private double y;
	private double a;
	private Paint color;
	private int nums[]; /// 
	//private Rectangle2D rec[];
	private TetrisSquare[] sq;
	TetrisBlock(int fi, int s, int t, int fo, double xx, double yy, double aa, Paint c)
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
			sq[i].update(x + a*(nums[i]%3),y + a*(nums[i]/3),a);
		}
	}
	
	public void moveDown()
	{
		y++;
		for(int i = 0; i < 4; i++)
		{
			sq[i].update(x + a*(nums[i]%3),y + a*(nums[i]/3) ,a);
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
		return d;
	}
	
	public Paint getColor()
	{
		return color;
	}
}