
import java.util.Scanner;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;

public class ArrayListDemo {
	   public static void printContents(ArrayList<String> strings) {
	        for (String str : strings) {
	            System.out.println(str);
	        }
	    }
	    public static void main(String[] args) {
	       String fname;
	       Scanner sc = new Scanner(System.in);
	       System.out.print("Enter name of file: ");
	       fname = sc.nextLine();
	       // file name
	       // C:\Windows\Temp\sample.txt
	       File f = new File(fname);
	        
	        String line;
	        ArrayList<String> lines = new ArrayList<String>();
	        try {
	            Scanner fsc = new Scanner(f);
	            while (fsc.hasNextLine()) {
	                line = fsc.nextLine().trim();
	                lines.add(line);
	            }
	            fsc.close();
	            System.out.println("Now going to print ...");
	            printContents(lines);
	            System.out.println("Now sorted ...");
	            Collections.sort(lines);
	            printContents(lines);
	        } catch (Exception ex) {
	            System.out.println("Couldn't read file.");
	        }
	    }
	    sc.close();
}
