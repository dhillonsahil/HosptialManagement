import java.io.FileWriter;
import java.util.*;


interface TakeAppoint {
    public void appointment(String docname,Long h);
    public int getDate();
    public int getMonth();
    public int getYear();
}

class TakeAppointment implements TakeAppoint{
    String doctorName;
    Scanner scan = new Scanner(System.in);
    int dt,mn,yr;

        public void appointment(String docName , Long h) {
        Calendar calendar = Calendar.getInstance();
        doctorName = docName;
        calendar.setLenient(false);
        System.out.print("Enter date  ");
        dt = scan.nextInt();
        System.out.print("Enter month  ");
        mn = scan.nextInt();
        mn-=1;
        System.out.print("Enter year  : ");
        yr = scan.nextInt();
        calendar.set(Calendar.HOUR_OF_DAY , 0);
        calendar.set(Calendar.MILLISECOND , 0);
        calendar.set(Calendar.SECOND , 0);
        calendar.set(Calendar.MINUTE , 0);
        calendar.set(yr, mn, dt);
        try {
            calendar.getTime();
            System.out.println("Getting appointment on :" );
        } catch (IllegalArgumentException e) {
            System.out.println("Wrong Date ");
            System.out.print("Enter date again : ");
            dt = scan.nextInt();
            System.out.print("Enter month  again : ");
            mn = scan.nextInt();
            mn-=1;
            System.out.print("Enter year again : ");
            yr = scan.nextInt();
            calendar.setLenient(false);
            calendar.set(yr, mn, dt);
            try {
                calendar.getTime();
            } catch (Exception e2) {
                System.out.println("Again wrong date ! Start the process again");
                System.exit(0);
            }
        }

        try {
            String filepath = "Appointments/" +h.toString() + ".txt";
            FileWriter writer2 = new FileWriter(filepath, true);
            
            writer2.append("Appointment with " + docName + " on " + dt + "/"+ (mn+1) + "/" + yr + "\n");
            writer2.close();
            System.out.println("Appointment Booked");
        } catch (Exception e) {
            System.out.println("The date is invalid");
        }
    }
    public int getDate(){
        return dt;
    }
    public int getMonth(){
        return mn;
    }
    public int getYear(){
        return yr;
    }
}
