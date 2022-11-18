package JavaFundamentals;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class AssociativeArrays_CompanyUsers_08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, ArrayList<String>> companyInfo = new LinkedHashMap<>();
        String input = scanner.nextLine();

        while (!input.equals("End")) {
            String[] tokens = input.split(" -> ");
            String name = tokens[0];
            String id = tokens[1];
            companyInfo.putIfAbsent(name, new ArrayList<>());
            if (!companyInfo.get(name).contains(id)) {
                companyInfo.get(name).add(id);
            }
            input = scanner.nextLine();
        }
        for (Map.Entry<String, ArrayList<String>> entry : companyInfo.entrySet()) {
            System.out.println(entry.getKey());
            entry.getValue().forEach(e -> System.out.printf("-- %s%n", e));
        }
    }
}
