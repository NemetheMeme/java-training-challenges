package exceptions_and_io.anagram;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
            String input_big_list_path = "src/exceptions_and_io/anagram/big_list.txt";
            String input_small_list_path = "src/exceptions_and_io/anagram/small_list.txt";

            String small_list_output_path = "src/exceptions_and_io/anagram/small_list_output.txt";
            String big_list_output_path = "src/exceptions_and_io/anagram/big_list_output.txt";

            saveToFile(big_list_output_path, anagram("repair",input_big_list_path));
            saveToFile(small_list_output_path, anagram("listen", input_small_list_path));

    }

    public static List<String> anagram(String word, String path){
        List<String> combinations = allCombinationsOfLetters(word);
        List<String> found_combinations = new ArrayList<>();

        try(Scanner scanner = new Scanner(new BufferedReader(new FileReader(path)))){

            String line;

            while(scanner.hasNextLine()){

                line = scanner.nextLine();
                String[]  splits = line.split(" ");

                for(String str : splits){
                    for(String str_from_combinations : combinations){
                        if(str.equals(str_from_combinations))  found_combinations.add(str);
                    }
                }
            }
        }
        catch(FileNotFoundException fife){
            System.out.println(Arrays.toString(fife.getStackTrace()));
        }

        return found_combinations;
    }


    public static void saveToFile(String path, List<String> results){

        try(BufferedWriter bw = new BufferedWriter( new FileWriter(path))){
                for(String str : results){
                    bw.write(str);
                    bw.newLine();
                }

        }
        catch(IOException ioe){
            System.out.println(Arrays.toString(ioe.getStackTrace()));
        }

    }

    public static List<String> allCombinationsOfLetters(String word) {
        List<String> combinations = new ArrayList<>();
        generateCombinations("", word, combinations);
        return combinations;
    }

    private static void generateCombinations(String prefix, String remaining, List<String> combinations) {
        int length = remaining.length();
        if (length == 0) {
            combinations.add(prefix);
            return;
        }
        for (int i = 0; i < length; i++) {
            String updatedPrefix = prefix + remaining.charAt(i);
            String updatedRemaining = remaining.substring(0, i) + remaining.substring(i + 1);
            generateCombinations(updatedPrefix, updatedRemaining, combinations);
        }
    }
}
