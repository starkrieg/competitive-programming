class Solution {
    /**
     * EASY
     * 
     * Given an integer x, return true if x is a palindrome, 
     * and false otherwise.
     * @param x the number to be checked
     */
    public boolean isPalindrome(int x) {
        //if x below 0, then the numbes has minus sign
        //with the negative sign on the start,
        //it cannot be a palindrome
        if (x < 0) {
            return false;
        }

        //will try to reverse the value x
        //and then compare both values
        //if they are the same, then x is a palindrome

        int temp = x;
        int reversed = 0;

        //temp starts as x, and while it has value, 
        //reverse its digits
        while (temp != 0) {
            //mod of 10 is the remainder of a division by 10
            //if x is 1234, division return 123,4
            //the remainder is what comes after the decimal point
            //so remainder = 4
            //so this will add the last digit of temp to the reversed
            //the old reverse is times 10, which moves the
            //old value of the reversed an extra left pos
            //all this so every loop will add the right most digit of temp 
            //to the right most post of reversed
            reversed = (reversed * 10) + (temp % 10);
            //divide temp by 10, to discard that last digit from it
            temp /= 10;
        }

        //simply compare x with the reversed x
        return (x == reversed);
    }
}