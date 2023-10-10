// Интерфейс для устройства с напряжением 220V
interface Device220V {
    void charge220V();
}

// Реализация устройства с напряжением 220V
class Device220VImpl implements Device220V {
    @Override
    public void charge220V() {
        System.out.println("Зарядное устройство 220V заряжает устройство.");
    }
}

// Класс, представляющий напряжение 380V
class Voltage380V {
    public void provide380V() {
        System.out.println("Предоставление напряжения 380V.");
    }
}

// Адаптер для зарядного устройства 220V, позволяющий использовать напряжение 380V
class Adapter380VTo220V implements Device220V {
    private Voltage380V voltage380V;

    public Adapter380VTo220V(Voltage380V voltage380V) {
        this.voltage380V = voltage380V;
    }

    @Override
    public void charge220V() {
        voltage380V.provide380V();
        System.out.println("Адаптер преобразует 380V в 220V и заряжает устройство.");
    }
}

public class Main {
    public static void main(String[] args) {
        Device220V device220V = new Device220VImpl();
        Voltage380V voltage380V = new Voltage380V();

        Device220V adapter = new Adapter380VTo220V(voltage380V);

        // Зарядное устройство 220V заряжается через адаптер с напряжением 380V
        device220V.charge220V();
        adapter.charge220V();
    }
}
