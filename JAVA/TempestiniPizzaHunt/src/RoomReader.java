/**
 * @author Sam Tempestini
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class RoomReader {
	public static ArrayList<Room> readRooms() throws FileNotFoundException
	{
		ArrayList<Room> rooms = new ArrayList<Room>();
		ArrayList<String> lines = new ArrayList<String>();
		
		ArrayList<String> adj = new ArrayList<String>();
		String line, nm, dsc, cur; 
		
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
			//...
			for(int i = 0; i < size; ++i)
			{
				cur = lines.get(i);
				nm = RoomParser.qryName(cur);
				dsc = RoomParser.qryDesc(cur);
				adj = RoomParser.qryAdjacent(cur);
				
				Room r = new Room(nm, dsc, adj);
				rooms.add(r);
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("Could NOT find specified file.");
			//e.printStackTrace();
			return null;
		}
		return rooms;
	}
}
