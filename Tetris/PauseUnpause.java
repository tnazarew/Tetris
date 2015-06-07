package Tetris;

import java.awt.event.*;

/**Klasa obsługuje zdarzenie klinkięcia myszą na przycisk Pauzy znajdujący się w panelu bocznym
 * Ponieważ przycisk ten powinien spełniać 2 funkcjonalności (pausa gry gra się toczy, wzmowienie w przypadku pauzy) przekazywany jest odpowieni parametr b mówiący o aktualnym stanie
 * Parametr b - typu boolean - określa czy gra jest obecnie zatrzymana (1) czy nie (0)
 * Zastosowano pętlę if, która po sprawdzeniu wartości parametru b wykonuje odpowiednie działania
 */
public class PauseUnpause implements ActionListener
{
	private boolean paused;
	@Override
	public void actionPerformed(ActionEvent e)
	{
		if(paused)
		{
			//TODO unpause
		}
		else
		{
			//TODO pause
		}
	}
	public void setPaused(boolean b)
	{
		paused = b;
	}
}