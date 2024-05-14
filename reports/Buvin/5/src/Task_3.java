abstract class Patient {
    protected String name;
    protected int age;
    protected String diagnosis;
    protected String condition;
    protected Doctor attendingDoctor;

    public Patient(String name, int age, String diagnosis) {
        this.name = name;
        this.age = age;
        this.diagnosis = diagnosis;
        this.condition = "In Hospital";
    }

    public void setAttendingDoctor(Doctor doctor) {
        this.attendingDoctor = doctor;
    }

    public String getName() {
        return name;
    }

    public abstract void changeCondition(String newCondition);
}

abstract class MedicalStaff {
    protected String name;
    protected String specialization;

    public MedicalStaff(String name, String specialization) {
        this.name = name;
        this.specialization = specialization;
    }
}

class Doctor extends MedicalStaff {
    public Doctor(String name, String specialization) {
        super(name, specialization);
    }

    public void prescribeTreatment(Patient patient, String treatment) {
        System.out.println(name + " prescribes " + treatment + " for patient " + patient.getName());
    }
}

class Nurse extends MedicalStaff {
    public Nurse(String name, String specialization) {
        super(name, specialization);
    }

    public void performTreatment(Patient patient, String treatment) {
        System.out.println(name + " performs " + treatment + " for patient " + patient.getName());
    }
}

public class Task_3 {
    public static void main(String[] args) {
        Doctor doctor = new Doctor("Dr. Smith", "Cardiologist");
        Patient patient = new Patient("John Doe", 45, "Heart Disease") {
            @Override
            public void changeCondition(String newCondition) {
                this.condition = newCondition;
            }
        };
        patient.setAttendingDoctor(doctor);

        doctor.prescribeTreatment(patient, "Heart medication");

        Nurse nurse = new Nurse("Nurse Jane", "Registered Nurse");
        nurse.performTreatment(patient, "Heart medication");

        patient.changeCondition("Recovered");

        System.out.println("Patient " + patient.getName() + " is " + patient.condition);
    }
}