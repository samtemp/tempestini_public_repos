import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.io.BufferedWriter;
import java.io.FileWriter;

public class TleetWriter {
	public static void printTleetsToScreen(ArrayList<Tleet> tlts) {
        for (Tleet tlt : tlts) {
            System.out.println(tlt.toString());
        }
    }
    public static boolean printTleetsToTextFile(ArrayList<Tleet> tlts,
    String fname) {
        File f = new File(fname);
        return printTleetsToTextFile(tlts, f);
    }
    public static boolean printTleetsToTextFile(ArrayList<Tleet> tlts,
    File file) {
        try {
            PrintWriter pw = new PrintWriter(new BufferedWriter(
                    new FileWriter(file)));
            for (Tleet tlt : tlts) {
                pw.println(tlt);
            }
            pw.close();
            return true;
        } catch (Exception ex) {
            return false;
        }
    }
 
}
