interface Employee {
    void work();
}

class Engineer implements Employee {
    @Override
    public void work() {
        System.out.println("Инженер работает");
    }
}

class Manager implements Employee {
    @Override
    public void work() {
        System.out.println("Руководитель работает");
    }
}

public class Task_1 {
    public static void main(String[] args) {
        Engineer engineer = new Engineer();
        Manager manager = new Manager();

        Employee emp1 = engineer;
        Employee emp2 = manager;

        emp1.work();
        emp2.work();
    }
}