package design_patterns.decorator.decorations;

import design_patterns.decorator.DecorableTree;

public class Candy extends Decoration{

    public Candy(int positionInTree, DecorableTree christmasTree) {
        super(positionInTree, christmasTree);
    }

    @Override
    public String getDecoration() {
        return "C";
    }
}
