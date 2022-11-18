package JavaFundamentals;

import java.util.Scanner;

public class Train_Arrays_01 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int wagons = Integer.parseInt(scanner.nextLine());
        int[] train = new int[wagons];
        int sumOfPeople = 0;

        for (int i = 0; i < wagons; i++) {
            train[i] = Integer.parseInt(scanner.nextLine());
            sumOfPeople += train[i];
        }
        for (int j = 0; j < train.length; j++) {
            System.out.print(train[j] + " ");
        }
        System.out.println();
        System.out.print(sumOfPeople);
    }
}
