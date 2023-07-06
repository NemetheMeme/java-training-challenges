package design_patterns.Iterator;

public class Main {
    public static void main(String[] args) {
        String[] string_array = new String[]{"AB", "CD", "EF", "GH"};
        Integer[] integer_array = new Integer[]{1,2,3,4,5};

        ArrayCustomIterator<String>  string_iterator = new ArrayCustomIterator<>(string_array);
        ArrayCustomIterator<Integer> integer_iterator = new ArrayCustomIterator<>(integer_array);

        while(string_iterator.hasNext()){
            System.out.println(string_iterator.next());
        }

        while(integer_iterator.hasNext()){
            System.out.println(integer_iterator.next());
        }

    }
}
