package JavaFundamentals;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MidExam_ShoppingList_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> shoppingList = Arrays.stream(scanner.nextLine().split("!")).collect(Collectors.toList());
        String command = scanner.nextLine();

        while (!command.equals("Go Shopping!")) {
            List<String> tokens = Arrays.stream(command.split("\\s+")).collect(Collectors.toList());
            String currentCommand = tokens.get(0);
            String item = tokens.get(1);
            switch (currentCommand) {
                case "Urgent":
                    if (!shoppingList.contains(item)) {
                        shoppingList.add(0, item);
                    }
                    break;
                case "Unnecessary":
                    shoppingList.remove(item);
                    break;
                case "Correct":
                    String newItem = tokens.get(2);
                    if (shoppingList.contains(item)){
                       int indexOfOldItem = shoppingList.indexOf(item);
                        shoppingList.set(indexOfOldItem, newItem);
                    }
                    break;
                case "Rearrange":
                    if(shoppingList.remove(item)){
                        shoppingList.add(item);
                    }
                    break;
            }
            command = scanner.nextLine();
        }

        String finalShoppingList = shoppingList.stream().collect(Collectors.joining(", ")).toString();
        System.out.print(finalShoppingList.trim());
    }
}
