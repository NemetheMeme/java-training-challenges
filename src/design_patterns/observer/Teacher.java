package design_patterns.observer;

import design_patterns.observer.observer_interfaces.ObservedSubject;
import design_patterns.observer.observer_interfaces.Observer;

import java.util.ArrayList;
import java.util.List;

public class Teacher implements ObservedSubject {

        private List<Observer> observers = new ArrayList<>();

    public Teacher() {}

    @Override
    public void register(Observer obj) {

        Student student = (Student)obj;
        observers.add(obj);

    }

    @Override
    public void unregister(Observer obj) {

        Student student = (Student)obj;

        if(!this.observers.contains(student)){
            System.out.println("No such registration! Can't unregister");
        }
        observers.remove(obj);
    }

    @Override
    public void notifyObservers(String message) {

        for (Observer observer: this.observers) {
                observer.update(message);
        }
    }

}
