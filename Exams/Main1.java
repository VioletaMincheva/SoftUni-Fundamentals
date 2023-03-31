package Java_Interviews_EntryTest.MentorMate;

import java.util.*;

class Main1 {

    public static String StringChallenge(String str) {
        // code goes here
        int counter = 0;
        StringBuilder sb = new StringBuilder();

        for(int i =0; i < str.length(); i++){
            char currentChar = str.charAt(i);
            counter++;
            for(int j = i + 1 ; j < str.length(); j++){
                char nextChar = str.charAt(j);
                if (Character.compare(currentChar, nextChar) == 0){
                    counter++;
                }else{
                    sb.append(counter).append(currentChar);
                    i=j-1;
                    j=str.length();
                    counter = 0;
                }
            }
        }
      return sb.toString();
    }

    public static void main (String[] args) {
        // keep this function call here
        Scanner s = new Scanner(System.in);
        System.out.print(StringChallenge(s.nextLine()));
    }

}
