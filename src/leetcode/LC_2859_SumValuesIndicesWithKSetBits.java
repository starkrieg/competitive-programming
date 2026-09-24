package leetcode;

import java.util.ArrayList;
import java.util.List;

public class LC_2859_SumValuesIndicesWithKSetBits {

    public static void main(String[] args) {
        LC_2859_SumValuesIndicesWithKSetBits instance = new LC_2859_SumValuesIndicesWithKSetBits();
        List<Integer> nums;
        int k;
        long startMillis, endMillis;
        int res;

        //test 1
        nums = List.of(5,10,1,5,2);
        k = 1;
        startMillis = System.currentTimeMillis();
        res = instance.sumIndicesWithKSetBits(nums, k);
        endMillis = System.currentTimeMillis();
        System.out.println("Test 1: " + (endMillis-startMillis) +  " ms");
        if (13 != res) throw new AssertionError();

        //test 2
        nums = List.of(4,3,2,1);
        k = 2;
        startMillis = System.currentTimeMillis();
        res = instance.sumIndicesWithKSetBits(nums, k);
        endMillis = System.currentTimeMillis();
        System.out.println("Test 2: " + (endMillis-startMillis) +  " ms");
        if (1 != res) throw new AssertionError();

        //test 3 - max edge case
        //1 <= nums.length <= 1000
        //1 <= nums[i] <= 105
        //0 <= k <= 10
        nums = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            nums.add(100000);
        }
        k = 10;
        startMillis = System.currentTimeMillis();
        res = instance.sumIndicesWithKSetBits(nums, k);
        endMillis = System.currentTimeMillis();
        System.out.println("Test 3: " + (endMillis-startMillis) +  " ms");
        if (0 != res) throw new AssertionError();

        System.out.println("Success!");
    }

    public int sumIndicesWithKSetBits(List<Integer> nums, int k) {
        int resSum = 0;
        for (int i = 0; i < nums.size(); i++) {
            if (Integer.bitCount(i) == k) {
                resSum += nums.get(i);
            }
        }

        return resSum;
    }

}
