package design_patterns.decorator.decorations;

import design_patterns.decorator.DecorableTree;

import java.util.ArrayList;
import java.util.List;

public abstract class Decoration implements DecorableTree {

    protected int positionInTree;
    protected DecorableTree christmasTree;

    public Decoration(int positionInTree, DecorableTree christmasTree) {
        this.positionInTree = positionInTree;
        this.christmasTree = christmasTree;
    }

    @Override
    public List<List<String>> getTree() {
        List<List<String>> originalTree = christmasTree.getTree();
        List<List<String>> decoratedTree = new ArrayList<>(originalTree); // make a copy of the original tree

        // find the brackets where the decorations will be
        int left = decoratedTree.get(positionInTree).indexOf("<");
        int right = decoratedTree.get(positionInTree).indexOf(">");

        List<String> originalTreeRow = decoratedTree.get(positionInTree);// get the specified row
        List<String> decoratedTreeRow = new ArrayList<>(originalTreeRow); // make a copy of the original row

        for(int i = left +1; i <=  right-1 ; i++){
            decoratedTreeRow.set(i,getDecoration());
        }
        decoratedTree.set(positionInTree, decoratedTreeRow);

        return decoratedTree;

    }

    public abstract String getDecoration();

    @Override
    public void display() {
        List<List<String>> tree = this.getTree();
        for(int i = 0; i < tree.size(); i++){
            for(int j = 0; j < tree.get(i).size(); j++){
                System.out.print(tree.get(i).get(j));
            }
            System.out.println();
        }
    }
}

