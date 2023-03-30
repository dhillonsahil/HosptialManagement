import java.io.FileWriter;
import java.util.*;

interface cardio extends Runnable{
    public void run();
}
public class Cardiologists implements cardio{
    Scanner scan = new Scanner(System.in);
    Boolean heartAttack,arrhythmias,hypertension ,cardiomyopathy;
    Long mobileNum;
    String s;


    public void SetMb( String s){
        this.mobileNum=HomePage.getMobileHome();
        this.s=s;
    }
    public void run(){
        checkSymptomps();
        predictDisease();
    }
    public void checkSymptomps(){
        System.out.println("chest pain or discomfort (angina) that can spread to the arms, neck, jaw, or back, shortness of breath, sweating, nausea or vomiting, and sometimes, dizziness or fainting. \n 1. Yes \n 2. No"); 
        heartAttack=scan.nextInt()==1?true:false;        
        System.out.println("irregular heartbeats that can cause palpitations (a feeling of fluttering or racing in the chest), chest pain or discomfort, shortness of breath, and sometimes, fainting or lightheadedness. ? \n 1. Yes \n 2. No"); 
        arrhythmias=scan.nextInt()==1?true:false;
        System.out.println("High blood pressure often has no symptoms, but in severe cases, can cause headaches, shortness of breath, nosebleeds, and chest pain..? \n 1. Yes \n 2. No"); 
        hypertension =scan.nextInt()==1?true:false;
        System.out.println("hortness of breath, fatigue, swelling of the legs, ankles, or feet, irregular heartbeat, and sometimes, chest pain or discomfort. \n 1. Yes \n 2. no");
        cardiomyopathy=scan.nextInt()==1?true:false;
                        
    }

    public void predictDisease(){
        try {
            FileWriter writer =new  FileWriter("MedicalRecords/"+mobileNum+".txt",true);
            if(heartAttack==true){
                System.out.println(Medicines.heartAttck());
                writer.append(Medicines.heartAttck()  + " as checked on " +s + "\n");
            }
            if(arrhythmias ==true){
                System.out.println(Medicines.arrhythmias());
                writer.append(Medicines.arrhythmias() + " as checked on " +s + "\n");
            }
            if(hypertension ==true){
                System.out.println(Medicines.hypertension());
                writer.append(Medicines.hypertension() + " as checked on " +s + "\n");
            }
            if(cardiomyopathy ==true){
                System.out.println(Medicines.cardiomyopathy());
                writer.append(Medicines.cardiomyopathy() + " as checked on " +s + "\n");
            }
            writer.close();
        } catch (Exception e) {
            System.out.println("Unable to save medical record");
        }
       
    }
}