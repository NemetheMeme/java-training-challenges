package design_patterns.decorator;

import design_patterns.decorator.decorations.Bulb;
import design_patterns.decorator.decorations.Candy;
import design_patterns.decorator.decorations.Garland;

public class Main {
    public static void main(String[] args) {

        DecorableTree christmasTree = new ChristmasTree();
        DecorableTree decoratedTree = christmasTree;

        decoratedTree = new Candy(3,decoratedTree);
        decoratedTree = new Garland(8,decoratedTree);
        decoratedTree = new Bulb(6, decoratedTree);

        decoratedTree.display();
        christmasTree.display();
    }
}
