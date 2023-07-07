package exceptions_and_io.phonebook;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        List<String> phoneNumbers = new ArrayList<>(findPhoneNumberOf(new String[]{"Abbey", "Abdul", "Shaneka", "Dewey"}));

        for (String phoneNumber: phoneNumbers) {
                System.out.println(phoneNumber);
        }

    }
        public static List<String> findPhoneNumberOf(String[] names){
                List<String> results = new ArrayList<>();
        try {
                Scanner scanner = new Scanner(
                                    new BufferedReader(
                                        new FileReader(
                                            "src/exceptions_and_io/phonebook/phonebook.txt")
                                    )
                                );

                while(scanner.hasNextLine()){
                    String line = scanner.nextLine();
                    String[] splits = line.split(" ");

                    for(String name: names){
                        if( name.equals(splits[0]) ){
                            results.add(line);
                        }
                    }
                }
                scanner.close();
            } catch(FileNotFoundException fife){
            System.out.println(Arrays.toString(fife.getStackTrace()));
        }

        return  results;
    }
}


