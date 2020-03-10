/*
	Author: 	Sam Tempestini
	Teacher: 	Raymond Klump
	Course:		CPSC 24500-004
 	Date:		09/16/2019
 	Descr:		This is a menu driven program that receives a weather data txt file fully qualified path
 	 			name as input. 
*/

package TempestiniWeather;

import java.util.Scanner;
import java.io.*;
import java.util.ArrayList;

public class TempestiniWeather 
{
	
	public static void showMenu()
	{
		System.out.println("********************************************************************");
		System.out.println("****	Welecome to the Weather Data App For Romeville, IL	****");
		System.out.println("Enter 1 to see: the average maximum and minmium temperatures");
		System.out.println("Enter 2 to see: the total precipitation");
		System.out.println("Enter 3 to see: the highest recorded temperature");
		System.out.println("Enter 4 to see: the lowest recorded temperature,");
		System.out.println("Enter 5 to see: the number of days that saw thunder each year");
		System.out.println("Enter 6 to: input a date for the high and low tremperatures");
		System.out.println("Enter 7 to see Custom #1: how many days had servere weather");
		System.out.println("Enter 8 to see Custom #2: the total precipitation including snow");
		System.out.println("Enter 0 to Quit");
		System.out.println("********************************************************************");
	  }
	  public static ArrayList<Integer> storeContentsInt(ArrayList<String> strings, int a, int b)
	  {
		  ArrayList<Integer> myInt = new ArrayList<Integer>();
		  for (String str : strings)
		  {  
			 myInt.add(Integer.parseInt(str.substring(a, b).trim())); 
		  }
		  return(myInt); 
	  }
	  public static ArrayList<Integer> storeContentsInt(ArrayList<String> strings, int a)
	  {
		  ArrayList<Integer> myInt = new ArrayList<Integer>();
		  for (String str : strings)
		  {  
			 myInt.add(Integer.parseInt(str.substring(a).trim())); 
		  }
		  return(myInt); 
	  }
	  public static ArrayList<Double>  storeContentsDoub(ArrayList<String> strings, int a, int b)
	  {
			  ArrayList<Double> myDoub = new ArrayList<Double>();
			  for (String str : strings)
			  {  
				 myDoub.add(Double.parseDouble(str.substring(a, b).trim())); 
			  }
			  return(myDoub); 
	  }
	  public static ArrayList<String> storeContentsStr(ArrayList<String> strings, int a, int b)
	  {
		 ArrayList<String> myStr = new ArrayList<String>();
		  for (String str : strings)
		  {  
			 myStr.add(str.substring(a, b).trim()); 
		  }
		  return(myStr); 
	  }
	  public static ArrayList<String> storeContentsStr(ArrayList<String> strings, int a)
	  {
		 ArrayList<String> myStr = new ArrayList<String>();
		  for (String str : strings)
		  {  
			 myStr.add(str.substring(a).trim()); 
		  }
		  return(myStr); 
	  }
	  public static double calcAvg(ArrayList<Integer> toAvg)
	  {
		  if (toAvg == null || toAvg.isEmpty()) 
		  {
		        return 0;
		  }
		  
		  int sum = 0;
		  
		  for (Integer ave : toAvg)
		  {
			  sum += ave;
		  }
		  
		  return (double)sum / toAvg.size();
	  }
	        
	  public static void printTempAvg(ArrayList<Integer> max, ArrayList<Integer> min)
	  {
		  // values rounded to 3 decimal places
		  System.out.printf("The average maximum temperature is " + "%.01f" + " degrees.", calcAvg(max));
		  System.out.printf("\nThe average minimum temperature is " + "%.01f" + " degrees.", calcAvg(min));
		  System.out.println();
	  }
	  
	  // option 2
	  public static Double totPrcp(ArrayList<Double> tp)
	  {
		  double sum = 0.0;
		  
		  for (Double i : tp)
		  {	
			  // this takes care of the -9999 values
			  if (i >= 0.0)
			  {
				  sum += i;
			  }
		  }
		  return sum;
	  }
	  
