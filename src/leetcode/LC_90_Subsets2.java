package leetcode;

import java.util.*;

public class LC_90_Subsets2 {

    public static void main(String[] args) {
        LC_90_Subsets2 lc90Subsets2 = new LC_90_Subsets2();

        int[] nums1 = new int[]{2, 1, 2};
        System.out.println(lc90Subsets2.subsetsWithDup(nums1));
        System.out.println(Arrays.stream(nums1).boxed().toList());

        //int[] nums2 = new int[]{1, 2, 2, 2, 3, 3, 6, 7};
        //System.out.println(lc90Subsets2.subsetsWithDup(nums2));
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> outputSubsets = new ArrayList<>();
        // always add empty array
        outputSubsets.add(new ArrayList<>());

        // Avoid sorting the input array directly, as it modifies data that is outside the scope of the method
        // Arrays.sort(nums); // AVOID THIS
        // sort the input array on a new var, without modifying the input
        int[] sortedInput = Arrays.stream(nums).sorted().toArray();

        // loop over the input numbers
        // for each number, compare it with all already existing subsets to see if a new/different subset can be created
        // add to the output list the new subsets
        // watch out for
        // - do not modify the existing subsets, make copies of them to create the new ones
        // - do not check against the subsets just created, it will cause a loop
        for (int num : sortedInput) {
            int existingSubsetSize = outputSubsets.size();
            for (int i = 0; i < existingSubsetSize; i++) {
                List<Integer> list = new ArrayList<>(outputSubsets.get(i));
                list.add(num);
                if (!outputSubsets.contains(list)) {
                    outputSubsets.add(list);
                }
            }
        }

        return outputSubsets;
    }

}
