package design_patterns.observer;

public class Main {
    public static void main(String[] args) {

        Teacher teacher = new Teacher();

        Student Emma = new Student("Emma");
        Student Andrew = new Student("Andrew");
        Student Estera = new Student("Estera");
        Student Denise = new Student("Denise");

        teacher.register(Emma);
        teacher.register(Andrew);
        teacher.register(Estera);

        teacher.notifyObservers("learning about JAVA");

        teacher.unregister(Emma);

        System.out.println('\n');
        teacher.notifyObservers("learning about Design Patterns in JAVA");

        teacher.unregister(Denise); // No such registration messahe
    }
}
