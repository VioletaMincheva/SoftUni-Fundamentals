package JavaFundamentals;

import java.util.Scanner;

import static java.lang.Integer.sum;

public class Methods_AddAndSubtract_05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int firstNumber = Integer.parseInt(scanner.nextLine());
        int secondNumber = Integer.parseInt(scanner.nextLine());
        int thirdNumber = Integer.parseInt(scanner.nextLine());
        int result = subtract(firstNumber, secondNumber, thirdNumber);
        System.out.println(result);
    }

    private static int sum(int first, int second) {
        return first + second;
    }

    private static int subtract(int first, int second, int thirdNumber) {
        return sum(first, second) - thirdNumber;
    }
}
