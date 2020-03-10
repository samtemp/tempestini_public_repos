/*
 * Ray Klump
 * Processes pay check information from a file.
 * The file has the following format.
 * columns 0 through 14 - lastname
 * columns 15 through 29 - firstname
 * columns 30 through 39 - hours
 * columns 40 through 49 - rate
 * The first two lines should be skipped because
 * they contain header information.
 */
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
public class PayCheckProcessor {
	public static void printStars(int howMany) {
		String stars = "";
		for (int i = 0; i < howMany; i++) {
			stars = stars + "*";
		}
		System.out.println(stars);
	}
	public static void printWelcome() {
		printStars(50);
		System.out.println("Welcome to Paycheck Calculator v1.0");
		System.out.println("This processes a file of pay data.");
		printStars(50);
	}
	public static void printEmployees(ArrayList<String> employees) {
		for (String emp : employees) {
			System.out.println(emp);
		}
	}
	public static void showMenu() {
		System.out.println("Here are your options: ");
		System.out.println("1. Print full pay report");
		System.out.println("2. Find total hours worked");
		System.out.println("3. Find highest paid employee");
		System.out.println("4. Find average hours worked");
		System.out.println("5. Exit");
		System.out.print("Enter the number of your choice: ");
	}
	public static double getTotalHoursWorked(ArrayList<String> employees) {
		double total = 0;
		double hoursWorked;
		for (String emp : employees) {
			hoursWorked = EmployeeDataParser.getHours(emp);
			if (hoursWorked >= 0) {
				total = total + hoursWorked;
			}
		}
		return total;
	}
	public static double getAverageHoursWorked(ArrayList<String> employees) {
		double hoursWorked;
		double total = 0;
		int count = 0; // the number of employees contributing to avg
		for (String emp : employees) {
			hoursWorked = EmployeeDataParser.getHours(emp);
			if (hoursWorked >= 0) {
				total = total + hoursWorked;
				count = count + 1; // one more contributing employee
			}
		}
		return total / count;
	}
	public static void printFullPayReport(ArrayList<String> employees) {
		for (String emp : employees) {
			System.out.printf("%-32s $%.2f\n", EmployeeDataParser.getFullName(emp), 
					EmployeeDataParser.getGrossPay(emp));
		}
	}
	/* this function returns the full name of the person who earned
	 * the most.
	 */
	public static String getHighestPaidEmployee(ArrayList<String> employees) {
		double maxPay = EmployeeDataParser.getGrossPay(employees.get(0));
		int index = 0; // number of the slot of highest paid employee
		double pay;
		for (int i = 1; i < employees.size(); i++) {
			pay = EmployeeDataParser.getGrossPay(employees.get(i));
			if (pay > maxPay) {
				maxPay = pay;
				index = i;
			}
		}
		return EmployeeDataParser.getFullName(employees.get(index));
	}
	public static void main(String[] args) {
		printWelcome();
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the name of the data file: ");
		String fname = sc.nextLine();
		ArrayList<String> employees = PayCheckDataReader.readPayCheckData(fname);
		int choice;
		double totalHours, averageHours;
		String fatCat; // name of highest paid employee;
		if (employees == null) {
			System.out.println("Something catastrophic occurred.");
			System.out.println("The program must now quit.");
		} else {
//			printEmployees(employees);
			do {
				showMenu();
				choice = sc.nextInt();
				if (choice == 1) {
					// print full pay report
					printFullPayReport(employees);
				} else if (choice == 2) {
					// find total hours worked
					totalHours = getTotalHoursWorked(employees);
					System.out.printf("Total hours = %.2f\n", 
							totalHours);
				} else if (choice == 3) {
					fatCat = getHighestPaidEmployee(employees);
					System.out.printf("The highest paid was %s.\n", fatCat);
				} else if (choice == 4) {
					// find average hours worked
					averageHours = getAverageHoursWorked(employees);
					System.out.printf("Avg hours worked = %.2f\n",
							averageHours);
					
				}
			} while (choice != 5);
			System.out.println("Thank you for using this program.");
		}
	}
}
