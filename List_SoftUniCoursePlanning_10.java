package JavaFundamentals;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class List_SoftUniCoursePlanning_10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> schedule = Arrays.stream(scanner.nextLine().split(", "))
                .collect(Collectors.toList());
        String command = scanner.nextLine();

        while (!command.equals("course start")) {
            List<String> tokens = Arrays.stream(command.split(":")).collect(Collectors.toList());
            String currentCommand = tokens.get(0);
            String lessonTitle = tokens.get(1);
            switch (currentCommand) {
                case "Add":
                    if (!schedule.contains(lessonTitle)) {
                        schedule.add(lessonTitle);
                    }
                    break;
                case "Insert":
                    int indexToInsert = Integer.parseInt(tokens.get(2));
                    if (!schedule.contains(lessonTitle)) {
                        schedule.add(indexToInsert, lessonTitle);
                    }
                    break;
                case "Remove":
                    schedule.remove(lessonTitle);
                    schedule.remove(lessonTitle + "-Exercise");
                    break;
                case "Swap":
                    String lessonTitle2 = tokens.get(2);
                    if (schedule.contains(lessonTitle) && schedule.contains(lessonTitle2)) {
                        int firstIndexToReplace = -1;
                        int secondIndexToReplace = -1;
                        int indexExerciseToSwap1 = -1;
                        int indexExerciseToSwap2 = -1;
                        for (int i = 0; i < schedule.size(); i++) {
                            if (schedule.get(i).equals(lessonTitle)) {
                                firstIndexToReplace = i;
                                if (schedule.contains(lessonTitle + "-Exercise")) {
                                    indexExerciseToSwap1 = i + 1;
                                }
                            } else if (schedule.get(i).equals(lessonTitle2)) {
                                secondIndexToReplace = i;
                                if (schedule.contains(lessonTitle2 + "-Exercise") ) {
                                    indexExerciseToSwap2 = i + 1;
                                }
                            }
                        }
                        schedule.set(firstIndexToReplace, lessonTitle2);
                        schedule.set(secondIndexToReplace, lessonTitle);

                        if (indexExerciseToSwap1 != -1 && indexExerciseToSwap2 != -1) {
                            schedule.set(indexExerciseToSwap1, schedule.get(indexExerciseToSwap2));
                            schedule.set(indexExerciseToSwap2, schedule.get(indexExerciseToSwap1));
                        }
                        if (indexExerciseToSwap1 != -1 && indexExerciseToSwap2 == -1) {
                            String exerciseToSwap1 = schedule.get(indexExerciseToSwap1);
                            schedule.remove(indexExerciseToSwap1);
                            schedule.add(secondIndexToReplace + 1, exerciseToSwap1);
                        }
                        if (indexExerciseToSwap1 == -1 && indexExerciseToSwap2 != -1) {
                            String exerciseToSwap2 = schedule.get(indexExerciseToSwap2);
                            schedule.remove(indexExerciseToSwap2);
                            schedule.add(firstIndexToReplace + 1, exerciseToSwap2);
                        }
                    }
                    break;
                case "Exercise":
                    if (!schedule.contains(lessonTitle)) {
                        schedule.add(lessonTitle);
                        schedule.add(lessonTitle + "-Exercise");
                    } else {
                        int indexOfLesson = -1;
                        for (int i = 0; i < schedule.size(); i++) {
                            if (schedule.get(i).equals(lessonTitle)) {
                                indexOfLesson = i;
                                break;
                            }
                        }
                        if (!schedule.get(indexOfLesson + 1).equals(lessonTitle + "-Exercise")) {
                            schedule.set(indexOfLesson + 1, lessonTitle + "-Exercise");
                        }
                        break;
                    }
            }
            command = scanner.nextLine();
        }

        for (int i = 0; i < schedule.size(); i++) {
            System.out.printf("%d.%s%n", i + 1, schedule.get(i));
        }
    }
}
