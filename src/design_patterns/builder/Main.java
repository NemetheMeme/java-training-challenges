package design_patterns.builder;

public class Main {
    public static void main(String[] args) {

        Person Emma = new PersonBuilder("Emma")
                .drivingLicense(true)
                .university("Transylvania of Brașov")
                .isMarried(false)
                .build();

        System.out.println(Emma);
    }
}
