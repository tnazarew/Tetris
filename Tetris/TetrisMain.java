/**Gra Tetris - projekt w ramach przedmiotu PROZE
 * @author Luiza Czerwińska
 */
package Tetris;
import Server.MessageObject;
import java.awt.EventQueue;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;



/**Klasa TetrisMain odpowiadająca za tworzenie ramki programu (dziedziczy po JFrame)
 * Za pomocą rozkładu GridBagLayout rozmieszczone są wewnątrz niej zarówno panel boczny jak i plansza (w proporcji 5:1 przy domyślnym rozmiarze okna)
 * Rozmiar planszy i zawartych w niej elementów (klocków) podlega skalowaniu, jednak zachowana jest proporcja wysokości do szerokości równa 2:1
 */
public class TetrisMain
{
	
    /**g to obiekt klasy GameField, reprezentuje pole gry
     * sp to obiekt klasy SecondPanel, reprezentuje panel boczny zaiwerający interfejs użytkownika
     */
	static private TetrisView tv;
	
	public static void main(String args[]) throws UnknownHostException, IOException
	{
		//BlockingQueue<Message> toServer = new ArrayBlockingQueue<>(20);
		Socket s = new Socket("127.0.0.1", 9090);
		InputStream is = s.getInputStream();
		ObjectInputStream ois = new ObjectInputStream(is);
		OutputStream os = s.getOutputStream();
		final ObjectOutputStream oos = new ObjectOutputStream(os);
		String[] s1 = new String[1];
		s1[0] = "LEVEL_GET";
		
		MessageObject to;
		to = new MessageObject(1, s1, null);
		oos.writeObject(to);
		try {
			to = (MessageObject)ois.readObject();
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		final MessageObject fin = to;
		EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
				tv = new TetrisView(fin.getData(), oos);
			}
		});
		
		
		while(true)
		{
			
			try 
			{
				to = (MessageObject)ois.readObject();				
				if(to!=null)
				{
					switch(to.getType())
					{
					case 1://lista najlepszych wynikow
						
						break;
					case 2://odpowiedz na przeslany wynik
						
						break;
					case 3://dane poziomu
						tv.setNewGame(to, oos);
						break;
					case 4://zamkniecie socketa
						
						break;
					}
				}
			}
			catch (ClassNotFoundException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	

	
}		