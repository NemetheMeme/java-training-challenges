package exceptions_and_io.number_to_lcd;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {

        String out_path = "src/exceptions_and_io/number_to_lcd/output.txt";
        String in_path = "src/exceptions_and_io/number_to_lcd/input.txt";

        saveToFile(out_path, NumberToLCD(readNumber(in_path)));
        System.out.println(NumberToLCD(readNumber(in_path)));
    }

    public static char[] readNumber(String path){

        char[] numbers = null;
        try(Scanner scanner = new Scanner(new BufferedReader(new FileReader(path)))){

            String number = scanner.nextLine();
            numbers = number.toCharArray();

        }
        catch(FileNotFoundException fife){
            System.out.println(Arrays.toString(fife.getStackTrace()));
        }

        return numbers;
    }

    public static List<List<String>> NumberToLCD(char[] numbers){

        List<List<String>> wholeNumber = new ArrayList<>();
        List<String> emptyList = new ArrayList<>();

        for(int i = 0 ; i <= 2 ; i++) {
            wholeNumber.add(emptyList);
        }

        for(char number : numbers){
            List<String> lcd_number = transformNumberToLCD(getLCDNumber(number));
            int pos = 0;

            while(pos <= 2){
                wholeNumber.get(pos).add(lcd_number.get(pos));
                pos = pos + 1;
            }
        }

        return wholeNumber;
    }

    public static void saveToFile(String path, List<List<String>> number){

        try(BufferedWriter bw  = new BufferedWriter(new FileWriter(path))){
                for(List<String> line : number){
                    for(String str : line){
                        bw.write(str);
                    }
                    bw.newLine();
                }
        }
        catch(IOException ioe){
            System.out.println(Arrays.toString(ioe.getStackTrace()));
        }

    }

    public static List<String> transformNumberToLCD(boolean[][] number){
        List<String> numberToLCD = new ArrayList<>();

        for (int row = 0 ; row < 3 ; row++) {
            StringBuilder string = new StringBuilder();

            for (int col = 0; col < 3; col++) {

                if (!number[row][col]) {
                    string.append(" ");
                } else {
                    if (col == 1) {
                        string.append("_");
                    } else {
                        string.append("|");
                    }
                }
            }
            numberToLCD.add(string.toString());
        }
        return numberToLCD;
    }

    public static boolean[][] getLCDNumber(char number){

        return switch (number) {
            case '0' -> LCD.ZERO;
            case '1' -> LCD.ONE;
            case '2' -> LCD.TWO;
            case '3' -> LCD.THREE;
            case '4' -> LCD.FOUR;
            case '5' -> LCD.FIVE;
            case '6' -> LCD.SIX;
            case '7' -> LCD.SEVEN;
            case '8' -> LCD.EIGHT;
            case '9' -> LCD.NINE;
            default -> null;
        };
    }
}
