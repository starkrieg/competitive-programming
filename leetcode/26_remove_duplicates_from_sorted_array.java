class Solution {
    /**
     * EASY
     * 
     * Given an integer array nums sorted in non-decreasing order, 
     * remove the duplicates in-place such that each unique element appears only once. 
     * The relative order of the elements should be kept the same. 
     * Then return the number of unique elements in nums.
     * 
     * Consider the number of unique elements of nums to be k, to get accepted, 
     * you need to do the following things:
     * 
     * Change the array nums such that the first k elements of nums contain 
     * the unique elements in the order they were present in nums initially. 
     * The remaining elements of nums are not important as well as the size of nums.
     * Return k.
     * 
     * @param nums array of integer
     */
    public int removeDuplicates(int[] nums) {
        //first unique integer is at position 0
        //so start checking indexes from 1
        int uniqueIndex = 1;

        //start loop from pos 1, until all nums are checked
        for (int i = 1; i < nums.length; i++) {
            //if current number is different than last num
            //then move this number to the unique index
            //then increment unique index position
            if (nums[i] != nums[i-1]) {
                nums[uniqueIndex] = nums[i];
                uniqueIndex++;
            }
        }

        //unique index position is the number of unique elements
        return uniqueIndex;
    }
}