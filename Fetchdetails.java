import java.io.*;
import java.util.*;

interface FetchDetails extends Runnable{
    public void run();
}
class FetchInformation implements FetchDetails{
    Thread t;
    String threadname;
    LinkedList<Long> mobileNum = new LinkedList<>();
    LinkedList<String> accountPass = new LinkedList<>();
    
    FetchInformation(){
        
    }
    // Constructor
    FetchInformation(String threadName){
        this.threadname = threadName;
        t = new Thread(this,threadName);
    }

    public void run() {
        try {
            // Open the text file for reading using a FileReader
            File file1 = new File("AccountNumber.txt");
            File file2 = new File("AccountPasswords.txt");
            FileReader fr1 = new FileReader(file1);
            FileReader fr2 = new FileReader(file2);
            BufferedReader br2 = new BufferedReader(fr2);
            BufferedReader br1 = new BufferedReader(fr1);

            // Create a new LinkedList
            LinkedList<Long> an = new LinkedList<>();
            LinkedList<String> ap = new LinkedList<>();

            // Read each line from the text file and add it to the LinkedList
            String line;
            String line2;
            while ((line = br1.readLine()) != null) {
                line2 = br2.readLine();
                Long value = Long.parseLong(line);
                String val = (line2);
                an.add(value);
                ap.add(val);
            }

            // Close the BufferedReader and FileReader
            { br1.close();
            fr1.close();
            br2.close();
            fr2.close(); }
            
            // setting instance variables 
           { this.mobileNum=an;
            this.accountPass=ap;}
            
        } catch (Exception e) {
            System.out.println("Unable to fetch User id and Passwords");
        }
        
    }

    public final LinkedList getmobileNum(){
        return  this.mobileNum;
    }
    public final LinkedList getAccountPass(){
        return  this.accountPass;
    }
}