package design_patterns.observer.observer_interfaces;

public interface ObservedSubject {

    void register(Observer obj);
    void unregister(Observer obj);
    void notifyObservers(String message);

}
