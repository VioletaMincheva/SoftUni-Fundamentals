package JavaFundamentals;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class AssociativeArrays_SoftUniExamResults_10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Integer> resultsNamePoints = new LinkedHashMap<>();
        Map<String, Integer> submissionsLanguagesCount = new LinkedHashMap<>();

        String input = scanner.nextLine();
        while (!input.equals("exam finished")) {
            String[] tokens = input.split("-");
            String name = tokens[0];
            String language = tokens[1];
            if (language.equals("banned")) {
                resultsNamePoints.remove(name);
            } else {
                int points = Integer.parseInt(tokens[2]);
                if (!resultsNamePoints.containsKey(name)) {
                    resultsNamePoints.put(name, points);
                } else if (resultsNamePoints.get(name) < points) {
                    resultsNamePoints.put(name, points);
                }
                if (!submissionsLanguagesCount.containsKey(language)) {
                    submissionsLanguagesCount.putIfAbsent(language, 1);
                } else {
                    submissionsLanguagesCount.put(language, submissionsLanguagesCount.get(language) + 1);
                }
            }
            input = scanner.nextLine();
        }
        System.out.println("Results:");
        for (Map.Entry<String, Integer> result : resultsNamePoints.entrySet()) {
            System.out.printf("%s | %d%n", result.getKey(), result.getValue());
        }
        System.out.println("Submissions:");
        for (Map.Entry<String, Integer> languageCount : submissionsLanguagesCount.entrySet()) {
            System.out.printf("%s - %d%n", languageCount.getKey(), languageCount.getValue());
        }
    }
}
