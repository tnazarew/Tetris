package Tetris;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
 
/**Klasa SecondPanel to klasa, której obiekt reprezentuje panel boczny z opcjami dla gracza
 * Za pomocą rozkładu GridBagLayout rozmieszczone zostały 4 główne elementy tego interfejsu: przyciski pauzy i końca gry oraz pola tekstowe informujące o punktach i aktualnym poziomie
 * Przyciski pauzy i wyjścia z gry obsługują zdarzenia (kliknięcie myszą) i wykonują odpowiednie czynności
 */
 
@SuppressWarnings("serial")
public class SecondPanel extends JPanel
{
	private JButton exit;
	private JButton pause;
	private JTextField punkty;
	private JTextField poziom;
	
	private PauseUnpause pup;
	private Wyjscie ex;
	public SecondPanel(JFrame jp)
	{
		this.setLayout(new GridBagLayout());
		GridBagConstraints co = new GridBagConstraints();
		
		pause = new JButton("Pauza");
		punkty = new JTextField("Punkty: []");
		poziom = new JTextField("Grasz na poziomie: []");
		exit = new JButton("Wyjście z gry");
		pup = new PauseUnpause();
		ex = new Wyjscie();
		pup.setPaused(false);
		pause.addActionListener(pup);
		
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
		add(pause, co );
		co.fill = GridBagConstraints.HORIZONTAL;				
		co.gridx = 6;
		co.gridy = 1;
		co.weightx = 0.25;
		co.weighty = 1;
		co.gridwidth = 1;
                co.gridheight = 1;		
		add(punkty,co);
		co.fill = GridBagConstraints.HORIZONTAL;				
		co.gridx = 6;
		co.gridy = 2;
		co.weightx = 1.0;
		co.weighty = 1;
		co.gridwidth = 1;
                co.gridheight = 1;
		add(poziom,co);
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