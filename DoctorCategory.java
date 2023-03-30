import java.util.*;

interface DC extends Runnable{
    public void run();
    public int Category();
}
class DoctorCategory implements DC{
    Scanner scan = new Scanner(System.in);
    String docName;
    Long mb;

    public void run(){
        // mb = HomePage.MobileHome;
        int option5 = Category();
        TakeAppointment tc = new TakeAppointment();
        Calendar calendar = Calendar.getInstance();

        // to check date is for today or not
        calendar.set(Calendar.HOUR_OF_DAY , 0);
        calendar.set(Calendar.MILLISECOND , 0);
        calendar.set(Calendar.SECOND , 0);
        calendar.set(Calendar.MINUTE , 0);
        int TodayYear = calendar.get(calendar.YEAR);
        int TodayMonth = calendar.get(calendar.MONTH);
        int TodayDate = calendar.get(calendar.DATE);
        boolean check;
        
        DoctorsDetails dr = new DoctorsDetails();
        
        // booking appointment and treatment
        switch(option5){
            case 1: {
                // dentist
                dr.DentistDetails();
                tc.appointment(dr.doctorName , mb);
                int checkDate = tc.getDate();
                int checkMonth = tc.getMonth();
                int checkYear = tc.getYear();
                CheckDate ck = new CheckDate();

                // checking is this of today if Yes meet doctor
                check = ck.check(checkDate, checkMonth, checkYear, TodayDate, TodayMonth, TodayYear);
                if(check==true){
                    System.out.println("*************************************");
                    System.out.println("Tell Doctor About Symptoms");
                    Dentist dentist = new Dentist();
                    dentist.SetMb((checkDate+"/"+checkMonth+"/"+checkYear));
                    Thread thDent = new Thread(dentist);
                    thDent.start();
                    try{
                        thDent.join();
                    }catch(Exception e){
                        System.out.println("Error Calling Dentist");
                    }
                }break;
            }
            case 2 :{
                // dermatologists. java make file pending (only dentist done)
                dr.DermatologistsDetails();
                tc.appointment(dr.doctorName , mb);
                int checkDate = tc.getDate();
                int checkMonth = tc.getMonth();
                int checkYear = tc.getYear();
                CheckDate ck = new CheckDate();
                tc.setL(mb);
                check = ck.check(checkDate, checkMonth, checkYear, TodayDate, TodayMonth, TodayYear);
                if(check==true){
                    System.out.println("*************************************");
                    System.out.println("Tell Doctor About Symptoms");
                    Dermatologists dermatologists = new Dermatologists();
                    dermatologists.SetMb(checkDate+"/"+checkMonth+"/"+checkYear);
                    Thread th = new Thread(dermatologists);
                    th.start();
                    try{
                        th.join();
                    }catch(Exception e){
                        System.out.println("Error Calling Dermatologists");
                    }
                }
                
                break;
            }
            case 3 : {
                //neurologist
                dr.NeurologistsDetails();
                tc.appointment(dr.doctorName , mb);
                int checkDate = tc.getDate();
                int checkMonth = tc.getMonth();
                int checkYear = tc.getYear();
                CheckDate ck = new CheckDate();
                check = ck.check(checkDate, checkMonth, checkYear, TodayDate, TodayMonth, TodayYear);
                if(check==true){
                    System.out.println("*************************************");
                    System.out.println("Tell Doctor About Symptoms");
                    Neurologists neuro = new Neurologists();
                    neuro.SetMb( checkDate+"/"+checkMonth+"/"+checkYear);
                    Thread th = new Thread(neuro);
                    th.start();
                    try{
                        th.join();
                    }catch(Exception e){
                        System.out.println("Error Calling Neurologists");
                    }
                }
                break;
            }
            case 4 : {
                // cardiologists
                dr.CardiologistsDetails();
                tc.appointment(dr.doctorName , mb);
                int checkDate = tc.getDate();
                int checkMonth = tc.getMonth();
                int checkYear = tc.getYear();
                CheckDate ck = new CheckDate();
                check = ck.check(checkDate, checkMonth, checkYear, TodayDate, TodayMonth, TodayYear);
                if(check==true){
                    System.out.println("*************************************");
                    System.out.println("Tell Doctor About Symptoms");
                    Cardiologists cardiologist = new Cardiologists();
                    cardiologist.SetMb( checkDate+"/"+checkMonth+"/"+checkYear);
                    Thread th = new Thread(cardiologist);
                    th.start();
                    try{
                        th.join();
                    }catch(Exception e){
                        System.out.println("Error Calling Cardiologists");
                    }
                }
                break;
            }
            default :{
                System.exit(0);
                break;
            }
            
        }
    }

    public int Category(){
        System.out.println("**************************************");
        System.out.println();
        System.out.println("1. Dentist");
        System.out.println("2. Dermatologists");
        System.out.println("3. Neurologists");
        System.out.println("4. Cardiologists");
        System.out.println("Any other key to exit");
        System.out.println();
        System.out.println("**************************************");
        int option4 = scan.nextInt();
        return option4;
    }
}
