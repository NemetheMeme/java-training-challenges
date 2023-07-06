package design_patterns.template;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        Integer[] arr = new Integer[]{1,4,5,2,5,6,8,8,7};

        Integer[] copy_one_of_arr =  Arrays.copyOf(arr,arr.length);
        Integer[] copy_two_of_arr =  Arrays.copyOf(arr,arr.length);
        Double[] double_array = new Double[]{1.2, 10.2, 5.4, 3.7, 6.12, 6.13, 5.41};
        String[] string_array = new String[]{"Miguel","Jenna","Emma", "Andrew"};

        AscendingInsertionSort<Integer> ascending_i_sort_integer = new AscendingInsertionSort<>();
        DescendingInsertionSort<Integer> descending_i_sort_integer = new DescendingInsertionSort<>();
        AscendingInsertionSort<Double> ascending_i_sort_double = new AscendingInsertionSort<>();
        DescendingInsertionSort<String> descending_i_sort_string = new DescendingInsertionSort<>();

        ascending_i_sort_integer.sort(copy_one_of_arr);
        descending_i_sort_integer.sort(copy_two_of_arr);
        ascending_i_sort_double.sort(double_array);
        descending_i_sort_string.sort(string_array);

        displayArray(copy_one_of_arr);
        displayArray(copy_two_of_arr);
        displayArray(double_array);
        displayArray(string_array);

    }

    public static <E> void  displayArray(E[] array){
            System.out.println(Arrays.toString(array));
    }
}
