package JavaFundamentals;

import java.util.Scanner;

public class Methods_MiddleCharacters_06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        System.out.println(middleCharacters(input));
    }

    private static String middleCharacters(String input) {
        int indexMiddle = (input.length() - 1) / 2;
        if (input.length() % 2 == 0) {
            return input.substring(indexMiddle, indexMiddle + 2);
        } else {
            return input.substring(indexMiddle, indexMiddle + 1);
        }
    }
}
