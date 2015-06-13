package Tetris;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
 
/**Klasa SecondPanel to klasa, której obiekt reprezentuje panel boczny z opcjami dla gracza
 * Za pomocą rozkładu GridBagLayout rozmieszczone zostały 4 główne elementy tego interfejsu: przyciski pauzy i końca gry oraz pola tekstowe informujące o punktach i aktualnym poziomie
 * Przyciski pauzy i wyjścia z gry obsługują zdarzenia (kliknięcie myszą) i wykonują odpowiednie czynności
 */
 
@SuppressWarnings("serial")
public class SecondPanel extends JPanel
{
	private JButton exit;
	private JButton bests;
	private JLabel punkty;
	private JLabel poziom;
	
	private PauseUnpause pup;
	private Wyjscie ex;
	public Integer nrpoz;
	public SecondPanel(JFrame jp, Configuration conf)
	{
		this.setLayout(new GridBagLayout());
		GridBagConstraints co = new GridBagConstraints();
		this.nrpoz=conf.nr_poziomu;
		
		bests = new JButton("Lista najlepszych");
		punkty = new JLabel("Zdobyłeś [] punktów", JLabel.CENTER);
		punkty.setForeground(new Color(0xffffdd));
		poziom = new JLabel("Grasz na poziomie "+nrpoz.toString() , JLabel.CENTER);
		poziom.setForeground(new Color(0xffffdd));
		exit = new JButton("Wyjście z gry");
		pup = new PauseUnpause();
		ex = new Wyjscie();
		pup.setPaused(false);
		//levchange.addActionListener(pup);
		
		exit.addActionListener(ex);
		
                /**Ponownie użyto rozkładu GridBagLayout, jego dokładny opis można znaleść w funkcji głównej programu
                 * 
                 * 
                 */
		co.fill = GridBagConstraints.HORIZONTAL;				
		co.gridx = 6;
		co.gridy = 0;
		co.weightx = 0.25;
		co.weighty = 1;
		co.gridwidth = 1;
                co.gridheight = 1;
		add(punkty, co );
		co.fill = GridBagConstraints.HORIZONTAL;				
		co.gridx = 6;
		co.gridy = 1;
		co.weightx = 0.25;
		co.weighty = 1;
		co.gridwidth = 1;
                co.gridheight = 1;		
		add(poziom,co);
		co.fill = GridBagConstraints.HORIZONTAL;				
		co.gridx = 6;
		co.gridy = 2;
		co.weightx = 1.0;
		co.weighty = 1;
		co.gridwidth = 1;
                co.gridheight = 1;
		add(bests,co);
		co.fill = GridBagConstraints.HORIZONTAL;				
		co.gridx = 6;
		co.gridy = 3;
		co.weightx = 1.0;
		co.weighty = 1;
		co.gridwidth = 1;
                co.gridheight = 1;
		add(exit,co);
		
 
		this.setBackground(Color.BLUE);
	}
}