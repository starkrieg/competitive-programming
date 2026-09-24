package leetcode;

public class LC_1876_SubstringSizeThreeDistinctChars {

    public int countGoodSubstrings(String s) {
        // manipulating chars in a loop is faster than manipulating Strings
        char[] arr = s.toCharArray();
        int count = 0;

        for (int i = 0; i < arr.length-2; i++) {
            // Simply check the values
            if (arr[i] != arr[i+1]
                    && arr[i] != arr[i+2]
                    && arr[i+1] != arr[i+2]) {
                count++;
            }
        }

        return count;
    }

}
