package design_patterns.strategy;

public class QuickSortStrategy<E extends Comparable<E>> implements SortingStrategy<E>{

    @Override
    public void sort(E[] list) {
            quickSort(list, 0, list.length-1);
    }

    private void quickSort(E[] array, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(array, low, high);
            quickSort(array, low, pivotIndex - 1);
            quickSort(array, pivotIndex + 1, high);
        }
    }

    private int partition(E[] array, int low, int high){
        final Swap<E> swap  = new Swap<>();
        E pivot = array[high];
        int i =( low -1);

        for(int j = low; j <= high -1 ; j++){
            if(array[j].compareTo(pivot) < 0){
                i++;
            swap.swap(array,i,j);
            }
        }
        swap.swap(array,i+1, high);
        return (i+1);
    }
}
