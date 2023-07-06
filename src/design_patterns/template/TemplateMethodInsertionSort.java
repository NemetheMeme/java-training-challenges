package design_patterns.template;

public abstract class TemplateMethodInsertionSort<E> {

    void sort(E[] list){
        int n = list.length;
        for (int j = 1; j < n; j++) {
            E key = list[j];
            int i = j-1;
            while ( (i > -1) && (elementsInCorrectOrder(list[i], key))) {
                list[i+1] =  list[i];
                i--;
            }
            list[i+1] = key;
        }

    }
    abstract boolean elementsInCorrectOrder(E e1, E e2);

}
