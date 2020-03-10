/**
 * 
 * @author Sam Tempestini
 *
 */ 
import java.util.ArrayList;

public class PrintRooms {
	public static void printRooms(ArrayList<Room> r)
	{
		for (Room rm : r)
		{
			System.out.println(rm.toString());
		}
	}
	public static void printRoomFormat(ArrayList<Room> r)
	{
		ArrayList<String> room = new ArrayList<String>();

		for (Room rm : r)
			System.out.println(rm.toString() + "\n");
	}
	
	public static void printMappedRooms(ArrayList<Room> mrm)
	{
		for (Room rm: mrm)
		{
			System.out.println(rm.toString());
			if (rm.getMap().get("N") == null)
				System.out.println("No neighbor on the North");
			else
				System.out.println("Connected on the North to " + rm.getMap().get("N"));
			if (rm.getMap().get("E") == null)
				System.out.println("No neighbor on the East");
			else
				System.out.println("Connected on the East to " + rm.getMap().get("E"));
			if (rm.getMap().get("S") == null)
				System.out.println("No neighbor on the South");
			else
				System.out.println("Connected on the South to " + rm.getMap().get("S"));
			if (rm.getMap().get("W") == null)
				System.out.println("No neighbor on the West");
			else
				System.out.println("Connected on the West to " + rm.getMap().get("W"));
			System.out.println();

		}
	}
}
