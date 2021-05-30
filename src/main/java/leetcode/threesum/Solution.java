package leetcode.threesum;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Set;

class Solution {
    public static void main(String[] args) {
        Solution sol = new Solution();

        int[] nums = {-1, 0, 1, 2, -1, -4};

        System.out.println(sol.threeSum(nums));
    }

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0 ; i < nums.length - 2 ; i++) {
            for (int j = i + 1 ; j < nums.length - 1 ; j++) {
                for (int k = j + 1 ; k < nums.length ; k++) {
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        List<Integer> comb = new ArrayList<>();
                        comb.add(nums[i]);
                        comb.add(nums[j]);
                        comb.add(nums[k]);
                        result.add(comb);
                    }
                }
            }
        }

        for (List<Integer> ls : result) {
            ls.sort(Comparator.comparingInt(o -> o));
        }

        return result;
    }
}