	  //option 3
	  public static int calcHiTemp(ArrayList<Integer> ht)
	  {
		  int high = 0, test = 0;
		  
		  for (Integer i : ht)
		  {
			  test = i;
			  if (test > high)
			  {
				  high = test;
			  }
		  }
		  
		  return high;	  
	  }
	  public static void printHiTemp(int t)
	  {
		  System.out.println("The highest temperature is " + t + " degrees."); 
	  }
	  
	  // option 4
	  public static int calcLoTemp(ArrayList<Integer> lt)
	  {
		  int low = 100, test = 0;
		  
		  for (Integer i : lt)
		  {
			  test = i;
			  if (test < low)
			  {
				  low = test;
			  }
		  }
		  
		  return low;
	  }
	  public static void printLoTemp(int t)
	  {
		  System.out.println("The lowest temperature is " + t + " degrees.");   
	  }
	
	  //option 5 Saw Thunder
	  public static Integer sawT(ArrayList<Integer> st)
	  {
		  Integer sum = 0;
		  
		  for (Integer i : st) 
		  {
			  if (i == 1)
			  {
				  sum += i;
			  }
		  }
		  return sum;
	  }
	  public static void printSawT(ArrayList<Integer> al)
	  {
		  Integer sum = sawT(al);
		  System.out.println("The number of days that saw thunder are " + sum);
	  }
	  
