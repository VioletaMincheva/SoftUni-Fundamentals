package Java_Interviews_EntryTest.MentorMate;

import java.util.Scanner;

public class MathChallenge {
    //7 & num2 = 3
    //36 & num2 = 54
    public static int MathChallenge(int num1, int num2) {
        // code goes here
        int greatestCommonFactor = 1;
        if (num1 > num2) {
            for (int i = num2; i > 0; i--) {
                if (num1 % i == 0 && num2 % i == 0) {
                    greatestCommonFactor = i;
                    break;
                }
            }
        } else {
            for (int i = num1; i > 0; i--) {
                if (num1 % i == 0 && num2 % i == 0) {
                    greatestCommonFactor = i;
                    break;
                }
            }
        }
        return greatestCommonFactor;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split("\\s+");
        int num1 = Integer.parseInt(input[0]);
        int num2 = Integer.parseInt(input[input.length - 1]);
        System.out.println(MathChallenge(num1, num2));

    }
}
