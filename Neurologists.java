import java.io.FileWriter;
import java.util.*;

interface Neuro extends Runnable{
    public void run();
}
class Neurologists implements Neuro{
    Scanner scan = new Scanner(System.in);
    Boolean migrane,Stroke,Neuropathy,Epilepsy;
    Long mobileNum;
    String s;


    public void run(){
        checkSymptomps();
        predictDisease();
    }

    public void checkSymptomps(){
        System.out.println("severe headache accompanied by sensitivity to light and sound, nausea, vomiting, and visual disturbances.? \n 1. Yes \n 2. No"); 
        migrane=scan.nextInt()==1?true:false;        
        System.out.println("weakness or numbness in the face, arm, or leg, especially on one side of the body, difficulty speaking, sudden confusion, trouble seeing in one or both eyes  ? \n 1. Yes \n 2. No"); 
        Stroke=scan.nextInt()==1?true:false;
        System.out.println("numbness, tingling, or burning sensations in the limbs, muscle weakness, and decreased coordination.? \n 1. Yes \n 2. No"); 
        Neuropathy=scan.nextInt()==1?true:false;
        System.out.println("ecurring seizures that can involve convulsions, loss of consciousness, confusion, and involuntary movements. ? \n 1. Yes \n 2. no");
        Epilepsy=scan.nextInt()==1?true:false;
                        
    }

    public void predictDisease(){
        try {
            FileWriter writer =new  FileWriter("MedicalRecords/"+mobileNum+".txt",true);
            if(migrane==true){
                System.out.println(Medicines.migrane());
                writer.append(Medicines.migrane()  + " as checked on " +s + "\n");
            }
            if(Epilepsy ==true){
                System.out.println(Medicines.Epilepsy());
                writer.append(Medicines.Epilepsy() + " as checked on " +s + "\n");
            }
            if(Stroke ==true){
                System.out.println(Medicines.stroke());
                writer.append(Medicines.stroke() + " as checked on " +s + "\n");
            }
            if(Neuropathy ==true){
                System.out.println(Medicines.neuropathy());
                writer.append(Medicines.neuropathy() + " as checked on " +s + "\n");
            }
            writer.close();
        } catch (Exception e) {
            System.out.println("Unable to save medical record");
        }
       
    }

    public void SetMb(long mb, String s){
        this.mobileNum=mb;
        this.s=s;
    }
}