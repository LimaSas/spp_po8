import java.util.ArrayList;
import java.util.List;

public class Task_3 {
    public static class Patient {
        private String name;
        private int age;
        private String diagnosis;
        private String condition;
        private Doctor attendingDoctor;

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

        public void changeCondition(String newCondition) {
            this.condition = newCondition;
        }
    }

    public static class Doctor {
        private String name;
        private String specialization;

        public Doctor(String name, String specialization) {
            this.name = name;
            this.specialization = specialization;
        }

        public void prescribeTreatment(Patient patient, String treatment) {
            System.out.println(name + " prescribes " + treatment + " for patient " + patient.getName());
        }
    }

    public static class Nurse {
        private String name;
        private String specialization;

        public Nurse(String name, String specialization) {
            this.name = name;
            this.specialization = specialization;
        }

        public void performTreatment(Patient patient, String treatment) {
            System.out.println(name + " performs " + treatment + " for patient " + patient.getName());
        }
    }

    public static void main(String[] args) {
        Doctor doctor = new Doctor("Dr. Smith", "Cardiologist");
        Patient patient = new Patient("John Doe", 45, "Heart Disease");
        patient.setAttendingDoctor(doctor);

        doctor.prescribeTreatment(patient, "Heart medication");

        Nurse nurse = new Nurse("Nurse Jane", "Registered Nurse");
        nurse.performTreatment(patient, "Heart medication");

        patient.changeCondition("Recovered");

        System.out.println("Patient " + patient.getName() + " is " + patient.condition);
    }
}