import java.util.*;

public class Room {
	private String name;
	private String desc;
	private LinkedHashMap<String, String> map = new LinkedHashMap<String, String>();
	private ArrayList<String> adjacent = new ArrayList<String>();
	
	Room()
	{
		name ="";
		desc = "";
		map = null;
		adjacent = null;
	}
	Room(String name,String desc, LinkedHashMap<String,String> map)
	{
		this.name = name;
		this.desc = desc;
		this.map = map;
	}
	Room(String name, String desc, ArrayList<String> adjacent)
	{
		this.name = name;
		this.desc = desc;
		this.adjacent = adjacent;

	}
	Room(String name, String desc,  ArrayList<String> adjacent,  LinkedHashMap<String, String> map)
	{
		this.name = name;
		this.desc = desc;
		this.adjacent = adjacent;
		this.map = map;
	
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public LinkedHashMap<String, String> getMap() {
		return map;
	}
	public void setMap(LinkedHashMap<String, String> map) {
		this.map = map;
	}
	public ArrayList<String> getAdjacent() {
		return adjacent;
	}
	public void setAdjacent(ArrayList<String> adjacent) {
		this.adjacent = adjacent;
	}
	
	
	public String strAdj(ArrayList<String> adjacent)
	{
		String adj = " ";
		for (String str : this.adjacent)
		{
			adj += str + " ";
		}
		return adj;
	}

	
	@Override 
	public String toString()
	{
		String rm = this.name + ": " + this.desc + ".";
		return rm;
	}
	

}
