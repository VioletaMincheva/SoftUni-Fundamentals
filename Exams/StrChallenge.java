package Java_Interviews_EntryTest.MentorMate;

import java.util.*;

public class StrChallenge {
    //foursixminustwotwoplusonezero  -> 34 -> threefour
    //fiveminusnine -> -4 -> negativefour

    public static String StringChallenge(String str) {
        // code goes here

        Map<String, String> elements = new HashMap<>();
        elements.put("zero", "0");
        elements.put("one", "1");
        elements.put("two", "2");
        elements.put("three", "3");
        elements.put("four", "4");
        elements.put("five", "5");
        elements.put("six", "6");
        elements.put("seven", "7");
        elements.put("eight", "8");
        elements.put("nine", "9");
        elements.put("minus", "-");
        elements.put("plus", "+");

        StringBuilder expression = new StringBuilder();
        int num1 = 0;
        int num2 = 0;
        char sign = '0';
        int result = 0;
        int counterSign = 0;

        for (int i = 0; i < str.length(); i++) {
            if (elements.containsKey(str.substring(i, i + 3))) {
                String strToAdd = elements.get(str.substring(i, i + 3));
                expression.append(strToAdd);
                i = i + 2;
                continue;
            }
            if (elements.containsKey(str.substring(i, i + 4))) {
                String strToAdd = elements.get(str.substring(i, i + 4));
                if (strToAdd.equals("+")) {
                    if (counterSign == 0) {
                        num1 = Integer.parseInt(expression.toString());
                        counterSign = 1;
                    } else {
                        num2 = Integer.parseInt(expression.toString());
                        switch (sign) {
                            case '+':
                                result = num1 + num2;
                                break;
                            case '-':
                                result = num1 - num2;
                                break;
                        }
                        num1 = result;
                        num2 = 0;
                    }
                    sign = '+';
                    expression.replace(0, expression.length(), "");
                } else {
                    expression.append(strToAdd);
                }
                i = i + 3;
                continue;
            }
            if (elements.containsKey(str.substring(i, i + 5))) {
                String strToAdd = elements.get(str.substring(i, i + 5));
                if (strToAdd.equals("-")) {
                    if (counterSign == 0) {
                        num1 = Integer.parseInt(expression.toString());
                        counterSign = 1;
                    } else {
                        num2 = Integer.parseInt(expression.toString());
                        switch (sign) {
                            case '+':
                                result = num1 + num2;
                                break;
                            case '-':
                                result = num1 - num2;
                                break;
                        }
                        num1 = 0;
                        num2 = 0;
                    }
                    sign = '-';
                    expression.replace(0, expression.length(), "");
                } else {
                    expression.append(strToAdd);
                }
                i = i + 4;
                continue;
            }
        }
        if (!expression.isEmpty()) {
            num2 = Integer.parseInt(expression.toString());
            switch (sign) {
                case '+':
                    result = num1 + num2;
                    break;
                case '-':
                    result = num1 - num2;
            }
            expression.replace(0, expression.length(), "");
        }

        Map<Integer, String> numbersAsString = new HashMap<>();
        numbersAsString.put(0, "zero");
        numbersAsString.put(1, "one");
        numbersAsString.put(2, "two");
        numbersAsString.put(3, "three");
        numbersAsString.put(4, "four");
        numbersAsString.put(5, "five");
        numbersAsString.put(6, "six");
        numbersAsString.put(7, "seven");
        numbersAsString.put(8, "eight");
        numbersAsString.put(9, "nine");
        //result = 34
        char[] resultAsCharArray = String.valueOf(result).toCharArray();
        if (result < 0) {
            expression.append("negative");
        }
        for (int i = 0; i < resultAsCharArray.length; i++) {
            int currentNum = Character.getNumericValue(resultAsCharArray[i]);
            if (numbersAsString.containsKey(currentNum)) {
                String toAppend = numbersAsString.get(currentNum);
                expression.append(toAppend);
            }
        }


        return expression.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(StringChallenge(scanner.nextLine()));

    }
}
