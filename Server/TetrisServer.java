package Server;


import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
//import java.io.OutputStream;
//import java.io.PrintWriter;
import java.net.Socket;
//import java.net.SocketTimeoutException;
import java.net.ServerSocket;

/**
 * serwer bazujący na zapytaniach w formacie string
 */
public class TetrisServer {

    /**
     * @throws ClassNotFoundException 
     * 
     */
    public static void main(String[] args) throws IOException, ClassNotFoundException 
    {								
        ServerSocket listener = new ServerSocket(9090);	//podstawa serwera									
        Reactor r = new Reactor(); //klasa własna, reaguje na zapytania
        boolean loop;
        String[] message;
        MessageObject m;
        int[] data;
        
        
        
        
        
        
		
        
        try {
            while (true) 
            {
                Socket socket = listener.accept();//czeka na połączenie i gdy zostanie nawiązane przekazuje do socket
                InputStream is = socket.getInputStream();//strumień wejścia, pobieramy z niego dane
                //BufferedReader br = new BufferedReader(new InputStreamReader(is));//potrzebne do odczytu, trochę bez sensu ale bez tego nic nie zrobisz
                //PrintWriter out = new PrintWriter(socket.getOutputStream(), true);//wysyłanie danych do output streamu
                OutputStream os = socket.getOutputStream();
        		ObjectOutputStream oos = new ObjectOutputStream(os);
        		MessageObject to;


    			ObjectInputStream ois = new ObjectInputStream(is);
    			
                loop = true;
                while(loop)
                {
                	
                	m = (MessageObject)ois.readObject(); //czytanie lini z bufora
                	switch((m.getArg())[0])
                	{
                		case "SEND_HIGHSCORES_LIST":
                			message = r.getTopScorers();
                			//out.println(message);//wysyłanie stringa
                			to = new MessageObject(1, message, null);
                			oos.writeObject(to);
                			break;
                		case "NEW_TOP_SCORE":
                			int score = m.getType();
                			message = new String[1];
                			message[0] = r.updateTopScores(score);
                			to = new MessageObject(2, message, null);
                			oos.writeObject(to);
                			//out.println(message);
                			break;                			
                		case "LEVEL_GET":
                			int i = m.getType();
                			data = r.getLevelData(i);
                			to = new MessageObject(3, null, data);
                			oos.writeObject(to);
                			//out.println(message);
                			break;
                		case "CLOSE":
                			message = new String[1];
                			message[0] = "CLOSED";
                			to = new MessageObject(4, message, null);
                			oos.writeObject(to);
                			//out.println(message);
                			//br.close();
                			//is.close();
                			//out.close();
                			oos.close();
                			os.close();
                	        
                			socket.close();//zamknięcie socketa, zakończenie połączenia
                			loop = false;
                			break;
                		default:
                			
                		
                	}
            	}
                
            }
        } 
        finally {
            listener.close();
        }
    }
}