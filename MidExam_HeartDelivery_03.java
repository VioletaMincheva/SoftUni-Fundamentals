package JavaFundamentals;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MidExam_HeartDelivery_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> neighborhood = Arrays.stream(scanner.nextLine().split("@"))
                .map(Integer::parseInt).collect(Collectors.toList());

        String command = scanner.nextLine();
        int positionOfCupid = 0;

        while (!command.equals("Love!")) {
            String[] jump = command.split("\\s+");
            int lengthOfJump = Integer.parseInt(jump[1]);
            positionOfCupid += lengthOfJump;
            if (positionOfCupid >= neighborhood.size()) {
                positionOfCupid = 0;
            }
            int currentHouseHurts = neighborhood.get(positionOfCupid);
            if (currentHouseHurts == 0) {
                System.out.printf("Place %d already had Valentine's day.%n", positionOfCupid);
            } else {
                currentHouseHurts -= 2;
                neighborhood.set(positionOfCupid, currentHouseHurts);
                if (currentHouseHurts == 0) {
                    System.out.printf("Place %d has Valentine's day.%n", positionOfCupid);
                }
            }
            command = scanner.nextLine();
        }

        System.out.printf("Cupid's last position was %d.%n", positionOfCupid);
        int countValentinesDay = 0;
        for (Integer hurtsOfCurrentHouse : neighborhood) {
            if (hurtsOfCurrentHouse.equals(0)) {
                countValentinesDay++;
            }
        }
        if (countValentinesDay == neighborhood.size()) {
            System.out.println("Mission was successful.");
        } else {
            int donNotHaveValentinesDay = neighborhood.size() - countValentinesDay;
            System.out.printf("Cupid has failed %d places.", donNotHaveValentinesDay);
        }

    }
}
