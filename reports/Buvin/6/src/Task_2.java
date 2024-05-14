interface CarFactory {
    Car createCar();
    RemoteControl createRemoteControl();
}

interface Car {
    void start();
    void stop();
    void lockDoors();
    void unlockDoors();
    void activateAlarm();
}

interface RemoteControl {
    void activateAlarm();
    void unlockDoors();
    void startEngine();
}

class BMWFactory implements CarFactory {
    @Override
    public Car createCar() {
        return new BMWCar();
    }

    @Override
    public RemoteControl createRemoteControl() {
        return new BMWRemoteControl();
    }
}

class AudiFactory implements CarFactory {
    @Override
    public Car createCar() {
        return new AudiCar();
    }

    @Override
    public RemoteControl createRemoteControl() {
        return new AudiRemoteControl();
    }
}

class BMWCar implements Car {
    @Override
    public void start() {
        System.out.println("BMW: Двигатель запущен");
    }

    @Override
    public void stop() {
        System.out.println("BMW: Двигатель остановлен");
    }

    @Override
    public void lockDoors() {
        System.out.println("BMW: Двери заперты");
    }

    @Override
    public void unlockDoors() {
        System.out.println("BMW: Двери разблокированы");
    }

    @Override
    public void activateAlarm() {
        System.out.println("BMW: Сигнализация активирована");
    }
}

class AudiCar implements Car {
    @Override
    public void start() {
        System.out.println("Audi: Двигатель запущен");
    }

    @Override
    public void stop() {
        System.out.println("Audi: Двигатель остановлен");
    }

    @Override
    public void lockDoors() {
        System.out.println("Audi: Двери заперты");
    }

    @Override
    public void unlockDoors() {
        System.out.println("Audi: Двери разблокированы");
    }

    @Override
    public void activateAlarm() {
        System.out.println("Audi: Сигнализация активирована");
    }
}

class BMWRemoteControl implements RemoteControl {
    @Override
    public void activateAlarm() {
        System.out.println("BMW Remote Control: Активация сигнализации");
    }

    @Override
    public void unlockDoors() {
        System.out.println("BMW Remote Control: Разблокировка дверей");
    }

    @Override
    public void startEngine() {
        System.out.println("BMW Remote Control: Запуск двигателя");
    }
}

class AudiRemoteControl implements RemoteControl {
    @Override
    public void activateAlarm() {
        System.out.println("Audi Remote Control: Активация сигнализации");
    }

    @Override
    public void unlockDoors() {
        System.out.println("Audi Remote Control: Разблокировка дверей");
    }

    @Override
    public void startEngine() {
        System.out.println("Audi Remote Control: Запуск двигателя");
    }
}

public class Task_2 {
    public static void main(String[] args) {
        CarFactory bmwFactory = new BMWFactory();
        Car bmwCar = bmwFactory.createCar();
        RemoteControl bmwRemote = bmwFactory.createRemoteControl();

        CarFactory audiFactory = new AudiFactory();
        Car audiCar = audiFactory.createCar();
        RemoteControl audiRemote = audiFactory.createRemoteControl();

        bmwRemote.activateAlarm();
        bmwRemote.unlockDoors();
        bmwRemote.startEngine();

        audiRemote.activateAlarm();
        audiRemote.unlockDoors();
        audiRemote.startEngine();
    }
}