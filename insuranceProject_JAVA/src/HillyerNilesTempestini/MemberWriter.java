package HillyerNilesTempestini;
import java.io.*;
import java.util.*;
import java.beans.*;


public class MemberWriter implements Serializable{

    public static void writeMembersToScreen(ArrayList<Member> members) {
        for (Member m : members) {
            System.out.println(m);
        }
    }
    public static boolean writeTextFile(ArrayList<Member> members, String filename) {
        try {
            PrintWriter pw = new PrintWriter(new BufferedWriter(
                new FileWriter(new File(filename))));
            for (Member m: members) {
                pw.println(m);
            }
            pw.close();
            return true;
        } catch (Exception ex) {
            return false;
        }
    }
    public static boolean writeBinaryFile(ArrayList<Member> members, String filename) throws IOException {
        try {
            ObjectOutputStream oos = new ObjectOutputStream(
                new FileOutputStream(new File(filename)));
            oos.writeObject(members);
            oos.close();
            return true;
        } catch(Exception ex) {
            return false;
        }
    }
    public static boolean writeXmlFile(ArrayList<Member> members, String filename) {
        try {
            XMLEncoder xml = new XMLEncoder(new BufferedOutputStream(
                new FileOutputStream(filename)));
            xml.writeObject(members);
            xml.close();
            return true;
        } catch (Exception ex) {
            return false;
        }
    }
}

