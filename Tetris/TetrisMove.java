package Tetris;

public class TetrisMove extends Thread
{
	PlayingField p;
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
}
