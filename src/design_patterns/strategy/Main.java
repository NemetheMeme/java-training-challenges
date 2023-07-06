package design_patterns.strategy;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Integer[] arr = new Integer[]{1,4,5,2,5,6,8,8,7};

        Integer[] copy_one_of_arr =  Arrays.copyOf(arr,arr.length);
        Integer[] copy_two_of_arr =  Arrays.copyOf(arr,arr.length);
        Double[] double_array = new Double[]{1.2, 10.2, 5.4, 3.7, 6.12, 6.13, 5.41};
        String[] string_array = new String[]{"Miguel","Jenna","Emma", "Andrew"};

        displaySorted(new QuickSortStrategy(), copy_one_of_arr);
        displaySorted(new SelectionSortStrategy(), copy_two_of_arr);
        displaySorted(new QuickSortStrategy(), double_array);
        displaySorted(new SelectionSortStrategy(), string_array);
    }

    private static <E> void displaySorted(SortingStrategy strategy, E[] list) {
        strategy.sort((Comparable[]) list);
        System.out.println(Arrays.toString(list));
    }
}
