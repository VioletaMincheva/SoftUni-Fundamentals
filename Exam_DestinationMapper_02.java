package JavaFundamentals;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Exam_DestinationMapper_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String places = scanner.nextLine();
        String regex = "([=|\\/])(?<location>[A-Z][A-Za-z]{2,})\\1";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(places);

        List<String> allValidPlaces = new ArrayList<>();
        int travelPoints = 0;

        while (matcher.find()) {
            String currentPlace = matcher.group("location");
            allValidPlaces.add(currentPlace);
            travelPoints += currentPlace.length();
        }
        System.out.println("Destinations: " + String.join(", ", allValidPlaces));
        System.out.println("Travel Points: " + travelPoints);
    }
}
