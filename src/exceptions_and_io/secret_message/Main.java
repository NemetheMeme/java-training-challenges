package exceptions_and_io.secret_message;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String path = "src/exceptions_and_io/secret_message/secret_message.txt";
        String secret_message = findSecretMessage(path);
        System.out.println(secret_message);

    }

    public static String findSecretMessage(String path){
        StringBuilder secret_message_sb = new StringBuilder();

        /* try with resources, the scanner will automatically close the objects that implements Closeable interface
         such as the Scanner object, we close those resources to avoid serious memory leaks
         */
        try(Scanner scanner = new Scanner(new BufferedReader(new FileReader(path)))){

            while(scanner.hasNextLine()){
             String line = scanner.nextLine();
             String splits[] = line.split(" ");

//             for(String str : splits){
//                 for(int i = 0 ; i < str.length(); i++){
//                     if(str.charAt(i) == 'X'){
//                         secret_message_sb.append(" ");
//                     }
//                     else if((str.charAt(i) >= 65 && str.charAt(i) <= 90) && str.charAt(i) != 88){
//                         secret_message_sb.append(str.charAt(i));
//                     }
//                 }
//             }
                Arrays.stream(splits)
                        .flatMapToInt(CharSequence::chars)
                        .forEach(ch -> {
                            if (ch == 'X') {
                                secret_message_sb.append(" ");
                            } else if ((ch >= 65 && ch <= 90) && ch != 88) {
                                secret_message_sb.append((char) ch);
                            }
                        });


            }
        }
        catch(FileNotFoundException fife){
            System.out.println(fife.getStackTrace());
        }

        return secret_message_sb.toString();
    }
}
