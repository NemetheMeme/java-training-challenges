package design_patterns.Iterator;

public class ArrayCustomIterator<E> {

    private int count;
    private E[] array;
    private int current;

    public ArrayCustomIterator(E[] array) {
        this.array = array;
        this.count = array.length;
        this.current = 0;
    }

    public boolean hasNext(){
        return this.current < this.array.length;
    }
    public E next(){
        E element = array[current];
        ++current;
        return element;
    }
}
