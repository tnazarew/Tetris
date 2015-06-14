package Server;
import java.io.*;
public class MessageObject implements Serializable
{


	/**
	 * 
	 */
	private static final long serialVersionUID = 10L;


	int type;
	String arg[];
	int[] data;
	public  MessageObject(int v, String[] s, int[] d )
	{
		this.type=v;
		this.arg=s;
		this.data = d;
	}
	public int getType()
	{
		return type;
	}
	
	public String[] getArg()
	{
		return arg;
	}
	public int[] getData()
	{
		return data;
	}
}
