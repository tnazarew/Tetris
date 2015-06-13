package Tetris;

import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.geom.Rectangle2D;

public class TetrisSquare {
	private Paint color;
	private boolean visible;
	private Rectangle2D r;
	private double x;
	private double y;
	private double a;
	
	public TetrisSquare(Paint color, double xx , double yy, double aa)
	{
		this.color = color;
		this.visible = false ;
		this.a = aa;
		this.x = xx;
		this.y = yy;
		this.r = new Rectangle2D.Double(x, y, a,a);
	}

			
	
	void setVisible(boolean v)
	{
		this.visible = v;
	}
	
	
	boolean isVisible()
	{
		return visible;
	}
	
	public void draw(Graphics2D g)
	{
		if(visible)
		{
			g.setPaint(color);
			g.fill(r);
			g.draw(r);
		}
	}
	
	public void update(double xx, double yy, double aa)
	{
		this.y = yy;
		this.x = xx;
		this.a = aa;
		r.setRect(x, y, a, a);
	}
	
	public void setColor(Paint c)
	{
		color = c;
	}
	public double getX()
	{
		return x;
	}
	
	public void push(double a, boolean rL)
	{
		a = (rL) ? a : -a;
		x += a;
		r.setRect(x, y, a,a);
	}
	
}
