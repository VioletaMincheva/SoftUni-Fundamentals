package Java_Interviews_EntryTest.MentorMate;

import java.util.*;

class Array_challenge1 {

    public static int ArrayChallenge(int[] arr) {
        // code goes here
        int sum = 0;
        List<Integer> largestNumbers = new ArrayList<>();
        for(int i = 0; i < arr.length; i++){
            largestNumbers.add(arr[i]);
        }

        if(arr.length <= 4){
            sum = Arrays.stream(arr).sum();
        } else {
            int countOfUnnecessaryNumbers = arr.length - 4;
            int minNumber = Arrays.stream(arr).min().getAsInt();
            if (countOfUnnecessaryNumbers == 1){
                if (minNumber != 0){
                    for(int i = 0; i < largestNumbers.size(); i++){
                        if (largestNumbers.get(i) == minNumber){
                            largestNumbers.remove(i);
                            countOfUnnecessaryNumbers--;
                        }
                        break;
                    }
                }
            } else {
                if (minNumber != 0){
                    for(int i = 0; i < largestNumbers.size(); i++){
                        if (largestNumbers.get(i) == minNumber){
                            largestNumbers.remove(i);
                            countOfUnnecessaryNumbers--;
                        }
                        break;
                    }
                }
                countOfUnnecessaryNumbers--;
                while(countOfUnnecessaryNumbers > 0){
                    int currentMinNumber = Collections.min(largestNumbers);
                    largestNumbers.remove(currentMinNumber);
                    countOfUnnecessaryNumbers--;
                }
            }
            for(Integer currentNumber : largestNumbers){
                sum += currentNumber;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        // keep this function call here
        Scanner s = new Scanner(System.in);
       int[] arr = Arrays.stream(s.nextLine().split(", ")).mapToInt(Integer::parseInt).toArray();
        System.out.print(ArrayChallenge(arr));
    }

}
