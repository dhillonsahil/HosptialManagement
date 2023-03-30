import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

class PatientDetail {
    String name;int age;
    Scanner scan = new Scanner(System.in);
    Long mobile;
    
    public void saveDetail(){
        System.out.print("Enter your name : ");
        name=scan.nextLine();
        System.out.println("Enter your age : ");
        age = scan.nextInt();
        try {
            FileWriter writer = new FileWriter("PatientDetails/"+mobile+".txt",true);
            writer.write("Name : "+name + ","+"Age : "+age +", Mobile Number : "+mobile + "\n");
            writer.close();
        } catch (Exception e) {
            
        }
    } 

    public void Set(Long mb){
        this.mobile=mb;
    }

    public void viewDetails(){
        System.out.println("Enter patient's phone number");
        Long mob = scan.nextLong();
        mobile=mob;
        try {
            File file = new File("PatientDetails/"+mob+".txt");
            File file1 = new File("MedicalRecords/"+mob+".txt");
            File file2 = new File("Appointments/"+mob+".txt");
            if(file.exists()){
                Scanner scan = new Scanner(file);
                while(scan.hasNextLine()){
                    System.out.println(scan.nextLine());
                }
                scan.close();
                if(file1.exists()){
                    Scanner sc= new Scanner(file1);
                    while(sc.hasNextLine()){
                        System.out.println(sc.nextLine());
                    }
                    sc.close();
                }
                System.out.println();
                System.out.println("Appointments :");
                if(file2.exists()){
                    Scanner sc= new Scanner(file2);
                    while(sc.hasNextLine()){
                        System.out.println(sc.nextLine());
                    }
                    sc.close();
                }else{
                    System.out.println("No Previous Appointment found");
                }
            }else{
                System.out.println("File don't exist");
                System.exit(0);
            }
        } catch (Exception e) {
            System.out.println("Unable to check patient details");
        }
    }

}
