package JavaFundamentals;

import java.util.Scanner;

public class MidExam_Guinea_Pig_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Double food = Double.parseDouble(scanner.nextLine()) * 1000;
        Double hay = Double.parseDouble(scanner.nextLine()) * 1000;
        Double cover = Double.parseDouble(scanner.nextLine()) * 1000;
        Double weightOfGuineaPig = Double.parseDouble(scanner.nextLine()) * 1000;
        int countDays = 0;

        for (int i = 1; i <= 30; i++) {
            if (food > 300) {
                food -= 300;
            } else {
                System.out.print("Merry must go to the pet store!");
                break;
            }
            if (i % 2 == 0) {
                hay -= 0.05 * food;
                if (hay <= 0) {
                    System.out.print("Merry must go to the pet store!");
                    break;
                }
            }
            if (i % 3 == 0) {
                cover -= weightOfGuineaPig / 3;
                if (cover <= 0) {
                    System.out.print("Merry must go to the pet store!");
                    break;
                }
            }
            countDays++;
        }
        food = food / 1000;
        hay = hay / 1000;
        cover = cover / 1000;
        weightOfGuineaPig = weightOfGuineaPig / 1000;

        if (countDays == 30) {
            System.out.printf("Everything is fine! Puppy is happy! " +
                    "Food: %.2f, Hay: %.2f, Cover: %.2f.", food, hay, cover);
        }
    }
}
