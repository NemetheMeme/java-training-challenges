package design_patterns.strategy;

public class SelectionSortStrategy<E extends Comparable<E>> implements SortingStrategy<E>{
    @Override
    public void sort(E[] list) {
        for (int i = 0; i < list.length - 1; i++)
        {
            int index = i;
            for (int j = i + 1; j < list.length; j++){
                if (list[j].compareTo(list[index]) < 0){
                    index = j;//searching for lowest index
                }
            }
            E smallerNumber = list[index];
            list[index] = list[i];
            list[i] = smallerNumber;
        }
    }

}
