import java.util.Scanner;

class UserLogin {
    Long mobileNumber;
    String Passowrd;
    Scanner scan = new Scanner(System.in);
    public void login(FetchInformation fi){
        System.out.println("**********************************");
        System.out.println("Login ");
        System.out.print("Enter your mobile number :");
        Long mobile = scan.nextLong();
        System.out.print("Enter Password : ");
        String pass = scan.next();
        if(!fi.mobileNum.contains(mobile)){
            System.out.println("User Don't exist ! Please Register To Continue");
            System.out.println("Select : ");
            System.out.println("1. Signup");
            System.out.println("2. Exit");
            int option3 = scan.nextInt();
            switch(option3){
                case 1 : {
                    UserRegister user = new UserRegister();
                    user.run();
                    mobileNumber=user.mobileN;
                    Passowrd=user.password;
                    break;
                }
                case 2 : {System.exit(0);break;}
            }
            
            return;
        }else if(fi.mobileNum.contains(mobile)){
            int index = fi.mobileNum.indexOf(mobile);
            if(pass.equals(fi.accountPass.get(index))){
                System.out.println("Logged in Succesfully");
                mobileNumber=mobile;
                Passowrd=pass;
            }else{
                System.out.println("Wrong password");
                System.out.print("Enter password again : ");
                pass=scan.nextLine();

                // enter and check password again
                if(pass.equals(fi.accountPass.get(index))){
                    System.out.println("Logged in Succesfully");
                }else{
                    System.out.println("Wrong password");
                    System.out.print("Enter password again : ");
                    pass=scan.nextLine();
                    
                    // Check password last time
                    if(pass.equals(fi.accountPass.get(index))){
                        System.out.println("Logged in Succesfully");
                    }else{
                        System.out.println("Wrong password");
                        System.out.println("Try again after some time");
                        System.exit(0);
                    }
                }
            }
        }
    }
}
