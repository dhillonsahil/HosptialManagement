import java.util.*;

interface DetailsOfDoctor {
    Scanner scan = new Scanner(System.in);

    public void DentistDetails();

    public void DermatologistsDetails();

    public void NeurologistsDetails();

    public void CardiologistsDetails();

    // public void selectDoctor();
    public void setDoctorDetails();

    public void checkDoctorCategoryWise();

    ArrayList dentists = new ArrayList<>();
    ArrayList dermatologits = new ArrayList<>();
    ArrayList cardiologits = new ArrayList<>();
    ArrayList neurologists = new ArrayList<>();
}

class DoctorsDetails implements DetailsOfDoctor {
    Scanner scan = new Scanner(System.in);
    ArrayList dentists = new ArrayList<>();
    ArrayList dermatologits = new ArrayList<>();
    ArrayList cardiologits = new ArrayList<>();
    ArrayList neurologists = new ArrayList<>();

    int Selection;
    String doctorName;

    // constructor
    DoctorsDetails() {
        setDoctorDetails();
    }

    public void checkDoctorCategoryWise() {
        DoctorCategory dr = new DoctorCategory();
        int categoryGet = dr.Category();
        switch (categoryGet) {
            case 1: {
                DentistDetails();
                break;
            }
            case 2: {
                DermatologistsDetails();
                break;
            }
            case 3: {
                NeurologistsDetails();
                break;
            }
            case 4: {
                CardiologistsDetails();
                break;
            }
            default: {
                System.exit(0);
            }
        }
    }

    // dentist
    public void DentistDetails() {
        System.out.println(
                "1. Dr. " + dentists.get(0) + " Age : 45 Years " + ", Experience :  23 Years " + ", Education : BDS");
        System.out.println(
                "2. Dr. " + dentists.get(1) + " Age : 28 Years " + ", Experience :  3 Years " + ", Education : MBBS,BDS");
        int userSlection = scan.nextInt();
        Selection = userSlection;
        doctorName = "" + dentists.get(userSlection - 1);

    }

    // neurologists
    public void NeurologistsDetails() {
        System.out.println(
                "1. Dr. " + neurologists.get(0) + " Age : 38 Years " + ", Experience :  13 Years " + ", Education : MD");
        System.out.println(
                "2. Dr. " + neurologists.get(1) + " Age : 36 Years " + ", Experience :  10 Years " + ", Education : MBBS, MD");
        int userSlection = scan.nextInt();
        Selection = userSlection;
        doctorName = "" + neurologists.get(userSlection - 1);
    }
    
    // CardioLogists
    public void CardiologistsDetails() {
        System.out.println(
                "1. Dr. " + cardiologits.get(0) + " Age : 50 Years " + ", Experience :  25 Years " + ", Education : DM,MBBS");
        System.out.println(
                "2. Dr. " + cardiologits.get(1) + " Age : 37 Years " + ", Experience :  14 Years " + ", Education : MBBS, BAMS");
        int userSlection = scan.nextInt();
        Selection = userSlection;
        doctorName = "" + cardiologits.get(userSlection - 1);
    }

    // Dermatologists
    public void DermatologistsDetails() {
        System.out.println(
                "1. Dr. " + dermatologits.get(0) + " Age : 40 Years " + ", Experience :  15 Years " + ", Education : MD,MBBS");
        System.out.println(
                "2. Dr. " + dermatologits.get(1) + " Age : 38 Years " + " , Experience :  16 Years " + ", Education : MBBS");
        int userSlection = scan.nextInt();
        Selection = userSlection;
        doctorName = "" + dermatologits.get(userSlection - 1);
    }

    // set data in ArrayLists
    public void setDoctorDetails() {
        dentists.add("Ajay");
        dentists.add("Naveen");
        dermatologits.add("Ojasvi");
        dermatologits.add("Mandeep");
        cardiologits.add("Sachdeva");
        cardiologits.add("Abhinay");
        neurologists.add("Abhay Kumar");
        neurologists.add("Vikas Gupta");
    }
}
