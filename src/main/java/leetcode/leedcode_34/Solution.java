package leetcode.leedcode_34;

import java.util.Arrays;

class Solution {
    public static void main(String[] args) {
        int[] nums = {
                5,7,7,8,8,10
        };

        int target = 8;

        Solution sol = new Solution();

        System.out.println(Arrays.toString(sol.searchRange(nums, target)));
    }


    public int[] searchRange(int[] nums, int target) {
        boolean doesExist = binarySearch(nums, target) != -1;

        if (!doesExist) {
            return new int[]{-1, -1};
        }

        return new int[]{searchLt(nums, target), searchGt(nums, target)};
    }

    private int binarySearch(int[] nums, int target) {
        int lo = 0;
        int hi = nums.length - 1;

        while (lo <= hi) {
            int mid = (lo + hi) / 2;

            if (nums[mid] == target) return mid;
            else if (nums[mid] > target) hi = mid - 1;
            else lo = mid + 1;
        }

        return -1;
    }

    private int searchGt(int[] nums, int target) {
        int lo = 0;
        int hi = nums.length - 1;

        while (lo <= hi) {
            int mid = (lo + hi) / 2;

            if (nums[mid] == target && (mid == nums.length - 1 || nums[mid] != nums[mid + 1])) return mid;
            else if (nums[mid] == target) lo = mid + 1;
            else if (nums[mid] > target) hi = mid - 1;
            else lo = mid + 1;
        }

        return -1;
    }

    private int searchLt(int[] nums, int target) {
        int lo = 0;
        int hi = nums.length - 1;

        while (lo <= hi) {
            int mid = (lo + hi) / 2;

            if (nums[mid] == target && (mid == 0 || nums[mid] != nums[mid - 1])) return mid;
            else if (nums[mid] == target) hi = mid - 1;
            else if (nums[mid] > target) hi = mid - 1;
            else lo = mid + 1;
        }

        return -1;
    }
}
