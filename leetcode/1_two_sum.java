class Solution {
    /**
     * EASY
     * 
     * Given an array of integers nums and an integer target, 
     * return indices of the two numbers such that they add up to target.
     * You may assume that each input would have exactly one solution, 
     * and you may not use the same element twice.
     * You can return the answer in any order.
     * 
     * @param nums array of integers
     * @param targer integer target to be found
     */
    public int[] twoSum(int[] nums, int target) {
        //iterate over array of integers
        for (int i = 0; i < nums.length; i++) {
            //from the position i, walk a loop for all numbers after it, that being j
            //so that on next loop i, the numbers before it can be ignored
            for (int j = (i+1); j < nums.length; j++) {
                //check if sum of array position i and j is target
                //if is target, return i and j and end all loops
                if ((nums[i] + nums[j]) == target) {
                    return new int[]{i, j};
                }
            }
        }
        //no two numbers on the array result on target
        return new int[]{};
    }
}