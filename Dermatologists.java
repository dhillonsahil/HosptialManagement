import java.io.FileWriter;
import java.util.*;

interface Derma extends Runnable{
    public void run();
}

class Dermatologists implements Derma{
    Scanner scan = new Scanner(System.in);
    Boolean acne,redness,itching,blackMarks;
    Long mobileNum;
    String s;

    public void run(){
        checkSymptomps();
        predictDisease();
    }
    public void checkSymptomps(){
        System.out.println("Do you have acne ? \n 1. Yes \n 2. No"); 
        acne=scan.nextInt()==1?true:false;        
        System.out.println("Is skin getting red ? \n 1. Yes \n 2. No"); 
        redness=scan.nextInt()==1?true:false;
        System.out.println("Any icthing there? \n 1. Yes \n 2. No"); 
        itching=scan.nextInt()==1?true:false;
        System.out.println("Any black Marks ? \n 1. Yes \n 2. no");
        blackMarks=scan.nextInt()==1?true:false;
                        
    }

    public void SetMb( String s){
        this.mobileNum=HomePage.getMobileHome();
        this.s=s;
    }
    public void predictDisease(){
        try {
            FileWriter writer =new  FileWriter("MedicalRecords/"+mobileNum+".txt",true);
            if(blackMarks==true || acne == true ){
                System.out.println(Medicines.acne());
                writer.append(Medicines.acne()  + " as checked on " +s + "\n");
            }
            if(itching ==true && redness == true ){
                System.out.println(Medicines.allergy());
                writer.append(Medicines.allergy() + " as checked on " +s + "\n");
            }
            writer.close();
        } catch (Exception e) {
            System.out.println("Unable to save medical record");
        }
       
    }
    
}
