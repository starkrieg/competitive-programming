package leetcode;

import java.util.ArrayList;
import java.util.List;

public class LC_2786_Visit_Array_Max_Score {

    /**
     * MEDIUM
     *
     * You are given a 0-indexed integer array nums and a positive integer x.
     *
     * You are initially at position 0 in the array and you can visit other positions according to the following rules:
     *
     * If you are currently in position i, then you can move to any position j such that i < j.
     * For each position i that you visit, you get a score of nums[i].
     * If you move from a position i to a position j and the parities of nums[i] and nums[j] differ, then you lose a score of x.
     * Return the maximum total score you can get.
     *
     * Note that initially you have nums[0] points.
     *
     * @param nums array of integers
     * @param target integer target to be found
     */

    public static LC_2786_Visit_Array_Max_Score lc2786VisitArrayMaxScore = new LC_2786_Visit_Array_Max_Score();

    public static void main(String[] args) {
        long result = lc2786VisitArrayMaxScore.maxScore(new int[]{2,3,6,1,9,2}, 5);
        System.out.println((result == 13) ? "PASSED" : "FAILED");

        result = lc2786VisitArrayMaxScore.maxScore(new int[]{2,4,6,8}, 3);
        System.out.println((result == 20) ? "PASSED" : "FAILED");
    }

    public long maxScore(int[] nums, int x) {
        // With the sum of integers, the final numbers is bound to be a long
        long[] idxMaxValues = new long[nums.length];

        boolean isLastNumEven = nums[nums.length-1] % 2 == 0;
        int idxBestEven = (isLastNumEven ? nums.length-1 : -1);
        int idxBestOdd = (!isLastNumEven ? nums.length-1 : -1);

        for (int i = nums.length-2; i >= 0; i--) {
            int currValue = nums[i];
            boolean isCurrValueEven = currValue % 2 == 0;
            long maxIdxValue = 0;

            long evenParityValue = (idxBestEven > -1) ? nums[idxBestEven] + idxMaxValues[idxBestEven] : 0;
            long oddParityValue = (idxBestOdd > -1) ? nums[idxBestOdd] + idxMaxValues[idxBestOdd] : 0;

            if (isCurrValueEven) {
                oddParityValue = oddParityValue - x;
                idxBestEven = i;
            } else {
                evenParityValue = evenParityValue - x;
                idxBestOdd = i;
            }

            maxIdxValue = Math.max(evenParityValue, oddParityValue);

            if (maxIdxValue < 0) {
                maxIdxValue = 0;
            }
            idxMaxValues[i] = maxIdxValue;
        }

        return idxMaxValues[0] + nums[0];
    }

}
