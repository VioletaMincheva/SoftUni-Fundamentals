package Java_Interviews_EntryTest.MentorMate;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class BackEndChallenge {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //Example Input
        //key=IAfpK, age=58, key=WNVdi, age=64, key=jp9zt, age=47
        //
        //Example Output
        //2

        String input = scanner.nextLine();
        String[] tokens = input.split(", ");
        int counter = 0;
        Map<String, Integer> mapKeyAge = new HashMap<>();

        for (int i = 0; i < tokens.length; i += 2) {
            String key = tokens[i].substring(4);
            int age = Integer.parseInt(tokens[i + 1].substring(4));
            mapKeyAge.put(key, age);
        }

        for (Map.Entry<String, Integer> entry : mapKeyAge.entrySet()) {
            if (entry.getValue()>=50){
                counter++;
            }
        }
        System.out.println(counter);

    }
}
