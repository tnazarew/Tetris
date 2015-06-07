package Tetris;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Klasa czytajšca pliki tekstowe używane w grze
 * 
 * @author szaroket
 */
public class FileData {

	private String data_file_name;
	
	/**
	 * Podaj nazwę pliku tekstowego
	 * 
	 * @param file_name Nazwa pliku tekstowego
	 * @throws FileNotFoundException
	 */
	public FileData(String file_name) throws FileNotFoundException{
		data_file_name = file_name;
	}
	
	/**
	 * Policz wszystkie linie w pliku tekstowym
	 * 
	 * @return Liczbę linii w tekcie
	 * @throws IOException
	 */
	public int countLines() throws IOException{
		FileReader file_reader = new FileReader(data_file_name);
		BufferedReader buffered_reader = new BufferedReader(file_reader);
		@SuppressWarnings("unused")
		String line;
		int count=0;
		
		while((line = buffered_reader.readLine()) != null) {
            count++;
        } 
		
		buffered_reader.close();
		return count;
	}
	
	/**
	 * Odczytanie całego pliku tekstowego
	 * 
	 * @return All lines in a string array
	 * @throws IOException
	 */
	public String[] readWholeFile() throws IOException {
		FileReader file_reader = new FileReader(data_file_name);
		BufferedReader buffered_reader = new BufferedReader(file_reader);
		
		int number_of_lines = countLines();
		String[] text_data = new String[number_of_lines];
		
		for(int i=0; i<number_of_lines; i++){
			text_data[i] = buffered_reader.readLine();
		}
		
		buffered_reader.close();
		
		return text_data;
	}
	
	/**
	 * Dodaje linię tekstu podanego w parametrze do pliku
	 * 
	 * @param line
	 * @throws IOException
	 */
	public void addToFile(String line) throws IOException{
		FileWriter file_writer = new FileWriter(data_file_name);
		BufferedWriter buffered_writer = new BufferedWriter(file_writer);
		
		buffered_writer.write(line);
		buffered_writer.newLine();
		
		buffered_writer.close();
	}
	
	/**
	 * Szuka w tekcie podanego parametru
	 * 
	 * @param line
	 * @return Liczba linii, w których został znaleziony parametr bšd -1 jeli nie znalazł
	 * @throws IOException
	 */
	public int findInFile(String line) throws IOException {
		FileReader file_reader = new FileReader(data_file_name);
		BufferedReader buffered_reader = new BufferedReader(file_reader);
		int count = 0;
		String loaded_line;
		
		while((loaded_line = buffered_reader.readLine()) != null) {
			count++;
            if(loaded_line.equals(line)){
            	buffered_reader.close();
            	return count;
            }
        } 
		
		buffered_reader.close();
		
		return -1;
	}
	
	/**
	 * Odczytanie jednej linii
	 * 
	 * @param line Liczba linii do odczytania.
	 * @return Odczytanie linii bšd zwrócenie 'null' jeli parametr jest niezgodny 
	 * lub większy niż liczba linii
	 * @throws IOException
	 */
	public String readOneLine(int line) throws IOException {
		FileReader file_reader = new FileReader(data_file_name);
		BufferedReader buffered_reader = new BufferedReader(file_reader);
		int count = 0;
		String loaded_line;
		
		while((loaded_line = buffered_reader.readLine()) != null) {
			count++;
            if(count==line){
            	buffered_reader.close();
            	return loaded_line;
            }
        } 
		
		buffered_reader.close();
		
		return null;
	}
	
	/**
	 * Dodanie nowej opcji podczas czytania pliku konfiguracyjnego
	 * 
	 * @param name Nazwa opcji.
	 * @param option Wartoć opcji.
	 * @throws IOException
	 */
	public void addSetting(String name, String option) throws IOException{
		addToFile("#"+name);
		addToFile(option);
	}
	
	/**
	 * Pobieranie danych z pliku konfiguracyjnego.
	 * 
	 * @param name Nazwa danej.
	 * @return Nazwa danej.
	 * @throws IOException
	 */
	public String getSetting(String name) throws IOException 
	{
	           //System.out.println(name);	
                    return readOneLine(findInFile("#"+name)+1);
                    
	}
	
	public String[] getSetting(String name, int numberOfBlocks) throws IOException 
	{
        //System.out.println(name);	
		String[] s = new String[numberOfBlocks];
		for (int i = 1; i <= numberOfBlocks; i++)
		{
			s[i-1] = readOneLine(findInFile("#"+name)+i);
		}            
		return s;
	}
	
	
}