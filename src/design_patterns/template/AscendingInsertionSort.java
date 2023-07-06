package design_patterns.template;

public class AscendingInsertionSort<E extends Comparable<E>> extends TemplateMethodInsertionSort<E>{


    @Override
    boolean elementsInCorrectOrder(E e1, E e2) {
        if(e1.compareTo(e2) > 0) {
            return true;
        }
        return false;
    }
}
