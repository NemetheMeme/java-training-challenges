package oop.movie_database;

public class Actor {
    private String name;
    private int age;
    private Award[] awards;

    public Actor(String name, int age, Award[] awards) {
        this.name = name;
        this.age = age;
        this.awards = awards;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Award[] getAwards() {
        return awards;
    }

    public void setAwards(Award[] awards) {
        this.awards = awards;
    }
}
