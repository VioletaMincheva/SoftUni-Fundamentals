package JavaFundamentals;

import java.util.*;

public class Exam_thePianist_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        Map<String, List<String>> allPieces = new LinkedHashMap<>();

        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split("\\|");
            String piece = input[0];
            String composer = input[1];
            String key = input[2];
            allPieces.putIfAbsent(piece, new ArrayList<>());
            allPieces.get(piece).add(composer);
            allPieces.get(piece).add(key);
        }

        String command = scanner.nextLine();
        while (!command.equals("Stop")) {
            String[] tokens = command.split("\\|");
            String currentCommand = tokens[0];
            String piece1 = tokens[1];
            if (currentCommand.equals("Add")) {
                String composer1 = tokens[2];
                String key1 = tokens[3];
                if (allPieces.containsKey(piece1)) {
                    System.out.printf("%s is already in the collection!%n", piece1);
                } else {
                    allPieces.putIfAbsent(piece1, new ArrayList<>());
                    allPieces.get(piece1).add(composer1);
                    allPieces.get(piece1).add(key1);
                    System.out.printf("%s by %s in %s added to the collection!%n", piece1, composer1, key1);
                }
            } else if (currentCommand.equals("Remove")) {
                if (allPieces.containsKey(piece1)) {
                    allPieces.remove(piece1);
                    System.out.printf("Successfully removed %s!%n", piece1);
                } else {
                    System.out.printf("Invalid operation! %s does not exist in the collection.%n", piece1);
                }
            } else if (currentCommand.equals("ChangeKey")) {
                String keyForChange = tokens[2];
                if (allPieces.containsKey(piece1)) {
                    allPieces.get(piece1).set(1, keyForChange);
                    System.out.printf("Changed the key of %s to %s!%n", piece1, keyForChange);
                } else {
                    System.out.printf("Invalid operation! %s does not exist in the collection.%n", piece1);
                }
            }
            command = scanner.nextLine();
        }

        allPieces.entrySet().forEach(e-> System.out.printf("%s -> Composer: %s, Key: %s%n",
                        e.getKey(), e.getValue().get(0), e.getValue().get(1)));
    }
}
