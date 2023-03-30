import java.util.*;

import javax.print.Doc;

public class HomePage {
    static LinkedList<Long> mobileNum = new LinkedList<>();
    static LinkedList<String> accountPass = new LinkedList<>();
    static Scanner scan = new Scanner(System.in);

    static Long MobileHome;

     public static Long getMobileHome(){
        return MobileHome;
    }
    public static void main(String[] args) {

        // Fetching login details
        FetchInformation fd = new FetchInformation("fetchDetails");
        fd.t.start();
        try {
            fd.t.join();
        } catch (Exception e) {
            System.out.println("Error 404 ! Unable to Fetch Details");
        }
        mobileNum = fd.getmobileNum();
        accountPass = fd.getAccountPass();

        // Register or Login option ask
        System.out.println("*****************************************");
        System.out.println("Welcome To Dhillon Hospital");
        System.out.println();
        System.out.println("1. User Register");
        System.out.println("2. User Login");
        System.out.println("3. Doctor Login");
            int a = scan.nextInt();
       
        // logining in or regitering
        switch (a) {
            case 1: {
                // registering
                UserRegister ur = new UserRegister();
                Thread tr = new Thread(ur);
                tr.start();

                try {
                    tr.join();
                } catch (Exception e) {
                    System.out.println("Error 404 ! 2");
                }
                mobileNum = ur.mobileNum;
                accountPass = ur.accountPass;
                break;
            }
            case 2: {
                UserLogin user = new UserLogin();
                user.login(fd);
                MobileHome = user.mobileNumber;

                // Fetching latest mobile Number and password list
                FetchInformation fr = new FetchInformation("fetchDetails");
                fr.t.start();
                try {
                    fr.t.join();
                } catch (Exception e) {
                    System.out.println("Error 404 ! Unable to Fetch Latest Details");
                }
                mobileNum = fd.getmobileNum();
                accountPass = fd.getAccountPass();
                break;
            }
            case 3 : {
                DoctorLogin dl = new DoctorLogin();
                dl.dclogin();
                break;
            }
            default : {
                System.out.println("Invalid option ");
                System.exit(0);
            }
        }


        // view doctors and book appoitnment
        System.out.println("********************************");
        System.out.println("1. Book Appointment ");
        System.out.println("2. View Doctors");
        int option6 = scan.nextInt();
        switch(option6){
            case 1 : {
                DoctorCategory dc = new DoctorCategory();
                Thread Thdc = new Thread(dc);
                Thdc.start();
                break;
            }
            case 2:{
              // doctor details here  
              DoctorsDetails dd = new DoctorsDetails();
              dd.checkDoctorCategoryWise();
              break;
            }
            default :{
                System.out.println("Don't time pass here you don't want to Check Doctors or Book Appoinment ");
            }
        }

        
        
    }

    public static LinkedList getMob(){
        return mobileNum;
    }
}
