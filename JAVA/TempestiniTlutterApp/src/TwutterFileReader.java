import java.util.*;
import java.io.*;

public class TwutterFileReader {
	public static ArrayList<Tleet> readTleet() throws FileNotFoundException
	{
		ArrayList<Tleet> tleets = new ArrayList<Tleet>();
		ArrayList<String> lines = new ArrayList<String>();
		
		ArrayList<String> tag = new ArrayList<String>();
		String line, un, dt, tm, tx, cur; 
				
		try {
			String fname;
			Scanner fsc = new Scanner(System.in);
			System.out.print("Enter name of file: "); 
			fname = fsc.nextLine();
			fsc = new Scanner(new File(fname));	
			
			while(fsc.hasNextLine())
			{
				line = fsc.nextLine().trim();
				if (line.length() > 0)
				{
					lines.add(line); 
				}	
			}
			int size = lines.size();

			for(int i = 0; i < size; ++i)
			{
				cur = lines.get(i);
				un = TleetParser.qryUsername(cur);
				dt = TleetParser.qryDate(cur);
				tm = TleetParser.qryTime(cur);
				tx = TleetParser.qryText(cur);
				tag = TleetParser.qryTags(cur);
				
				Tleet t = new Tleet(un,dt,tm,tx,tag);
				tleets.add(t);
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("Could NOT find specified file.");
			e.printStackTrace();
			return null;
		}
		return tleets;
	}

	public static void printTleets(ArrayList<Tleet> t)
	{
		for (Tleet tt : t)
		{
			System.out.println(tt.toString());
		}
	}
	public static void printTleetFormat(ArrayList<Tleet> t)
	{
		ArrayList<String> tag = new ArrayList<String>();

		for (Tleet tt : t)
			System.out.println(tt.toString() + "\n");
	}
	
}
	