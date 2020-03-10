/*
  	Author: 	Sam Tempestini
	Teacher: 	Raymond Klump
	Course:		CPSC 24500-004
 	Date:		10/22/2019
 	Descr:		This is a menu driven program that used a linked hashedmap
 */
/**
 * 
 * @author Sam Tempestini
 * 
 */
import java.io.FileNotFoundException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;


public class TempestiniPizzaHuntApp
{
	public static void showWelcome()
	{
		System.out.println("********************************************************************");
		System.out.println("**** 				Pizza Hunt 			****");
		System.out.println("**** 	You are a bear. Do what bears do. Hunt pizza.		****");
		System.out.println("********************************************************************");
	}
	
	public static void showMenu()
	{
		System.out.println("Here are your choices: ");
		System.out.println("1. Hunt for pizza.");
		System.out.println("2. Print the maze.");
		System.out.println("3. Hibernate.");
	}
	
	public static void main(String[] args) throws FileNotFoundException 
	{
		// TODO Auto-generated method stub
		showWelcome();
		int choice = 0;
		// C:\Users\Sam Tempestini\Desktop\rooms_pizza_hunt.txt
		ArrayList<Room> read = new ArrayList<Room>();
		read = RoomReader.readRooms();
		ArrayList<Room> mapped = new ArrayList<Room>();
		mapped = GameManager.createMap(read);
		Scanner sc = new Scanner(System.in);
		
		do {
			showMenu();
			try {
				System.out.print("\nEnter your selection: ");
				choice = sc.nextInt();
				Scanner in = new Scanner(System.in);
				if (choice == 1)
				{
					GameManager.start(mapped);
				}
				else if (choice == 2)
				{
					//System.out.println("Here is a list of all rooms: ");
					//PrintRooms.printRoomFormat(read);
					
					// Prints to map to the user on selection
					PrintRooms.printMappedRooms(mapped);					
				}
				else if (choice == 3)
				{
					System.out.println("We hope you had fun and had enough pizza "
							+ "Please don't come near me though. I couldn't bear it! \nHe he, get it?");
				}
				
			}catch(Exception ex)
			{ 
				System.out.println("You have chosen poorly...Exiting Program");
				System.exit(1);
				sc.close();
			}	
		}while(choice != 3);
		System.exit(0);

	}

}
