package Server;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Reactor {
	
	Reactor()
	{
		
		
	}
	
	public String[] getTopScorers() throws IOException
	{
		ArrayList <String> l = new ArrayList<String>();
		FileReader file_reader = new FileReader("scores.txt");
		BufferedReader bufferedReader = new BufferedReader(file_reader);
		String s[];
		for(int i = 0; i < 15; i++)
		{
			l.add(bufferedReader.readLine());

		}
		
		bufferedReader.close();
		s = (String[])l.toArray();
		return s;
	}
	
	
	public int[] getLevelData(int levelNumber) throws IOException
	{
		FileReader file_reader = new FileReader("levels.txt");
		BufferedReader bufferedReader = new BufferedReader(file_reader);
		String speed = new String();
		String blockNumber = new String();
		int bn;
		int ln = Integer.parseInt(bufferedReader.readLine());
		
		if(levelNumber > ln)
		{
			bufferedReader.close();
			return null;
		}
		for(int i = 0; i < levelNumber - 1; i++)
		{
			speed = bufferedReader.readLine();
			bn = Integer.parseInt(bufferedReader.readLine());
			bufferedReader.readLine();
			int iter = 0;
			while(iter < 2*bn)
			{
				bufferedReader.readLine();
				iter ++;
			}
		}
		speed = bufferedReader.readLine();
		blockNumber = bufferedReader.readLine();
		bn = Integer.parseInt(blockNumber);
		System.out.println(bn);
		int[] res = new int[2*bn+4];
		res[0] = ln;
		res[1] = levelNumber;
		res[2] = Integer.parseInt(speed);
		res[3] = bn;
		for(int i = 0 ; i < 2*bn ; i++)
		{
			res[i+4] = Integer.parseInt(bufferedReader.readLine());
		}
		bufferedReader.close();
		
		return res;
	}
	
	public String updateTopScores(int newScore) throws IOException
	{
		FileReader file_reader = new FileReader("scores.txt");
		BufferedReader bufferedReader = new BufferedReader(file_reader);
		String s = new String();
		boolean greaterThanLoaded = false;
		int loadedScore;
		int i;
		for(i = 0; i < 15; i++)
		{
			loadedScore = Integer.parseInt(bufferedReader.readLine());
			if(!greaterThanLoaded && loadedScore < newScore)
			{
				greaterThanLoaded = true;
				s+=Integer.toString(newScore);
				s+= '\n';
				i++;
			}
			s+= loadedScore;
			s+= '\n';
		}
		
		bufferedReader.close();
		PrintWriter writer = new PrintWriter("scores.txt", "UTF-8");
		writer.print(s);
		writer.close();
		if(greaterThanLoaded)
		{
			return "HighScoreAccepted";
		}
		else
		{
			return "HighScoreRejected";
		}

	}
	
	
}
