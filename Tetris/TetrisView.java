package Tetris;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JFrame;

public class TetrisView extends JFrame
{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private GameField g;
	private SecondPanel sp;
	public TetrisView()
	{
		/**Funkcja tworzy nowe okno gry tetris, w podanej za pomocą setBounds odległości w pikselach od górnego lewego rogu ekranu oraz podaje jego defaultowe rozmiary
         * Okno jest skalowalne, możliwe jest zamknięcie go standardowym krzyżykiem
         * W oknie zawarte jest także proste, rozwijane menu wyboru poziomu gry
         * Do rozkładu komponentów wewnątrz okna użyty został GridBagLayout
         */
		setBounds(100, 100, 800, 800);
		setResizable(true);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		getContentPane().setLayout(new GridBagLayout());
		setJMenuBar(new TetrisMenu(this));
        Configuration conf = new Configuration();
        
        /**Opis rozkładu komponentów: głównej planszy gry oraz panelu bocznego wewnątrz okna
         * Parametry gridx oraz gridy określają położenie lewego górnego rogu komponentu
         * Parametry weightx i weighty okreslają wagę komponentu wewnątrz okna
         * Parametry gridwidth oraz gridheight mówią o ilości wierszy i kolumn danego komponentu
         */
                            
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.BOTH;
		
		c.gridx = 0;
		c.gridy = 0;
		c.weightx = 6.0;
		c.weighty = 1;
		c.gridwidth = 5;
                        c.gridheight = 1;
		g = new GameField(conf);
                    this.getContentPane().add(g, c);
		sp = new SecondPanel(this);
		c.fill = GridBagConstraints.BOTH;
		
		c.gridx = 6;
		c.gridy = 0;
		c.weightx = 1.0;
		c.weighty = 1;
		
		c.gridwidth = 1;
                        c.gridheight = 2;

		getContentPane().add(sp, c);
		
	}
	
	public void startStopAnimation(boolean b)
	{
		g.startStopAnimation(b);
	}
	
}
