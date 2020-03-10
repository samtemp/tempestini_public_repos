package HillyerNilesTempestini;

import java.io.*;


public class MemberParser implements Serializable{
	/**
	 * 
	 * @param mem
	 * @return
	 */
	public static String fNameParser(String mem)
	{
		String[] parts = mem.split("\\t");
		mem = parts[0].trim();
		return mem;
	}
	/**
	 * 
	 * @param mem
	 * @return
	 */
	public static String lNameParser(String mem)
	{
		String[] parts = mem.split("\\t");
		mem = parts[1].trim();
		return mem;
	}
	/**
	 * 
	 * @param fn
	 * @param ln
	 * @return
	 */
	public static String fullNameParser(String fn, String ln)
	{
		return ln + ", " + fn; 
	}
	/**
	 * 
	 * @param mem
	 * @return
	 */
	public static int ageParser(String mem)
	{
		String[] parts = mem.split("\\t");
		mem = parts[2].trim();
		return Integer.parseInt(mem);
	}
	/**
	 * 
	 * @param mem
	 * @return
	 */
	public static int heightParser(String mem)
	{
		String[] parts = mem.split("\\t");
		mem = parts[3].trim();
		return Integer.parseInt(mem);	
	}
	/**
	 * 
	 * @param mem
	 * @return
	 */
	public static int weightParser(String mem)
	{
		String[] parts = mem.split("\\t");
		mem = parts[4].trim();
		return Integer.parseInt(mem);
		
	}
	/**
	 * 
	 * @param mem
	 * @return
	 */
	public static int bpSystParser(String mem)
	{
		String[] parts = mem.split("\\t");
		mem = parts[5].trim();
		return Integer.parseInt(mem);
	}
	/**
	 * 
	 * @param mem
	 * @return
	 */
	public static int bpDiasParser(String mem)
	{
		String[] parts = mem.split("\\t");
		mem = parts[6].trim();
		return Integer.parseInt(mem);
	}
	/**
	 * 
	 * @param mem
	 * @return
	 */
	public static char cancerParser(String mem)
	{
		String[] parts = mem.split("\\t");
		mem = parts[7].trim();
		return mem.charAt(0);
	}
	/**
	 * 
	 * @param mem
	 * @return
	 */
	public static char diabetiesParser(String mem)
	{
		String[] parts = mem.split("\\t");
		mem = parts[8].trim();
		return mem.charAt(0);
	}
	/**
	 * 
	 * @param mem
	 * @return
	 */
	public static char alzheimersParser(String mem)
	{
		String[] parts = mem.split("\\t");
		mem = parts[9].trim();
		return mem.charAt(0);
	}
		
}
