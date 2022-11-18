package JavaFundamentals;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegularExpressions_Furniture_01 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String regex = "^>>(?<furnitureName>[A-z]+)<<(?<price>\\d+|\\d+.\\d*)!(?<quantity>\\d+)$";
        Pattern pattern = Pattern.compile(regex);
        Double totalMoney = 0.0;
        List<String> soldFurniture = new ArrayList<>();

        while (!input.equals("Purchase")) {
            Matcher matcher = pattern.matcher(input);
            if (matcher.find()) {
                soldFurniture.add(matcher.group("furnitureName"));
                Double price = Double.parseDouble(matcher.group("price"));
                Integer quantity = Integer.parseInt(matcher.group("quantity"));
                totalMoney += price * quantity;
            }
            input = scanner.nextLine();
        }
        System.out.println("Bought furniture:");
        soldFurniture.forEach(System.out::println);
        System.out.printf("Total money spend: %.2f", totalMoney);
    }
}
