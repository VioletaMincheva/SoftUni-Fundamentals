package JavaFundamentals;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class List_PokemonDoNotGo_09 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> pokemonDistance = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());
        int sumOfRemovableElements = 0;

        while (!pokemonDistance.isEmpty()) {
            int index = Integer.parseInt(scanner.nextLine());
            int removedElement = 0;
            if (index < 0) {
                index = 0;
                removedElement = pokemonDistance.remove(index);
                sumOfRemovableElements += removedElement;
                int lastElement = pokemonDistance.get(pokemonDistance.size() - 1);
                pokemonDistance.add(0, lastElement);
            } else if (index >= pokemonDistance.size()) {
                index = pokemonDistance.size() - 1;
                removedElement = pokemonDistance.remove(index);
                sumOfRemovableElements += removedElement;
                int firstElement = pokemonDistance.get(0);
                pokemonDistance.add(firstElement);
            } else {
                removedElement = pokemonDistance.remove(index);
                sumOfRemovableElements += removedElement;
            }

            for (int i = 0; i < pokemonDistance.size(); i++) {
                int currentElement = pokemonDistance.get(i);
                if (currentElement <= removedElement) {
                    pokemonDistance.set(i, currentElement + removedElement);
                } else {
                    pokemonDistance.set(i, currentElement - removedElement);
                }
            }
        }
        System.out.println(sumOfRemovableElements);
    }
}