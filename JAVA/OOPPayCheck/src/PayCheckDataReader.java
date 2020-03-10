import java.util.ArrayList;
import java.io.File;
import java.util.Scanner;
public class PayCheckDataReader {
	public static ArrayList<String> readPayCheckData(String fname) {
		ArrayList<String> employees = new ArrayList<String>();
		try {
			Scanner fsc = new Scanner(new File(fname));
			fsc.nextLine();
			fsc.nextLine(); // read and throw out the 2 header lines
			String line;
			while (fsc.hasNextLine()) {
				line = fsc.nextLine().trim();
				if (line.length() > 0) {
					employees.add(line);
				}
			}
			fsc.close();
			return employees;
		} catch (Exception ex) {
			return null;
		}		
	}
}
