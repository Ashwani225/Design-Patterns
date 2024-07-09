import java.util.ArrayList;
import java.util.List;

interface Observer {
    void update(String weather);
}

interface Subject {
    void addObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObservers();
}

class WeatherStation implements Subject{
    private List<Observer> observers = new ArrayList<>();
    private String weather;

    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for(Observer observer: observers){
            observer.update(weather);
        }
    }

    public void setWeather(String weather){
        this.weather=weather;
        notifyObservers();
    }
    
}

class PhoneDisplay implements Observer{
    private String weather;

    @Override
    public void update(String weather) {
        this.weather=weather;
        display();
    }

    private void display(){
        System.out.println("Phone Display: Weather updated = "+weather);
    }

}

class TvDisplay implements Observer{
    private String weather;

    @Override
    public void update(String weather) {
        this.weather=weather;
        display();
    }

    private void display(){
        System.out.println("TV Display: Weather updated = "+weather);
    }
}

public class ObserverMain {
    public static void main(String[] args) {
        WeatherStation weatherStation = new WeatherStation();

        Observer phoneDisplay = new PhoneDisplay();
        Observer tvDisplay = new TvDisplay();

        weatherStation.addObserver(phoneDisplay);
        weatherStation.addObserver(tvDisplay);

        weatherStation.setWeather("Sunny");
    }
}


// Conclusion:
// 1. Observer pattern is used when there is one-to-many relationship between objects.  
// 2. The observer pattern defines a one-to-many dependency between objects so that when one object changes state, all its dependents are notified and updated automatically.
// 3. The observer pattern is also known as the publish-subscribe pattern.
// 4. The observer pattern is used in the MVC (Model-View-Controller) architecture.
// 5. The observer pattern is used in the event handling mechanism.
// 6. The observer pattern is used in the GUI components like button, text field, etc.
// 7. The observer pattern is used in the distributed systems.
// 8. The observer pattern is used in the monitoring systems.
// 9. The observer pattern is used in the weather monitoring systems.
// 10. The observer pattern is used in the stock market monitoring systems.
// 11. The observer pattern is used in the traffic signal monitoring systems.
// 12. The observer pattern is used in the social media monitoring systems.
// 13. The observer pattern is used in the chat applications.
// 14. The observer pattern is used in the gaming applications.
// 15. The observer pattern is used in the notification systems.
// 16. The observer pattern is used in the logging systems.

