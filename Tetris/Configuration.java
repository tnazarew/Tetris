package Tetris;
import java.io.FileNotFoundException;
import java.io.IOException;


/**
 * Klasa czytajšca i prasujšca dane z pliku konfiguracyjnego
 * 
 *
 */

public class Configuration {
	
	//public int liczba_poziomow=0;
	public int nr_poziomu=0;
	public int liczba_kloc=0;
	public int x_kloc[];
    public int y_kloc[];
	//public int tempo=0;
	
	public Configuration (){
		
		FileData config2 = null;
		
		try {
			config2 = new FileData("plikconf.txt");
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
		try {
			//this.liczba_poziomow = Integer.parseInt(config2.getSetting("LICZBA POZIOMOW"));
			this.nr_poziomu = Integer.parseInt(config2.getSetting("NUMER POZIOMU"));
			this.liczba_kloc = Integer.parseInt(config2.getSetting("LICZBA KLOCKOW"));
			x_kloc = new int[liczba_kloc];
			y_kloc = new int[liczba_kloc];
			String sx[] = new String[liczba_kloc];
			String sy[] = new String[liczba_kloc];
			System.arraycopy(config2.getSetting("X KLOCKA", liczba_kloc), 0, sx, 0, liczba_kloc);
			System.arraycopy(config2.getSetting("Y KLOCKA", liczba_kloc), 0, sy, 0, liczba_kloc);
            for(Integer j=0;j<this.liczba_kloc;j++)
            {
            	System.out.println(liczba_kloc);
            	System.out.println(sx[j]);
                this.x_kloc[j] = Integer.parseInt(sx[j]);
                this.y_kloc[j] = Integer.parseInt(sy[j]);
                
            }
			//this.tempo = Integer.parseInt(config2.getSetting("TEMPO"));
						
		} catch (NumberFormatException | IOException e) {
			e.printStackTrace();
		}
                
	}
	
}