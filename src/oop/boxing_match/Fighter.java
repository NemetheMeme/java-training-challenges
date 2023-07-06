package oop.boxing_match;

public class Fighter {
    private String name;
    private int health;
    private int damagePerAttack;

    public Fighter(String name, int damagePerAttack) {
        this.name = name;
        this.damagePerAttack = damagePerAttack;
        this.health = 100;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public String getName() {
        return name;
    }

    public int getDamagePerAttack() {
        return damagePerAttack;
    }

    protected void attack( Fighter opponent){
        opponent.setHealth(opponent.getHealth() - this.getDamagePerAttack());
    }
}
