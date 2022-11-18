package JavaFundamentals;

import java.util.Scanner;

public class Methods_TopNumber_10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = Integer.parseInt(scanner.nextLine());
        topNumber(number);
    }

    private static void topNumber(int number) {
        for (int currentNumber = 1; currentNumber <= number; currentNumber++) {
            int sumOfDigits = 0;
            int counterOddDigits = 0;
            String digits = String.valueOf(currentNumber);
            for (int i = 0; i < digits.length(); i++) {
                int currentDigit = Integer.parseInt(String.valueOf(digits.charAt(i)));
                sumOfDigits += currentDigit;
                if (currentDigit % 2 != 0) {
                    counterOddDigits++;
                }
            }
            if (sumOfDigits % 8 == 0 && counterOddDigits >= 1){
                System.out.println(currentNumber);
            }
        }
    }
}
