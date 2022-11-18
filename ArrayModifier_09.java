package JavaFundamentals;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayModifier_09 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] array = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();

        String[] command = scanner.nextLine().split(" ");
        while (!command[0].equals("end")) {
            if (command[0].equals("decrease")) {
                for (int i = 0; i < array.length; i++) {
                    array[i] = array[i] - 1;
                }
            } else if (command[0].equals("swap")) {
                int index1 = Integer.parseInt(command[1]);
                int index2 = Integer.parseInt(command[2]);
                int swapNumberIndex1 = array[index1];
                array[index1] = array[index2];
                array[index2] = swapNumberIndex1;
            } else if (command[0].equals("multiply")) {
                int index1 = Integer.parseInt(command[1]);
                int index2 = Integer.parseInt(command[2]);
                array[index1] = array[index1] * array[index2];
            }
            command = scanner.nextLine().split(" ");
        }
        for (int j = 0; j < array.length; j++) {
            if (j < array.length - 1) {
                System.out.print(array[j] + ", ");
            } else {
                System.out.println(array[j]);
            }
        }
    }
}
