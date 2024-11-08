class Solution {
    /**
     * EASY
     * 
     * Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.
     * 
     * Symbol       Value
     * I             1
     * V             5
     * X             10
     * L             50
     * C             100
     * D             500
     * M             1000
     * 
     * For example, 2 is written as II in Roman numeral, 
     * just two ones added together. 12 is written as XII, 
     * which is simply X + II. The number 27 is written as 
     * XXVII, which is XX + V + II.
     * 
     * Given a roman numeral, convert it to an integer.
     * 
     * @param s the roman number
     */
    public int romanToInt(String romanNumber) {
        int charPos = 0;
        int result = 0;
        int length = romanNumber.length();

        //start from the first character
        //check if character is alone, or is a combination
        while (charPos < length) {
            char currentLetter = romanNumber.charAt(charPos);
            char nLetter = (charPos+1 < length) ? s.charAt(charPos+1) : 0;
            char nnLetter = (charPos+2 < length) ? s.charAt(charPos+2) : 0;
            char nnnLetter = (charPos+3 < length) ? s.charAt(charPos+3) : 0;
            //take current letter and 3 next letters
            //if current is V, the number can be
            //V, VI, VII, VIII
            //if its a combination number, skip that position too

            //check all possible combinations below
            switch (currentLetter) {
                case 'M':
                    if (nLetter == 'M' && nnLetter == 'M') {
                        result += 3000;
                        charPos += 2;
                    } else if (nLetter == 'M') {
                        result += 2000;
                        charPos += 1;
                    } else {
                        result += 1000;
                    }
                    break;
                case 'D':
                    if (nLetter == 'C' && nnLetter == 'C' && nnnLetter == 'C') {
                        result += 800;
                        charPos += 3;
                    } else if (nLetter == 'C' && nnLetter == 'C') {
                        result += 700;
                        charPos += 2;
                    } else if (nLetter == 'C') {
                        result += 600;
                        charPos += 1;
                    } else {
                        result += 500;
                    }
                    break;
                case 'C':
                    if (nLetter == 'D') {
                        result += 400;
                        charPos += 1;
                    } else if (nLetter == 'M') {
                        result += 900;
                        charPos += 1;
                    } else if (nLetter == 'C' && nnLetter == 'C') {
                        result += 300;
                        charPos += 2;
                    } else if (nLetter == 'C') {
                        result += 200;
                        charPos += 1;
                    } else {
                        result += 100;
                    }
                    break;
                case 'L':
                    if (nLetter == 'X' && nnLetter == 'X' && nnnLetter == 'X') {
                        result += 80;
                        charPos += 3;
                    } else if (nLetter == 'X' && nnLetter == 'X') {
                        result += 70;
                        charPos += 2;
                    } else if (nLetter == 'X') {
                        result += 60;
                        charPos += 1;
                    } else {
                        result += 50;
                    }
                    break;
                case 'X':
                    if (nLetter == 'L') {
                        result += 40;
                        charPos += 1;
                    } else if (nLetter == 'C') {
                        result += 90;
                        charPos += 1;
                    } else if (nLetter == 'X' && nnLetter == 'X') {
                        result += 30;
                        charPos += 2;
                    } else if (nLetter == 'X') {
                        result += 20;
                        charPos += 1;
                    } else {
                        result += 10;
                    }
                    break;
                case 'V':
                    if (nLetter == 'I' && nnLetter == 'I' && nnnLetter == 'I') {
                        result += 8;
                        charPos += 3;
                    } else if (nLetter == 'I' && nnLetter == 'I') {
                        result += 7;
                        charPos += 2;
                    } else if (nLetter == 'I') {
                        result += 6;
                        charPos += 1;
                    } else {
                        result += 5;
                    }
                    break;
                case 'I':
                    if (nLetter == 'V') {
                        result += 4;
                        charPos += 1;
                    } else if (nLetter == 'X') {
                        result += 9;
                        charPos += 1;
                    } else if (nLetter == 'I' && nnLetter == 'I') {
                        result += 3;
                        charPos += 2;
                    } else if (nLetter == 'I') {
                        result += 2;
                        charPos += 1;
                    } else {
                        result += 1;
                    }
                    break;
            } 

            charPos++;
        }

        //return the number representation of the roman number
        return result;
    }
}