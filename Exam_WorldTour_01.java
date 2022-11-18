package JavaFundamentals;

import java.util.Arrays;
import java.util.Scanner;

public class Exam_WorldTour_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        StringBuilder stops = new StringBuilder(scanner.nextLine());
        String command = scanner.nextLine();

        while (!command.equals("Travel")) {
            String[] tokens = command.split(":");
            switch (tokens[0]) {
                case "Add Stop":
                    int index = Integer.parseInt(tokens[1]);
                    String newStop = tokens[2];
                    if (indexIsValid(stops, index)) {
                        stops.insert(index, newStop);
                    }
                    break;
                case "Remove Stop":
                    int startIndex = Integer.parseInt(tokens[1]);
                    int endIndex = Integer.parseInt(tokens[2]);
                    if (bothIndexesAreValid(stops, startIndex, endIndex)) {
                        stops.replace(startIndex, endIndex + 1, "");
                    }
                    break;
                case "Switch":
                    String oldStop = tokens[1];
                    String replacementStop = tokens[2];
                    String currentStops = stops.toString();
                    if (currentStops.contains(oldStop)){
                        stops = new StringBuilder(currentStops.replaceAll(oldStop, replacementStop));
                    }
                    break;
            }
            System.out.println(stops);
            command = scanner.nextLine();
        }
        System.out.println("Ready for world tour! Planned stops: " + stops);
    }

    private static boolean bothIndexesAreValid(StringBuilder stringBuilder, int startIndex, int endIndex) {
        if (startIndex >= 0 && startIndex < stringBuilder.length() && endIndex >= 0 && endIndex < stringBuilder.length()) {
            return true;
        }
        return false;
    }

    private static boolean indexIsValid(StringBuilder stringBuilder, int index) {
        if (index >= 0 && index < stringBuilder.length()) {
            return true;
        }
        return false;
    }
}
