package Tetris;

public class TetrisMove extends Thread
{
	private PlayingField p;
	TetrisMove(PlayingField pf)
	{
		p = pf;
	}
	@Override
	public void run()
	{
		try {
			sleep(1000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		while(true)
		{
			p.move(1.0);
			try {
				
				sleep((long) ((20000/(p.getLevel()*p.getHeight()))));
				
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}

