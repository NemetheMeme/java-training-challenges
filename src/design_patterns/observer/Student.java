package design_patterns.observer;

import design_patterns.observer.observer_interfaces.Observer;

public class Student implements Observer {

    private String name;
    private String behaviour;

    public Student(String name) {
        this.name = name;
        this.behaviour = "Pending";
    }

    @Override
    public void update(String message) {
        this.behaviour = message;
        System.out.println(this.name + " - " + this.behaviour);

    }

}
