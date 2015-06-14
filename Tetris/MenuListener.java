package Tetris;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.ObjectOutputStream;

import javax.swing.JMenuItem;

/**Klasa MenuListener służąca do obsługi zdarzeń zachodzących w menu wyboru poziomu (TetrsiMenu)
 * Zastosowano prosty switch odpowiadający wyborowi poszczególnych przypadków z menu
 * 
 * 
 */
public class MenuListener implements ActionListener
{
	private TetrisView tv;
	ObjectOutputStream o; 
	public MenuListener(TetrisView t, ObjectOutputStream oos )
	{
		tv = t;
		o = oos;
	}
	@Override
	public void actionPerformed(ActionEvent e)
	{
		System.out.println("KLIK");
		switch(((JMenuItem)(e.getSource())).getText())
		{
		case "normal":
			break;
		case "easy":
			break;
		case "hard":
			break;
		case "ON":
			System.out.println("ON");
			tv.startStopAnimation(true);
			break;
		case "OFF":
			System.out.println("OFF");
			tv.startStopAnimation(false);
			break;
		}
	}
}