// Sam Tempestini
// 09/03/2019
// TempestiniGettingToKnowMe.java
// This menu driven program that tell the user a little bit about me
// by selecting different options on the menu. 
// the program will persist until zero is entered.



import java.util.Scanner;

//**************************
// imports for link portion
import java.awt.Desktop;
import java.net.URI;
//**************************


public class TempestiniGettingToKnowMe 
{

    public static void showMenu()
    {
        System.out.println("What would you like to ask me?");
        System.out.println("1. What is my full name?");
        System.out.println("2. Where did I go to high school?");
        System.out.println("3. What are my favorite hobbies?");
        System.out.println("4. What is my philosophy on life?");
        System.out.println("5. What do I hope to do for a career");
        System.out.println("6. What do I look like?");
        System.out.print("Please enter the number of your choice, or 0 to quit: ");
    }
    
    // Throws exception used for browser link
	public static void main(String[] args) throws Exception
	{
        Scanner sc = new Scanner(System.in);  // Create a Scanner object
        
        int choice;
        String ans = "";
        try 
        {
	        do 
	        {
	            showMenu();
	            choice = sc.nextInt();
	           if (choice == 1)
	           {
	        	   ans = "\tSam Tempestini.";
	           }
	           else if(choice == 2)
	           {
	        	   ans = "\tI was homeschooled.";
	           }
	           else if(choice == 3)
	           {
	        	   ans = "\tSkiing.\n\tBowling.\n\tCoffee.";
	           }
	           else if(choice == 4)
	           {
	        	   ans = "\tWork hard, play harder, and always make time for family and friends.";
	           }
	           else if(choice == 5)
	           {
	        	   ans = "\tCybersecurity Specialist.";
	           }
	           else if(choice == 6)
	           {
	        	  ans = "\tCheck Me Out!";
	        	  
	        	  // ********************************************************************
	        	  // ****					START OF BARROWED CODE					*****
	        	  // I found this code from https://www.youtube.com/watch?v=C_Y6yrkj9Sg
	        	  // I have added a few imports in order to make this work. 
	        	  Desktop d = Desktop.getDesktop();
	        	  d.browse(new URI("https://www.linkedin.com/in/tempestinis/"));
	        	  // ****					END OF BARROWED CODE					*****
	        	  //*********************************************************************
	        	 
	           }
	            else if (choice == 0)
	            {
	            	// option to quit
	                System.exit(0);
	            }
	           System.out.println(ans);
	           System.out.println();
	           
	        } while(choice != 0);
        }
        catch (Exception ex) 
        {
        	System.out.print("\nDid not enter a valid menu option");
        }
        sc.close();
    }
}

