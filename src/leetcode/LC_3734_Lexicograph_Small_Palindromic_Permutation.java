package leetcode;

import java.util.*;

public class LC_3734_Lexicograph_Small_Palindromic_Permutation {

    //INCOMPLETE

    //Difficulty: Hard

    private static final LC_3734_Lexicograph_Small_Palindromic_Permutation object = new LC_3734_Lexicograph_Small_Palindromic_Permutation();

    public static void main(String[] args) {
        //test cases
        executeTest("baba", "abba", "baab"); // failing
        executeTest("baba", "bbaa", "");
        executeTest("abc", "abb", "");
        executeTest("aac", "abb", "aca"); // failing
        executeTest("a", "a", "");
        executeTest("b", "a", "b");
    }

    private static void executeTest(String input, String target, String expectedOutput) {
        String output = object.lexPalindromicPermutation(input, target);
        if (!expectedOutput.equals(output)) {
            System.out.printf("Error for input/target (%s, %s), expected (%s) but got (%s) \n", input, target, expectedOutput, output);
        }
    }

    public String lexPalindromicPermutation(String s, String target) {
        List<String> permutations = new ArrayList<>();
        // size 1 = only 1 permutation
        if (s.length() == 1) {
            permutations.add(s);
        } else {
            //check how many of each letter appear here
            char[] allLetters = s.toCharArray();
            Map<Character, Integer> letterCount = new HashMap<>();
            for (char letter : allLetters) {
                if (letterCount.containsKey(letter)) {
                    letterCount.put(letter, letterCount.get(letter)+1);
                } else {
                    letterCount.put(letter, 1);
                }
            }
            // check letter counts
            // for palindromes, only 1 letter is allowed to be 'odd'
            int oddLetters = 0;
            Character[][] letterArray = new Character[letterCount.size()][2];
            int arrIdx = 0;

            for (Character letter : letterCount.keySet()) {
                letterArray[arrIdx][0] = letter;
                int letterAmount = letterCount.get(letter);
                arrIdx++;

                // if its odd
                if (letterAmount % 2 == 1) {
                    oddLetters++;
                    if (oddLetters > 2) {
                        break;
                    }
                }
            }

            // multiple letters with odd counts = cannot make a palindrome
            // meaning output is empty string
            if (oddLetters > 2) {
                return "";
            } else if (oddLetters == 1) {
                //if 1 odd letter, then S length should also be odd,
                // so the odd letter stays in the central pos
                if (s.length() % 2 == 0) {
                    //even length, cannot be palindrome
                    return "";
                }


            }


        }
        // add target to list of permutations
        permutations.add(target);
        // sort
        Collections.sort(permutations);
        // find what permutation comes after target
        int indexOfTarget = permutations.lastIndexOf(target);
        if (indexOfTarget == permutations.size()-1) {
            //target is last of list, no permutation greater
            return "";
        } else {
            //target is not last, so get what comes after it
            return permutations.get(indexOfTarget+1);
        }

    }

}
