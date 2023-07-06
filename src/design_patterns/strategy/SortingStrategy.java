package design_patterns.strategy;

public interface SortingStrategy<E extends Comparable<E>> {

    void sort(E[] list);
}
