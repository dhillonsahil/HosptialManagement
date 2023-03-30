import java.io.FileWriter;
import java.util.Scanner;

interface Dent extends Runnable{
    public void run();
    void checkSymptomps();
}

class Dentist implements Dent {
    Scanner scan = new Scanner(System.in);
    Long mobileNum;
    boolean sensitivity,dryMouth,swollenGums,holesInTeeth , toothAche;
    String s;

    public void run(){
        checkSymptomps();
        predictDisease();
    }
    public void checkSymptomps(){
        System.out.println("Treatment Started");
        System.out.println("Do you feel pain when biting ");
        System.out.println("1. Yes / 2. No ");
        toothAche = scan.nextInt()==1?true:false;
        System.out.println("Visible Holes or pits in teeth");
        System.out.println("1. Yes / 2. No ");
        holesInTeeth = scan.nextInt()==1?true:false;
        System.out.println("Swollen , red Gums / Bleefding in gum");
        System.out.println("1. Yes / 2. No ");
        swollenGums = scan.nextInt()==1?true:false;
        System.out.println("Sensitivity");
        System.out.println("1. Yes / 2. No ");
        sensitivity = scan.nextInt()==1?true:false;
        System.out.println("Dry Mouth");
        System.out.println("1. Yes / 2. No ");
        dryMouth = scan.nextInt()==1?true:false;
    }
    private void predictDisease(){

        try {
            FileWriter writer =new  FileWriter("MedicalRecords/"+mobileNum+".txt",true);
            if(toothAche==true && holesInTeeth==true){
                System.out.println(Medicines.toothDecay());
                writer.append(Medicines.toothDecay() + " as checked on " +s + "\n");
            }
            if(swollenGums==true){
                System.out.println(Medicines.swollenGums());
                writer.append(Medicines.swollenGums()  + " as checked on " +s + "\n");
            }
            if(sensitivity==true){
                System.out.println(Medicines.sensitivity() );
                writer.append(Medicines.sensitivity()  + " as checked on " +s + "\n");
            }
            if(dryMouth==true){
                System.out.println(Medicines.dryMouth());
                writer.append(Medicines.dryMouth()  + " as checked on " +s + "n");
            }
            writer.close();
        } catch (Exception e) {
           System.out.println("Unable to save record ");
        }
       
       
        
        
    }

    public void SetMb(long mb , String s){
        this.mobileNum=mb;
        this.s=s;
    }
}
