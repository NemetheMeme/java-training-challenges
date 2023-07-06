package design_patterns.decorator.decorations;

import design_patterns.decorator.DecorableTree;

public class Garland extends Decoration{
    public Garland(int positionInTree, DecorableTree christmasTree) {
        super(positionInTree, christmasTree);
    }

    @Override
    public String getDecoration() {
        return "G";
    }
}
