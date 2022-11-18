package JavaFundamentals;

import java.util.Arrays;
import java.util.Scanner;

public class Array_Rotation_04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] array = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(e -> Integer.parseInt(e)).toArray();
        int numberOfRotation = Integer.parseInt(scanner.nextLine());

        for (int currentNumber = 0; currentNumber < numberOfRotation; currentNumber++) {
            int firstElement = array[0];
            for (int i = 0; i < array.length - 1; i++) {
                array[i] = array[i + 1];
            }
            array[array.length - 1] = firstElement;
        }
        for (int j = 0; j < array.length; j++) {
            System.out.print(array[j] + " ");
        }
    }
}
