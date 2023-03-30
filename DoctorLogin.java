import java.util.*;

class DoctorLogin {
    Map mp  = new HashMap<>();
    String hpusername;
    String pass;
    Scanner scan = new Scanner(System.in);
    DoctorLogin(){
        mp.put("hospital", "password");
    }

    public void dclogin(){
        System.out.print("Enter username :");
        hpusername=scan.next();
        System.out.print("Enter hostpital password : ");
        pass=scan.next();
        if(mp.containsKey(hpusername)){
            String keypass = (String)mp.get(hpusername);
            if(pass.equals(keypass)){
                System.out.println("**************************");
                System.out.println("Patient Detail : ");
                PatientDetail pt = new PatientDetail();
                pt.viewDetails();
                
                
            }

        }
        else{
            System.out.println("Invalid Userid and password");
        }
        System.exit(0);
    }
}
