package Tetris;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

/**Klasa Wyjscie obsługuje zdarzenie kliknięcia myszą na przycisk 'Wyjście z gry'
 * Analogicznie do swojej nazwy - zamyka program
 * Zawiera referencję na obiekt jp
 * 
 */

public class Wyjscie implements ActionListener
{
	JFrame jp;
	@Override
	public void actionPerformed(ActionEvent e)
	{
		System.exit(0);
	}
	void setPanel(JFrame j)
	{
		jp = j;
	}
}