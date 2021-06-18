package leetcode.next_permutation;

import java.util.Arrays;

class Solution {
    public void nextPermutation(int[] nums) {
        int i;
        for (i = nums.length - 1 ; i >= 1 ; i--) {
            if (nums[i] > nums[i - 1]) break;
        }

        if (i == 1) {
            nums = Arrays.stream(nums).sorted().toArray();
        }


    }
}