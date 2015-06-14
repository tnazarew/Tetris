package Tetris;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.ObjectOutputStream;

import javax.swing.JMenuItem;

import Server.MessageObject;

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
		String input;
		switch(input = ((JMenuItem)(e.getSource())).getText())
		{
		case "ON":
			System.out.println("ON");
			tv.startStopAnimation(true);
			break;
		case "OFF":
			System.out.println("OFF");
			tv.startStopAnimation(false);
			break;
		default:
			String[] s = new String[1];
			s[0] = "LEVEL_GET";
			try {
				System.out.println(input);
				o.writeObject(new MessageObject(1, s, null));
			} catch (NumberFormatException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}	
				
		}
	}
}