package JavaFundamentals;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Stream;

public class TextProcessing_LettersChangeNumbers_08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split("\\s+");
        String alphabeticalLowercase = "abcdefghijklmnopqrstuvwxyz";
        String alphabeticalUppercase = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        double sum = 0.0;

        for (int i = 0; i < input.length; i++) {
            String currentString = input[i];
            char firstLetter = currentString.charAt(0);
            char lastLetter = currentString.charAt(currentString.length() - 1);
            double number = Double.parseDouble(currentString.substring(1, currentString.length() - 1));
            if (Character.isLowerCase(firstLetter)) {
                int positionInAlphabetFirstLetter = alphabeticalLowercase.indexOf(firstLetter) + 1;
                number = number * positionInAlphabetFirstLetter;
            } else {
                int positionInAlphabetFirstLetter = alphabeticalUppercase.indexOf(firstLetter) + 1;
                number = number / positionInAlphabetFirstLetter;
            }
            if (Character.isLowerCase(lastLetter)) {
                int positionInAlphabetLastLetter = alphabeticalLowercase.indexOf(lastLetter) + 1;
                number += positionInAlphabetLastLetter;
            } else {
                int positionInAlphabetLastLetter = alphabeticalUppercase.indexOf(lastLetter) + 1;
                number -= positionInAlphabetLastLetter;
            }
            sum += number;
        }
        System.out.printf("%.2f", sum);
    }
}
