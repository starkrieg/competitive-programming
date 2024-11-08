class Solution {
    /**
     * EASY
     * 
     * Write a function to find the longest common prefix 
     * string amongst an array of strings.
     * If there is no common prefix, return an empty string ""
     * 
     * Input: strs = ["flower","flow","flight"]
     * Output: "fl"
     * 
     * @param strs array of strings to be checked
     */
    public String longestCommonPrefix(String[] strs) {
        //if only 1 string, the it is the common prefix
        //if first string is empty, then there should be no valid common prefix
        //so return the first string
        if (strs.length == 1 || "".equals(strs[0])) {
            return strs[0];
        }

        //assume the first word itself is the prefix
        String longestPrefix = strs[0];

        //for every word besides the first, reduce its size to check if it is the prefix
        for (int i = 1; i < strs.length; i++) {
            //if find any empty word, then there is no common prefix
            //so return an empty string as common prefix
            if ("".equals(strs[i])) {
                return "";
            }

            //compare the assumed prefix with the current word
            //if not prefix, discard last letter of the assumed prefix and try again
            //do until the prefix is found, or return empty if the prefix becomes empty
            String currWord = strs[i];
            while (currWord.indexOf(longestPrefix) != 0) {
                longestPrefix = longestPrefix.substring(0, longestPrefix.length() -1);
                if (longestPrefix.isEmpty()) {
                    return "";
                }
            }
        }

        //return the found longest prefix
        return longestPrefix;
    }
}