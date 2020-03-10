import java.util.*;
/**
 * 
 * @author Sam Tempestini
 *
 */
public class GameManager {
	// this function will be where the rooms are mapped
	public static ArrayList<Room> createMap(ArrayList<Room> rooms)
	{
		String name, desc;
		ArrayList<String> adj = new ArrayList<String>();
		LinkedHashMap<String,String> map = new LinkedHashMap<String,String>();
		LinkedHashMap<String,String> map1 = new LinkedHashMap<String,String>();
		LinkedHashMap<String,String> map2 = new LinkedHashMap<String,String>();
		LinkedHashMap<String,String> map3 = new LinkedHashMap<String,String>();
		LinkedHashMap<String,String> map4 = new LinkedHashMap<String,String>();
		LinkedHashMap<String,String> map5 = new LinkedHashMap<String,String>();
		ArrayList<Room> mappedRooms = new ArrayList<Room>();
		for (Room rm : rooms)
		{
			name = rm.getName();
			desc = rm.getDesc();
			adj = rm.getAdjacent();
			Room curr = new Room(name, desc, adj, map);
			mappedRooms.add(curr);
		}
		// family room
		map.put("N", null);
		map.put("E", "Hallway");
		map.put("S", null);
		map.put("W", null);
		mappedRooms.get(0).setMap(map);
		
		// hallway
		map1.put("N", null);
		map1.put("E", "Kitchen");
		map1.put("S", null);
		map1.put("W", "Family Room");
		mappedRooms.get(1).setMap(map1);
		
		// kitchen
		map2.put("N", null);
		map2.put("E", "Dining Room");
		map2.put("S", "Entrance");
		map2.put("W", "Hallway");
		mappedRooms.get(2).setMap(map2);
		
		// entrance
		map3.put("N", "Kitchen");
		map3.put("E", "Living Room");
		map3.put("S", null);
		map3.put("W", null);
		mappedRooms.get(3).setMap(map3);
		
		// living room
		map4.put("N", "Dining Room");
		map4.put("E", null);
		map4.put("S", null);
		map4.put("W", "Entrance");
		mappedRooms.get(4).setMap(map4);
		
		
		// dining room
		map5.put("N", null);
		map5.put("E", null);
		map5.put("S", "Living Room");
		map5.put("W", "Kitchen");
		mappedRooms.get(5).setMap(map5);
		//map.clear();
		
		return mappedRooms;	
	}

	public static void start(ArrayList<Room> rooms)
	{
		int pizza, bear, range, pos, cnt = 0;
		range = rooms.size();
		Random p = new Random();
		Random b = new Random();
		boolean found = false;
		
		do
		{			
			pizza = p.nextInt(range);
			bear = b.nextInt(range);
		}
		while (pizza == bear);
		
		
		// move the bear's position 
		while(found == false) {
			++cnt;
			pos = move(rooms, bear);
			bear = pos;
			
			if(bear == pizza)
				found = true;
		}
		System.out.println("You found the pizza in the " + rooms.get(pizza).toString() 
				+ "\nIt took you " + cnt + " moves.\nnom nom nom...Still Hungry?");
	}

	public static int move(ArrayList<Room> mapped, int pos)
	{
		
		int newPos = 0;
		String dir, rn;
		boolean valid = false;
		
		LinkedHashMap<String,String> map = new LinkedHashMap<String,String>();
		map = mapped.get(pos).getMap();
		System.out.println("You are in the " + mapped.get(pos).getName() + ": " + mapped.get(pos));
		
		try{
			while (valid == false) 
			{
				System.out.print("Enter N, E, S, or W to move: ");
				Scanner mv = new Scanner(System.in);
				dir = mv.next().trim().toUpperCase();
				
				if (dir.equals("N") || dir.equals("E") || dir.equals("S") || dir.equals("W"))
				{
					if(map.get(dir) == null)
					{
						System.out.println("You cannot move in that direction");
						continue;
					}
		
					else // Direction is "N,E,S,W" && != null
					{
						// room name = to direction key value
						rn = map.get(dir);
						
						for (int i = 0; i < mapped.size(); ++i)
						{
							if (rn.equals(mapped.get(i).getName()))
							{
								newPos = i;
							}
						}
						// where am I?
						System.out.println("You are now in the " + mapped.get(newPos).getName());
						// valid entry set valid to true to break the loop
						valid = true;
					}
				}
			}
			
		} catch(Exception ex)
		{
			System.out.println("ERROR: Invalid entry.");
		}
		// return the bears new position
		return newPos;
	}
}