	  public static void main(String[] args) throws IOException 
	  {
	  // Data 
			// Date
			ArrayList<String> date = new ArrayList<String>();
			// Maximum temperatures 
			ArrayList<Integer> tmax =  new ArrayList<Integer>();
			// Minimum temperatures
			ArrayList<Integer> tmin =  new ArrayList<Integer>();
			// Fog, ice fog, or freezing fog (may include heavy fog)
			ArrayList<Integer> wt01 =  new ArrayList<Integer>();
			// Glaze or rime
			ArrayList<Integer> wt06 =  new ArrayList<Integer>();
			// Hail (may include small hail)
			ArrayList<Integer> wt05 =  new ArrayList<Integer>();
			// High or damaging winds
			ArrayList<Integer> wt11 =  new ArrayList<Integer>();
			// Ice pellets, sleet, snow pellets, or small hail
			ArrayList<Integer> wt04 =  new ArrayList<Integer>();
			// Thunder
			ArrayList<Integer> wt03 =  new ArrayList<Integer>();
			// Precipitation
			ArrayList<Double> prcp = new ArrayList<Double>();
			// Snowfall
			ArrayList<Double> snow = new ArrayList<Double>();

			// variable for menu selection
			int func;
			
			String fname;
			Scanner sc = new Scanner(System.in);
			System.out.print("Enter name of file: ");
			fname = sc.nextLine();
			// file name
			// C:\Windows\Temp\weather_data.txt
			File f = new File(fname);
	       
	       String line;
	       ArrayList<String> lines = new ArrayList<String>();
	       try {
	            Scanner fsc = new Scanner(f);
	            fsc.nextLine();
	            fsc.nextLine();
	            while (fsc.hasNextLine()) {
	                line = fsc.nextLine().trim();
	                lines.add(line);
	            }
	            fsc.close();
	       } catch (Exception ex) 
	       {
	            System.out.println("Couldn't read file.");
	       }
	       
	       // populates ArraysLists
	       try {
				date = storeContentsStr(lines, 69, 77);
				prcp = storeContentsDoub(lines, 78, 86);
				snow = storeContentsDoub(lines, 87, 95);
				tmax = storeContentsInt(lines, 96, 104);
				tmin = storeContentsInt(lines, 105, 113);
				wt01 = storeContentsInt(lines, 114, 122);
				wt06 = storeContentsInt(lines, 123, 131);
				wt05 = storeContentsInt(lines, 132, 140);
				wt11 = storeContentsInt(lines, 141, 149);
				wt04 = storeContentsInt(lines, 150, 158);
				wt03 = storeContentsInt(lines, 159);	    
	       }catch(Exception e)
	       {
	    	   System.out.println("Items not copied successfully.");
	    	   e.printStackTrace();
	       }

	       try {
		       do {
		    	   showMenu(); 
		    	   System.out.print("Select your choice: ");
		    	   //sc.nextLine();
		    	   func = sc.nextInt();
		    	   
		    	   if (func == 1)
		    	   {
		    	   		//Complete -- SRT 9/4
		    		   	printTempAvg(tmax,tmin);
		    	   }
		    	   else if (func == 2)
		    	   {
		    	   		// Complete -- SRT 9/4
		    		   	Double totP = totPrcp(prcp);
			   			System.out.printf("The total precipitation is " + "%.03f" , totP);
			   			System.out.println();
		    	   }
		    	   else if (func == 3)
		    	   {
		    	   		// Complete -- SRT 9/4
		    		    int hi = calcHiTemp(tmax);
		    		   	printHiTemp(hi);
		    	   }
		    	   else if (func == 4)
		    	   {
		    		   // Complete -- SRT 9/4
		    		   int lo = calcLoTemp(tmin);
		    		   printLoTemp(lo);
		    	   }
		    	   else if (func == 5)
		    	   {
		    	   		// Complete -- SRT 9/4
		    		   	printSawT(wt03);
		    	   }
		    	   else if (func == 6)
		    	   {
		    		   // Complete -- SRT 9/8
		    		   try {
		    		       System.out.print("Enter a date using YYYYMMDD format: ");
		    		       Scanner in = new Scanner(System.in);
		    		       String input = in.next();
		    		       boolean valid = true;
		    		       int test = Integer.parseInt(input),
		    		    		   minD = 20190101,
		    		    		   maxD = 20190828;
		    		       
		    		       if (test < minD || test > maxD)
		    		       {
		    		    	   System.out.println("No data exists for this date.");
		    		    	   valid = false;
		    		       }
		    		       else if (valid == true)
		    		       {
		    			       int index = 0;
		    			       for(int i = 0; i < date.size();  ++i)
		    			       {  
		    			    	   if (input.equals(date.get(i)))
		    			    	   {
		    			    		   index = i;
		    			    		   break;
		    			    	   }
		    			       }
		    		       
		    			       System.out.println("For the date " + date.get(index) 
		    			       		+ "\nThe highest temperature was " + tmax.get(index) 
		    			    		+ " degrees. \nThe lowest temperature was " + tmin.get(index)
		    			    		+ " degrees.");
		    			      
		    		       }

		    	       }catch(Exception e)
		    	       {
		    	    	   System.out.println("Error");
		    	    	   e.printStackTrace();
		    	       }
		    		  
		    	   }
		    	   else if (func == 7)
		    	   {
		    		   	// Complete -- SRT 9/8
		    	   		// Custom #1
		    	   		/*
		    	   		  Custom function 1 gives the user the sum of the days that have any of the following occurred:
		    	   		  	WT11 - High or damaging winds
		  				  	WT01 - Fog, ice fog, or freezing fog	  
		    	   		  	WT03 - Thunder	
		    	   		  	WT04 - Ice pellets, sleet, snow pellets, or small
							WT05 - Hail
						  	WT06 - Glaze or rime
						  */  

		       			   Integer tot = 0, add = 0;
		       			   tot = sawT(wt01);
					       add = sawT(wt03);
					       tot += add;
					       add = sawT(wt04);
					       tot += add;
					       add =sawT(wt05);
					       tot += add;
					       add = sawT(wt06);
					       tot += add;
					       add= sawT(wt11);
					       tot += add;
					       System.out.println("The amount of days with severe weather were " + tot);
					     
		    	   }
		    	   else if (func == 8)
		    	   {
		    		   // Complete -- SRT 9/8
		    		   //Custom #2;
		    		   //Custom function 2 gives the user the total prcp + snow
		    		    
		       			Double total = totPrcp(prcp);
		       			total += totPrcp(snow);
		       			System.out.printf("The total precipitation including snow is " + "%.03f" , total);
		       			System.out.println();
		    	   }
		    	   else if (func == 0)
		    	   {
		    		   System.out.println("Good bye!");
		    		   System.exit(0);
		    	   }
		    	   else 
		    	   {
		    		   System.out.println("INVALID ENTRY...QUITTING PROGRAM");
		    		   System.exit(1);
		    	   }
		       } while (func != 0);
		       }catch(Exception exp)
		       {
		    	   System.out.println("Something went wrong.");
		       }
			   sc.close();
			   System.exit(0);
	  }
}