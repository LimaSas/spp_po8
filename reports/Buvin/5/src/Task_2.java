abstract class MusicalInstrument {
    private String name;

    public MusicalInstrument(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract void play();
}

class Percussion extends MusicalInstrument {
    public Percussion(String name) {
        super(name);
    }

    @Override
    public void play() {
        System.out.println(getName() + " играет ударными");
    }
}

class Stringed extends MusicalInstrument {
    public Stringed(String name) {
        super(name);
    }

    @Override
    public void play() {
        System.out.println(getName() + " играет струнными");
    }
}

class Wind extends MusicalInstrument {
    public Wind(String name) {
        super(name);
    }

    @Override
    public void play() {
        System.out.println(getName() + " играет духовыми");
    }
}

class Orchestra {
    private MusicalInstrument[] instruments;

    public Orchestra(int size) {
        instruments = new MusicalInstrument[size];
    }

    public void addInstrument(int index, MusicalInstrument instrument) {
        instruments[index] = instrument;
    }

    public void listInstruments() {
        System.out.println("Состав оркестра:");
        for (MusicalInstrument instrument : instruments) {
            if (instrument != null) {
                instrument.play();
            }
        }
    }
}

public class Task_2 {
    public static void main(String[] args) {
        Percussion drums = new Percussion("Барабаны");
        Stringed violin = new Stringed("Скрипка");
        Wind trumpet = new Wind("Труба");

        Orchestra orchestra = new Orchestra(3);

        orchestra.addInstrument(0, drums);
        orchestra.addInstrument(1, violin);
        orchestra.addInstrument(2, trumpet);

        orchestra.listInstruments();
    }
}