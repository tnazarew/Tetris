package Tetris;

import java.io.ObjectOutputStream;

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
	TetrisMenu(TetrisView tv, int[] data, ObjectOutputStream oos )
	{
		JMenuItem level;
		MenuListener l = new MenuListener(tv, oos);
		JMenu menu = new JMenu("Wybór poziomu");
		//this.liczpoz=conf.liczba_poziomow;
		for(int i = 0 ; i < data[0] ; i ++)
		{
			level = new JMenuItem(((new Integer(i+1)).toString()));
			level.addActionListener(l);
			menu.add(level);
			
		}
		
		
	
        JMenu animation = new JMenu("GRA");
        JMenuItem on = new JMenuItem("ON");
        JMenuItem off = new JMenuItem("OFF");
        
        on.addActionListener(l);
        off.addActionListener(l);
        animation.add(on);
        animation.add(off);
        

       
        
        
        add(menu);
		add(animation);
		       
	}	

	
}