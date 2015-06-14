package Tetris;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**Klasa Wyjscie obsługuje zdarzenie kliknięcia myszą na przycisk 'Wyjście z gry'
 * Analogicznie do swojej nazwy - zamyka program
 * Zawiera referencję na obiekt jp
 * 
 */

public class Wyjscie implements ActionListener
{

	@Override
	public void actionPerformed(ActionEvent e)
	{
		System.exit(0);
	}

}