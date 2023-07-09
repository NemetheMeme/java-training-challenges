package exceptions_and_io.occurence;

import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class Main {
    public static void main(String[] args) {
              final String path = "src/exceptions_and_io/occurence/input.txt";
              final String output = "src/exceptions_and_io/occurence/output.txt";

              List<Occurence> occurenceList = getOccurences(path);
              displayTop10occurences(occurenceList);
              saveToFile(output, occurenceList);
    }

    public static void saveToFile(String path, List<Occurence> occurences){

        try(BufferedWriter bw = new BufferedWriter(new FileWriter(path))){
            for(Occurence oc : occurences){
                bw.write(oc.toString());
                bw.newLine();
            }
        }
        catch(IOException ioe){
            System.out.println(Arrays.toString(ioe.getStackTrace()));
        }

    }
    public static void displayTop10occurences(List<Occurence> occurences){

        for(int i = 0 ; i < 10 ; i++){
            System.out.println(occurences.get(i).toString());
        }
    }

    public static List<Occurence> getOccurences(String path ){
         Set<Occurence> occurences = new HashSet<>();

            try(Scanner scanner = new Scanner(new BufferedReader(new FileReader(path)))) {
                while (scanner.hasNextLine()) {
                    String line = scanner.nextLine();
                    String[] splits = line.split(" ");

                    if (occurences.size() == 0) {
                        occurences.add(new Occurence(splits[0]));
                    } else {
                        for (String word : splits) {
                            if(!occurenceExisting(word,occurences))   occurences.add(new Occurence(word));
                            else{
                                getOccurenceByWord(word,occurences).incrementCount();
                            }
                        }
                    }

                }
            }
            catch(FileNotFoundException fife){
                System.out.println(Arrays.toString(fife.getStackTrace()));
            }

            List<Occurence> sortedOccurences  = new ArrayList<>(occurences);
            Collections.sort(sortedOccurences);
            return sortedOccurences;
    }

    private static boolean occurenceExisting(String word, Set<Occurence> occurences){
        for(Occurence occurence : occurences){
            if(occurence.getWord().equals(word)) return true;
        }
        return false;
    }

    private static Occurence getOccurenceByWord(String word, Set<Occurence> occurences){
        Occurence result = null;
            for(Occurence occurence: occurences){
                if(occurence.getWord().equals(word))  result = occurence;
            }

        return result;
    }
}
