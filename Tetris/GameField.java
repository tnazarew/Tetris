package Tetris;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.JPanel;
import javax.swing.KeyStroke;

/**Klasa GameField (dziedzicząca po JPanel) odpowiada za opis okna gry
 * W klasie zawarte są metody rysujące zarówno samo okno jak i kilka przykładowych klocków
 * Metoda paintComponent rysuje okno o żądanych wymiarach, z zachowaniem proporcji szerokości do wysokości
 */
@SuppressWarnings("serial")
public class GameField extends JPanel
{	
    /**additionalWidth pomocniczy parametr służący do określania położenia klockówrysowanych przez poszczególne metody draw jak i parametr 'czuwający'nad zachowaniem proporcji planszy (szerokość)
     * additionalHeight to odpowiednik parametru additionalWidth z tym że regulujący wyskość
     */
	private double additionalWidth;
	private double additionalHeight;
	public int xkloc[];
    public int ykloc[];
    public int liczkloc;
    private PlayingField pF;
	//private MoveKeyListener m;
	private static final String MOVE_UP = "move up";
    private static final String MOVE_DOWN = "move down";
    private static final String  MOVE_LEFT = "move left";
    private static final String  MOVE_RIGHT	= "move right";
	
	
	
	
	public GameField(Configuration conf)
	{
		additionalWidth = 0;
		additionalHeight = 0;
		
        this.liczkloc=conf.liczba_kloc;
        xkloc = new int[liczkloc];
        ykloc = new int[liczkloc];		

        System.arraycopy(conf.x_kloc, 0, this.xkloc, 0, this.liczkloc);
        System.arraycopy(conf.y_kloc, 0, this.ykloc, 0, this.liczkloc);
        setFocusable(true);

        InputMap im = getInputMap(WHEN_FOCUSED);
        ActionMap am = getActionMap();
        
        

        
        pF = new PlayingField(this,this.getWidth() - this.additionalWidth, this.getHeight() - this.additionalHeight, this.additionalWidth/2, this.additionalHeight/2, xkloc, ykloc);
        //m = new MoveKeyListener();
		//m.setPlayingField(pF);
		//this.addKeyListener(m);
       
        im.put(KeyStroke.getKeyStroke(KeyEvent.VK_LEFT, 0), MOVE_LEFT);
        am.put(MOVE_LEFT, new MoveLeftAction(pF));
        im.put(KeyStroke.getKeyStroke(KeyEvent.VK_RIGHT, 0), MOVE_RIGHT);
        am.put(MOVE_RIGHT, new MoveRightAction(pF));
        im.put(KeyStroke.getKeyStroke(KeyEvent.VK_UP, 0), MOVE_UP);
        am.put(MOVE_UP, new MoveUpAction(pF));
        im.put(KeyStroke.getKeyStroke(KeyEvent.VK_DOWN, 0), MOVE_DOWN);
        am.put(MOVE_DOWN, new MoveDownAction(pF));
        
        /* xkloc=new int [this.liczkloc];
        ykloc=new int [this.liczkloc];
        
        for(int i=0;i<liczkloc;i++)
        {
            xkloc=x_kloc;
        }*/

       // for(int i:ykloc)
        //{System.out.println(i);}
        /**Metoda rysująca komponent oraz kilka przykładowych klocków
         * g jest to obiekt klasy Graphics2D
         * 
         * 
         */
	}
	protected class MoveLeftAction extends AbstractAction
	{
		protected PlayingField p;
		public MoveLeftAction(PlayingField pf)
		{
			p = pf;
		}
		
		@Override
		public void actionPerformed(ActionEvent e)
		{
			p.moveSide(false);
			System.out.println("LEWO");
		}
		
		
	}
	
	protected class MoveRightAction extends AbstractAction
	{
		protected PlayingField p;
		public MoveRightAction(PlayingField pf)
		{
			p = pf;
		}
		
