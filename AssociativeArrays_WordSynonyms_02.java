package JavaFundamentals;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class AssociativeArrays_WordSynonyms_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        LinkedHashMap<String, ArrayList<String>> allWords = new LinkedHashMap<>();

        for (int i = 0; i < n; i++) {
            String word = scanner.nextLine();
            String synonym = scanner.nextLine();
            if (!allWords.containsKey(word)) {
                allWords.put(word, new ArrayList<>());
                allWords.get(word).add(synonym);
            } else {
                if (!allWords.get(word).contains(synonym)) {
                    allWords.get(word).add(synonym);
                }
            }
        }
        for (Map.Entry<String, ArrayList<String>> entry : allWords.entrySet()) {
            System.out.printf("%s - %s%n", entry.getKey(), String.join(", ", entry.getValue()));
        }
    }
}
