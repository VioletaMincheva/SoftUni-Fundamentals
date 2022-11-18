package JavaFundamentals;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegularExpressions_Race_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Integer> racers = new LinkedHashMap<>();
        String[] names = scanner.nextLine().split(", ");
        for (int i = 0; i < names.length; i++) {
            racers.putIfAbsent(names[i], 0);
        }
        String command = scanner.nextLine();
        while (!command.equals("end of race")) {
            Pattern pattern = Pattern.compile("[A-Za-z]");
            Matcher matcher = pattern.matcher(command);
            String nameRacer = "";
            while (matcher.find()) {
                nameRacer += matcher.group();
            }
            if (racers.containsKey(nameRacer)) {
                pattern = Pattern.compile("\\d");
                matcher = pattern.matcher(command);
                int distance = 0;
                while (matcher.find()) {
                    distance += Integer.parseInt(matcher.group());
                }
                racers.put(nameRacer, racers.get(nameRacer) + distance);
            }
            command = scanner.nextLine();
        }
        List<String> finalists = new ArrayList<>();

        racers.entrySet()
                .stream()
                .sorted((a, b) -> b.getValue() - a.getValue())
                .limit(3)
                .forEach(r -> finalists.add(r.getKey()));

        System.out.printf("1st place: %s%n2nd place: %s%n3rd place: %s",
                finalists.get(0), finalists.get(1), finalists.get(2));

    }
}
