interface AppleCharger {
    void charge();
}

class AppleChargerImpl implements AppleCharger {
    @Override
    public void charge() {
        System.out.println("Charging Apple device");
    }
}

interface AndroidCharger {
    void charge();
}

class AndroidChargerImpl implements AndroidCharger {
    @Override
    public void charge() {
        System.out.println("Charging Android device");
    }
}

class AndroidToAppleAdapter implements AppleCharger {
    private AndroidCharger androidCharger;

    public AndroidToAppleAdapter(AndroidCharger androidCharger) {
        this.androidCharger = androidCharger;
    }

    @Override
    public void charge() {
        androidCharger.charge();
    }
}

public class AdapterDesignPattern {
    public static void main(String[] args) {
        AppleCharger appleCharger= new AppleChargerImpl();
        appleCharger.charge();
        AndroidCharger androidCharger = new AndroidChargerImpl();
        androidCharger.charge();
        AppleCharger androidToAppleAdapter = new AndroidToAppleAdapter(androidCharger);
        androidToAppleAdapter.charge();
    }
}

// Conclustion:
// Adapter Design Pattern is used to convert the interface of a class into another interface that a client expects.
// Adapter lets classes work together that couldn't otherwise because of incompatible interfaces.
// In this example, we have an AppleCharger interface and an AndroidCharger interface. We have an AppleChargerImpl class
// that implements the AppleCharger interface and an AndroidChargerImpl class that implements the AndroidCharger interface.
// We have an AndroidToAppleAdapter class that implements the AppleCharger interface and has an AndroidCharger object.
// The AndroidToAppleAdapter class adapts the AndroidCharger interface to the AppleCharger interface.
// In the main method, we create an AppleCharger object and call the charge method. We create an AndroidCharger object and call the charge method.
// We create an AndroidToAppleAdapter object and pass the AndroidCharger object to the constructor. We call the charge method on the AndroidToAppleAdapter object.
// The charge method of the AndroidToAppleAdapter object calls the charge method of the AndroidCharger object. The AndroidCharger object charges the Android device.
// The AndroidToAppleAdapter class adapts the AndroidCharger interface to the AppleCharger interface. The Android device is charged using the Apple charger.
