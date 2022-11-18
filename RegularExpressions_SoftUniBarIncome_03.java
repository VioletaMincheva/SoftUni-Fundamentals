package JavaFundamentals;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegularExpressions_SoftUniBarIncome_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String regex = "^%(?<customer>[A-Z][a-z]+)%<(?<product>\\w+)>[|](?<count>\\d+)[|](?<price>\\d+[.]\\d+\\$)$";
        Pattern pattern = Pattern.compile(regex);
        double totalIncome = 0.0;

        String input = scanner.nextLine();
        while (!input.equals("end of shift")) {
            Matcher matcher = pattern.matcher(input);
            if (matcher.find()) {
                String name = matcher.group("customer");
                String product = matcher.group("product");
                int count = Integer.parseInt(matcher.group("count"));
                String price = matcher.group("price");
                price.replaceAll("\\D", "");
                double priceToDouble = Double.parseDouble(price);
                double totalPrice = count * priceToDouble;
                totalIncome += totalPrice;
                System.out.printf("%s: %s - %.2f%n", name, product, totalPrice);
            }
            input = scanner.nextLine();
        }
        System.out.printf("Total income: %.2f", totalIncome);
    }
}