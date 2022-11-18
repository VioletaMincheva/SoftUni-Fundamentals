package JavaFundamentals;

import java.util.Arrays;
import java.util.Scanner;

public class MagicSum_Arrays_08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] array = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int sum = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < array.length; i++) {
            int currentElement = array[i];
            for (int j = i + 1; j < array.length; j++) {
                int nextElement = array[j];
                if (currentElement + nextElement == sum) {
                    System.out.println(currentElement + " " + nextElement);
                }
            }
        }

    }
}
