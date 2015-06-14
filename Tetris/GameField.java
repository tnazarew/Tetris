package Tetris;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.io.ObjectOutputStream;

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
	private TetrisView t;
	
	
	
	public GameField(int[] data, ObjectOutputStream oos, TetrisView tv)
	{
		additionalWidth = 0;
		additionalHeight = 0;
		
        this.liczkloc=data[3];
        xkloc = new int[liczkloc];
        ykloc = new int[liczkloc];		
        int j =0; 
        for(int i = 0; i+5 < data.length; i+=2, j++)
        {
        	xkloc[j] = data[i+4];
        	ykloc[j] = data[i+5];
        }
        setFocusable(true);

        InputMap im = getInputMap(WHEN_FOCUSED);
        ActionMap am = getActionMap();
        t = tv;
        

        
        pF = new PlayingField(this,this.getWidth() - this.additionalWidth, this.getHeight() - this.additionalHeight, this.additionalWidth/2, this.additionalHeight/2, xkloc, ykloc, data[2], oos);
       
        im.put(KeyStroke.getKeyStroke(KeyEvent.VK_LEFT, 0), MOVE_LEFT);
        am.put(MOVE_LEFT, new MoveLeftAction(pF));
        im.put(KeyStroke.getKeyStroke(KeyEvent.VK_RIGHT, 0), MOVE_RIGHT);
        am.put(MOVE_RIGHT, new MoveRightAction(pF));
        im.put(KeyStroke.getKeyStroke(KeyEvent.VK_UP, 0), MOVE_UP);
        am.put(MOVE_UP, new MoveUpAction(pF));
        im.put(KeyStroke.getKeyStroke(KeyEvent.VK_DOWN, 0), MOVE_DOWN);
        am.put(MOVE_DOWN, new MoveDownAction(pF));
        
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
	public void setScore(int i)
	{
		t.setScore(i);
	}
	public void setNewGame(int [] data, ObjectOutputStream oos)
	{
		pF.restart(data);
	}

}
