package JavaFundamentals;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class MapsLambdaStreamAPI_LegendaryFarming_ex7 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Map<String, Integer> legendaryItems = new HashMap<>();
        legendaryItems.put("shards", 0);
        legendaryItems.put("fragments", 0);
        legendaryItems.put("motes", 0);
        Map<String, Integer> junkItems = new LinkedHashMap<>();

        boolean isWin = false;

        while (!isWin) {
            String[] input = scanner.nextLine().split("\\s+");
            for (int i = 0; i < input.length; i += 2) {
                if (!isWin) {
                    int quantity = Integer.parseInt(input[i]);
                    String material = input[i + 1].toLowerCase();
                    switch (material) {
                        case "shards":
                        case "fragments":
                        case "motes":
                            legendaryItems.put(material, legendaryItems.get(material) + quantity);
                            for (Map.Entry<String, Integer> entry : legendaryItems.entrySet()) {
                                if (entry.getValue() >= 250) {
                                    isWin = true;
                                    switch (entry.getKey()) {
                                        case "shards":
                                            System.out.println("Shadowmourne obtained!");
                                            legendaryItems.put(entry.getKey(), entry.getValue() - 250);
                                            break;
                                        case "fragments":
                                            System.out.println("Valanyr obtained!");
                                            legendaryItems.put(entry.getKey(), entry.getValue() - 250);
                                            break;
                                        case "motes":
                                            System.out.println("Dragonwrath obtained!");
                                            legendaryItems.put(entry.getKey(), entry.getValue() - 250);
                                            break;
                                    }
                                }
                            }
                            break;
                        default:
                            addItems(material, quantity, junkItems);
                            break;
                    }
                }
            }
        }
        System.out.print(outputString(legendaryItems, junkItems));
    }

    public static void addItems(String material, int quantity, Map<String, Integer> items) {
        if (!items.containsKey(material)) {
            items.put(material, quantity);
        } else {
            items.put(material, items.get(material) + quantity);
        }
    }

    public static String outputString(Map<String, Integer> legendaryItems, Map<String, Integer> junkItems) {
        StringBuilder sb = new StringBuilder();
        sb.append("shards: ").append(legendaryItems.get("shards")).append(System.lineSeparator())
                .append("fragments: ").append(legendaryItems.get("fragments")).append(System.lineSeparator())
                .append("motes: ").append(legendaryItems.get("motes")).append(System.lineSeparator());

        for (Map.Entry<String, Integer> junkEntry : junkItems.entrySet()) {
            sb.append(junkEntry.getKey()).append(": ").append(junkEntry.getValue()).append(System.lineSeparator());
        }
        return sb.toString().trim();
    }
}
