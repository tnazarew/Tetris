package Tetris;

public class Message 
{
	int type;
	String[] content;
	int[] data;
	public Message(int t, String[] c, int[] d)
	{
		type = t;
		content = c;
		data = d;
	}
	
	public String[] getContent()
	{
		return content;
	}
	
	public int getType()
	{
		return type;
	}
	public int[] getData()
	{
		return data;
	}
}
