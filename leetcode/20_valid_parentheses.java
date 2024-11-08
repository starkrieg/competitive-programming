class Solution {
    /***
     * EASY
     * 
     * Given a string s containing just the characters '(', ')', '{', '}', 
     * '[' and ']', determine if the input string is valid.
     * 
     * An input string is valid if:
     * 
     * Open brackets must be closed by the same type of bracketinput.
     * Open brackets must be closed in the correct order.
     * Every close bracket has a corresponding open bracket of the same type.
     * 
     * @param s the string to be validated
     */
    public boolean isValid(String input) {
        // a stack to hold the open brackets in sequence
        Stack<Character> parenthesisStack = new Stack<>();

        // iterate over character on input
        for (char c : input.toCharArray()) {
            // if a type of open bracket, add to the stack
            if (c == '(' || c == '[' || c == '{') {
                parenthesisStack.add(c);
            } else {
                // if not an open bracket, the it is a closing one
                // if closing, but empty openings on stack, then invalid string
                if (parenthesisStack.isEmpty()) {
                    return false;
                }
                // opening stack is not empty
                // check if closing correct bracket
                Character poppedSymbol = parenthesisStack.pop();
                switch (c) {
                    // check if last opening bracket match with current character on string
                    // if they dont match, string is invalid
                    // otherwise, keep iterating
                    case ')':
                        if (poppedSymbol != '(') {
                            return false;
                        }
                        break;
                    case ']':
                        if (poppedSymbol != '[') {
                            return false;
                        }
                        break;
                    case '}':
                        if (poppedSymbol != '{') {
                            return false;
                        }
                        break;
                }
            }
        }
        // if reached here, then found all matching brackets
        // lastly, check if stack is empty
        // if not empty, then last char is an opening, making the string invalid
        return parenthesisStack.isEmpty();
    }
}