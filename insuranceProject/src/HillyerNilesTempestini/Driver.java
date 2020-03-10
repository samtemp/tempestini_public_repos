package HillyerNilesTempestini;
import java.util.*;
import java.io.*;
import java.beans.*;

/**
 * 
 * @author Sam Tempestini
 * @author Cheasea Niles
 * @author Chris Hillyer
 *
 */
// testing 123 

public class Driver implements Serializable{
	/**
	 * @author Sam Tempestini
	 * @param none
	 * @return void
	 */
	public static void welcome()
	{
		System.out.println("****************************************************");
		System.out.println("\n\t\tINSURANCE SCORE CARD");
		System.out.println("\tThis app scores a potential customer");
		System.out.println("\ton various health attributes: blood");
		System.out.println("\tpressure, age, height, weight, and");
		System.out.println("\tfamily history of disease. It writes");
		System.out.println("\teach member's insurance grade to a");
		System.out.println("\tJSON file so that they can be easily");
		System.out.println("\tshared on a web-based data exchange.\n");
		System.out.println("****************************************************");
	}
	/**
	 * @author Sam Tempestini
	 * @param none
	 * @return void
	 */
	public static void showMenu()
	{
		System.out.println("Here are your choices: ");
		System.out.println("\t1. List members");
		System.out.println("\t2. Add a new member");
		System.out.println("\t3. Save members");
		System.out.println("\t4. Load members");
		System.out.println("\t5. Assess members");
		System.out.println("\t6. Save assessments as JSON");
		System.out.println("\t7. Exit");
	}
	public static void main(String[] args) throws FileNotFoundException, IOException {
		// TODO Auto-generated method stub
		//C:\Users\Sam Tempestini\Desktop\memberData.txt
		int choice = 0;
		String ftype = null, outputFname = null,  inputFname = null;
		ArrayList<Member> members = new ArrayList<Member>();
		ArrayList<Member> txtMembers = new ArrayList<Member>();
		ArrayList<Member> binMembers = new ArrayList<Member>();
		ArrayList<Member> xmlMembers = new ArrayList<Member>();
		
		
		welcome();
		
		String fname;
		Scanner fsc = new Scanner(System.in);
		System.out.print("Enter name of file: "); 
		fname = fsc.nextLine();
		members = MemberReader.readTextFile(fname);
	
		
		Scanner sc = new Scanner(System.in);
		do {
			showMenu();
			try {
				System.out.print("\nEnter your selection: ");
				choice = sc.nextInt();
				
				if (choice == 1)
				{
					for (Member m: members)
					{
						System.out.println(m.toString());
						System.out.println("-----------------------------");
					}
				}
				else if(choice == 2)
				{
					
				}
				else if(choice == 3) 
				{
				
					
				}
				else if(choice == 4) 
				{
					
					
				}
				else if(choice == 5) 
				{
					
				}
				else if(choice == 6) 
				{
					
				}
				else if(choice == 7) 
				{
					
				}				
			}catch(Exception ex)
			{
				System.out.println("You have chosen poorly...Exiting Program");
				System.exit(1);
				sc.close();
			}
		}while(choice != 7);
		System.out.println("You have chosen wisely...Good bye!");
		sc.close();
		System.exit(0);
	}
}

   
    
    
    
    
    
    