		@Override
		public void actionPerformed(ActionEvent e)
		{
			p.moveSide(true);
			System.out.println("PRAWO");
		}
		
		
	}
	protected class MoveUpAction extends AbstractAction
	{
		protected PlayingField p;
		public MoveUpAction(PlayingField pf)
		{
			p = pf;
		}
		
		@Override
		public void actionPerformed(ActionEvent e)
		{
			p.turn();
			System.out.println("GORA");
		}
		
		
	}
	
	protected class MoveDownAction extends AbstractAction
	{
		protected PlayingField p;
		public MoveDownAction(PlayingField pf)
		{
			p = pf;
		}
		
		@Override
		public void actionPerformed(ActionEvent e)
		{
			p.fastFall();
			System.out.println("DOL");
		}
		
		
	}
	
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		if(this.matchProportions())
		{

			// aktualizuje wymiary planszy gry
			pF.update(this.getWidth() - this.additionalWidth, this.getHeight() - this.additionalHeight, this.additionalWidth/2, this.additionalHeight/2);
			
		}
		
		pF.draw(g2);
		/*g2.draw(new Rectangle2D.Double(additionalWidth/2,additionalHeight/2, this.getWidth()- additionalWidth , this.getHeight()-additionalHeight));
		TetrisBlock t1 = new BlockI(g2, additionalWidth/2 + xkloc[0]*(this.getWidth()- additionalWidth)/10,additionalHeight/2 + ykloc[0]*(this.getHeight()-additionalHeight)/20, (this.getHeight()-additionalHeight)/20);
		t1.draw();
		
		TetrisBlock t2 = new BlockJ(g2, additionalWidth/2 + xkloc[1]*(this.getWidth()- additionalWidth)/10,additionalHeight/2 + ykloc[1]*(this.getHeight()-additionalHeight)/20, (this.getHeight()-additionalHeight)/20);
		t2.draw();
		
		/*TetrisBlock t3 = new BlockO(g2, additionalWidth/2 + 2*(this.getWidth()- additionalWidth)/10,additionalHeight/2 + 6*(this.getHeight()-additionalHeight)/20, (this.getHeight()-additionalHeight)/20);
		t3.draw();
		
		TetrisBlock t4 = new BlockS(g2, additionalWidth/2 + 3*(this.getWidth()- additionalWidth)/10,additionalHeight/2 + 18*(this.getHeight()-additionalHeight)/20, (this.getHeight()-additionalHeight)/20);
		t4.draw();
		
		TetrisBlock t5 = new BlockZ(g2, additionalWidth/2 + 7*(this.getWidth()- additionalWidth)/10,additionalHeight/2 + 13*(this.getHeight()-additionalHeight)/20, (this.getHeight()-additionalHeight)/20);
		t5.draw();
		
		TetrisBlock t6 = new BlockL(g2, additionalWidth/2 + 8*(this.getWidth()- additionalWidth)/10,additionalHeight/2 + 17*(this.getHeight()-additionalHeight)/20, (this.getHeight()-additionalHeight)/20);
		t6.draw();
		
		TetrisBlock t7 = new BlockT(g2, additionalWidth/2 + 7*(this.getWidth()- additionalWidth)/10,additionalHeight/2 + 5*(this.getHeight()-additionalHeight)/20, (this.getHeight()-additionalHeight)/20);
		t7.draw();*/
	}
	
	private boolean matchProportions()
	{
		double aH = this.additionalHeight;
		double aW = this.additionalWidth;
		if (this.getWidth() * 2  > this.getHeight())
		{
			additionalWidth = (this.getWidth() * 2 - this.getHeight())/2;
			additionalHeight = 0;
		}
		else
		{
			additionalWidth = 0;
			additionalHeight = this.getHeight() - this.getWidth() * 2;
		}
		
		if(aH != this.additionalHeight || aW != this.additionalWidth)
			return true;
		else return false;
		
	
	}
	public void startStopAnimation(boolean b)
	{
		pF.startStopAnimation(b);
	}

}
