package JavaFundamentals;

import java.util.Scanner;

public class TextProcessing_StringExplosion_07 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        StringBuilder text = new StringBuilder(scanner.nextLine());
        int strengthOfExplosion = 0;

        for (int i = 0; i < text.length(); i++) {
            char currentSymbol = text.charAt(i);
            if (currentSymbol == '>') {
                strengthOfExplosion += Character.getNumericValue(text.charAt(i + 1));
            } else if (strengthOfExplosion > 0 && text.charAt(i) != '>') {
                text.deleteCharAt(i);
                strengthOfExplosion--;
                i--;
            }
        }
        System.out.print(text);
    }
}
