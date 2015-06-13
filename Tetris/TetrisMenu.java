package Tetris;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

/**Klasa TetrisMenu reprezentuje proste rozwijane menu wyboru trudności planszy
 * Po dokonaniu wyboru, program szczytuje z pliku konfiguracyjnego dane dotyczące następnego poziomu
 * Klasa dziedziczy po JMenuBar, opcjami są: easy/normal/hard
 * Użytkownik dokonuje wyboru poprzez kliknięcie jednej z 3 opcji
 */

@SuppressWarnings("serial")
public class TetrisMenu extends JMenuBar
{
	public int liczpoz;
	TetrisMenu(TetrisView tv)
	{
		//this.liczpoz=conf.liczba_poziomow;
		
		JMenuItem  easy = new JMenuItem("(1) - łatwy");
		JMenuItem normal = new JMenuItem("(2) - średni");
		JMenuItem hard = new JMenuItem("(3) - trudny");
	
        JMenu animation = new JMenu("GRA");
        JMenuItem on = new JMenuItem("ON");
        JMenuItem off = new JMenuItem("OFF");
        MenuListener l = new MenuListener(tv);
        on.addActionListener(l);
        off.addActionListener(l);
        animation.add(on);
        animation.add(off);
        easy.addActionListener(l);
        normal.addActionListener(l);
        hard.addActionListener(l);
        JMenu menu = new JMenu("Wybór poziomu");
        menu.add(easy);
        menu.add(normal);
        menu.add(hard);
        add(menu);
		add(animation);
		       
	}	

	
}