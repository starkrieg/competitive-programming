package hackerearth;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HE_Possible_PINs_Ordered {

    /*
    * A coding test for company BairesDev as backend engineer challenge
    * */

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        String[] output = solution("5555555555");
        long end = System.currentTimeMillis();
        System.out.println("Count: " + output.length);
        System.out.println("Time: " + (end-start)/1000 +  "ms");
    }

        static String[] solution(String pin){
        // Write your code here

//        int[][] keyboard = new int[]{
//            new int[]{1, 2, 3},
//            new int[]{4, 5, 6},
//            new int[]{7, 8, 9},
//            new int[]{-1, 0, -1},
//        };

        char[] digitArr = pin.toCharArray();

        char[][] optionsArr = new char[digitArr.length][1];

        for (int i = 0; i < digitArr.length; i++) {
            char digit = digitArr[i];

            //every digit has a fixed list of ordered options
            switch (digit) {
                case '1':
                    optionsArr[i] = new char[]{'1', '2', '4'};
                    break;
                case '2':
                    optionsArr[i] = new char[]{'1', '2', '3', '5'};
                    break;
                case '3':
                    optionsArr[i] = new char[]{'2', '3', '6'};
                    break;
                case '4':
                    optionsArr[i] = new char[]{'1', '4', '5', '7'};
                    break;
                case '5':
                    optionsArr[i] = new char[]{'2', '4', '5', '6', '8'};
                    break;
                case '6':
                    optionsArr[i] = new char[]{'3', '5', '6', '9'};
                    break;
                case '7':
                    optionsArr[i] = new char[]{'4', '7', '8'};
                    break;
                case '8':
                    optionsArr[i] = new char[]{'0', '5', '7', '8', '9'};
                    break;
                case '9':
                    optionsArr[i] = new char[]{'6', '8', '9'};
                    break;
                case '0':
                    optionsArr[i] = new char[]{'0', '8'};
                    break;
            }
        }
        // now create list of pins
        List<String> listOfPossiblePins = new ArrayList<>();
        listOfPossiblePins.add("");

        for (int i = 0; i < optionsArr.length; i++) {
            List<String> newListOfPossiblePins = new ArrayList<>();
            for (char digit : optionsArr[i]) {
                for (String currPin : listOfPossiblePins) {
                    String newPin = currPin + digit;
                    newListOfPossiblePins.add(newPin);
                }
            }
            listOfPossiblePins = newListOfPossiblePins;
        }

        Collections.sort(listOfPossiblePins);

        return listOfPossiblePins.toArray(new String[0]);


    }

}
