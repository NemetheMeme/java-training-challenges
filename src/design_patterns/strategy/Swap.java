package design_patterns.strategy;

public class Swap<E extends Comparable<E>> {

    public void swap(E[] array, int index_x, int index_y){

        E temp = array[index_x];
        array[index_x] = array[index_y];
        array[index_y] = temp;

    }
}
