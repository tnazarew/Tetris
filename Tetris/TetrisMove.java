package Tetris;

public class TetrisMove extends Thread
{
	private PlayingField p;
	private double speed;
	private double height;
	TetrisMove(PlayingField pf)
	{
		p = pf;
	}
	@Override
	public void run()
	{
		while(true)
		{
			p.move();
			try {
				sleep(20);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public void setSpeed(double s)
	{
		speed = s;
	}
	
	public void setHeight(double h)
	{
		height = h;
	}
}

