import java.util.ArrayList;
import java.util.List;

interface Observer {
    void update(String message);
}

interface Subject {
    void addObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObservers(String message);
}

class Teacher implements Subject {
    private List<Observer> students;

    public Teacher() {
        this.students = new ArrayList<>();
    }

    @Override
    public void addObserver(Observer observer) {
        students.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        students.remove(observer);
    }

    @Override
    public void notifyObservers(String message) {
        for (Observer student : students) {
            student.update(message);
        }
    }

    public void checkLabWork() {
        String message = "Лабораторная работа проверена";
        notifyObservers(message);
    }
}

class Student implements Observer {
    private String name;

    public Student(String name) {
        this.name = name;
    }

    @Override
    public void update(String message) {
        System.out.println("Студент " + name + " получил уведомление: " + message);
    }
}

public class Task_1 {
    public static void main(String[] args) {
        Teacher teacher = new Teacher();

        Student student1 = new Student("Иван");
        Student student2 = new Student("Петр");

        teacher.addObserver(student1);
        teacher.addObserver(student2);

        teacher.checkLabWork();
    }
}