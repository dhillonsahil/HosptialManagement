import java.io.*;
import java.util.*;

interface Registration extends Runnable {
    public void run();
}

class UserRegister implements Registration {

    LinkedList<Long> mobileNum = new LinkedList<>();
    LinkedList<String> accountPass = new LinkedList<>();
    String password;
    Long mobileN;

    Scanner scan = new Scanner(System.in);

    public void run() {
        try {
            FetchInformation fi = new FetchInformation("registerThread");
            fi.t.start();
            try {
            fi.t.join();
            } catch (Exception e) {
                System.out.println("Oops Register Error");
            }
            mobileNum=fi.mobileNum;
            accountPass=fi.accountPass;
            FileWriter writer = new FileWriter("AccountNumber.txt" , true);
            FileWriter writer2 = new FileWriter("AccountPasswords.txt" , true);
            
            // asking details
            
            System.out.print("Enter mobile number : ");
            Long mobile = scan.nextLong();

            // check mobile number in database
            while(mobileNum.contains(mobile)){
                Boolean tr = false;
                System.out.println("Mobile number already Exist ! Use New Number or Login ");
                System.out.println("1. Use New Number ");
                System.out.println("2. Login ");
                int option2 = scan.nextInt();
                switch(option2){
                    case 1 :{mobile=scan.nextLong();break;}
                    case 2 : {UserLogin ul = new UserLogin();
                        ul.login(fi);tr=true; break;
                    }
                    default : {System.out.println("Wrong Input ! Exiting System");System.exit(0);break;}
                }
                if(tr=true){
                    break;
                }
            }

            // input password
            System.out.print("Enter password : ");
            String pass = scan.next();
            PatientDetail pd = new PatientDetail();
            pd.Set(mobile);
            pd.saveDetail();
            mobileNum.add(mobile);
            accountPass.add(pass);
            // saving files and closing writers
            writer.append(mobile + "\n");
            writer2.append(pass + "\n");
            writer.close();
            writer2.close();
            this.mobileN=mobile;
            this.password=pass;
        } 
        catch (IOException e) 
        {
            System.out.println("Unable to Signup ");
        }
        System.out.println("Registered Succesfully ");
        System.out.println("You can now Login");
        // System.exit(0);
        System.out.println("***********************************");
    }

    public Long getLp(){
        return mobileN;
    }
}
