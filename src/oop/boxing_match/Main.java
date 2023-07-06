package oop.boxing_match;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
            Fighter Jhon = new Fighter("Jhon", 15);
            Fighter Miguel = new Fighter("Miguel", 20);

            BoxingMatch match = new BoxingMatch(Jhon, Miguel);
            String winner = match.fight();

            System.out.println(winner);
    }
}
