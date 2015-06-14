package Tetris;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class MoveKeyListener implements KeyListener
{
	PlayingField p;
	 /** Handle the key typed event from the text field. */
    public void keyTyped(KeyEvent e) {
    	int id = e.getID();
    	if (id == KeyEvent.KEY_TYPED)
    	{
    		switch(e.getKeyCode())
    		{
    		case KeyEvent.VK_UP:
    			
    			break;
    		case KeyEvent.VK_DOWN:
    			
    			break;
    		case KeyEvent.VK_LEFT:
    			p.moveSide(false);
    			break;
    		case KeyEvent.VK_RIGHT:
    			p.moveSide(true);
    			break;
    		case KeyEvent.VK_D:
    			p.moveSide(true);
    			break;
    		}
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
    public void setPlayingField(PlayingField pf)
    {
    	p = pf;
    }
}


