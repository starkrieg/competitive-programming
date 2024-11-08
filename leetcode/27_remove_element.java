class Solution {
    /**
     * EASY
     * 
     * Given an integer array nums and an integer val, remove all occurrences 
     * of val in nums in-place. The order of the elements may be changed. 
     * Then return the number of elements in nums which are not equal to val.
     * 
     * Consider the number of elements in nums which are not equal to val be k, 
     * to get accepted, you need to do the following things:
     * 
     * Change the array nums such that the first k elements of nums contain 
     * the elements which are not equal to val. The remaining elements of nums 
     * are not important as well as the size of nums.
     * 
     * Return k.
     * 
     * @param nums array of integers
     * @param val integer value to remove from array
     * @return amount of elements left
     */
    public int removeElement(int[] nums, int val) {
        //position of valid element left
        int posIndex = 0;

        //loop over array
        for (int i = 0; i < nums.length; i++) {
            //if current number is valid
            //then move this number to the current position of valid element
            //then increment position of valid element
            if (nums[i] != val) {
                nums[posIndex] = nums[i];
                posIndex++;
            }
        }
        //index of valid element is also amount of valid elements
        return posIndex;
    }
}