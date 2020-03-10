import java.util.ArrayList;

/* Ray Klump
 * This class features functions that take in an employee
 * description and extract particular fields.
 */
public class EmployeeDataParser {
	public static String getLastName(String emp) {
		return emp.substring(0,15).trim();
	}
	public static String getFirstName(String emp) {
		return emp.substring(15,30).trim();
	}
	public static double getHours(String emp) {
		String part = emp.substring(30,40).trim();
		if (part.equals("-9999")) {
			return -1; // indicates failure
		} else {
			return Double.parseDouble(part);
		}
	}
	public static double getPayRate(String emp) {
		return Double.parseDouble(emp.substring(40,emp.length()).trim());
	}
	public static String getFullName(String emp) {
		return getFirstName(emp) + " " + getLastName(emp);
	}
	public static double getGrossPay(String emp) {
		double hours = getHours(emp);
		if (hours < 0) {
			return 0;
		} else {
			return hours * getPayRate(emp);
		}
	}
}
