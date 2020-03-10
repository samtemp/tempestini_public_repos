import java.util.*;

public class TleetParser {

	public static String qryUsername(String tleet)
	{
		String[] parts = tleet.split("\t");
		tleet = parts[0].trim();
		
		return tleet;
	}
	public static String qryDate(String tleet) 
	{
		String[] parts = tleet.split("\t");
		tleet = parts[1].trim();
		
		return tleet;
	}
	public static String qryTime(String tleet) 
	{
		String[] parts = tleet.split("\t");
		tleet = parts[2].trim();
		
		return tleet;
	}
	
	public static String qryText(String tleet) 
	{
			
			String[] parts = tleet.split("\t");
			tleet = parts[3].trim();
		
		return tleet;
	}
	public static ArrayList<String> qryTags(String tleet) 
	{

			String [] tags = tleet.split("\\t");
			List<String> taged = Arrays.asList(tags);
			ArrayList<String> parts = new ArrayList<String>();
			ArrayList<String> tleets = new ArrayList<String>();
			String ind;
			for (int i= 0; i < taged.size(); ++i)
			{
				parts.add(taged.get(i));
			}
			
			if(parts.size() >= 5) 
			{			
				tleet = parts.get(4).trim();
				tleets.add(tleet);
				tleet +="#" + tleet;
				for (int j = 5; j < parts.size(); ++j)
				{
					tleet += " #" + parts.get(j).trim();
					ind = parts.get(j).trim();
					tleets.add(ind);
				}
			}
			else
			{
				tleets = null;
			}
		
		return tleets;
	}
	
	
	
}
