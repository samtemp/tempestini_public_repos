import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RoomParser {
	public static String qryName(String room)
	{
		String[] parts = room.split("\\t");
		room = parts[0].trim();
		
		return room;
	}
	public static String qryDesc(String room) 
	{
		String[] parts = room.split("\\t");
		room = parts[1].trim();
		
		return room;
	}

	public static ArrayList<String> qryAdjacent(String room) 
	{

		String [] adj = room.split("\\t");
		List<String> adjct = Arrays.asList(adj);
		ArrayList<String> rooms = new ArrayList<String>();

		for (int i= 0; i < adjct.size(); ++i)
		{
			rooms.add(adjct.get(i));
		}

		return rooms;
	}

}
