/**Gra Tetris - projekt w ramach przedmiotu PROZE
 * @author Luiza Czerwińska
 */
package Tetris;

import java.awt.EventQueue;



/**Klasa TetrisMain odpowiadająca za tworzenie ramki programu (dziedziczy po JFrame)
 * Za pomocą rozkładu GridBagLayout rozmieszczone są wewnątrz niej zarówno panel boczny jak i plansza (w proporcji 5:1 przy domyślnym rozmiarze okna)
 * Rozmiar planszy i zawartych w niej elementów (klocków) podlega skalowaniu, jednak zachowana jest proporcja wysokości do szerokości równa 2:1
 */
public class TetrisMain
{
	
    /**g to obiekt klasy GameField, reprezentuje pole gry
     * sp to obiekt klasy SecondPanel, reprezentuje panel boczny zaiwerający interfejs użytkownika
     */

	
	public static void main(String args[])
	{
		EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
				TetrisView tv = new TetrisView();


			}
		});
	}
	

	
}		