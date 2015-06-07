package Tetris;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class MoveKeyListener implements KeyListener
{
	 /** Handle the key typed event from the text field. */
    public void keyTyped(KeyEvent e) {
    	int id = e.getID();
    	if (id == KeyEvent.KEY_TYPED)
    	{
    		//TODO
    	}
    }

    /** Handle the key-pressed event from the text field. */
    public void keyPressed(KeyEvent e) 
    {
    	int id = e.getID();
    	if (id == KeyEvent.KEY_TYPED)
    	{
    		//TODO
    	}
    }

    /** Handle the key-released event from the text field. */
    public void keyReleased(KeyEvent e) {
        
    }
}


