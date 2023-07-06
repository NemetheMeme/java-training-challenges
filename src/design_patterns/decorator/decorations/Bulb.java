package design_patterns.decorator.decorations;

import design_patterns.decorator.DecorableTree;

public class Bulb extends Decoration{
    public Bulb(int positionInTree, DecorableTree christmasTree) {
        super(positionInTree, christmasTree);
    }

    @Override
    public String getDecoration() {
        return "B";
    }
}
