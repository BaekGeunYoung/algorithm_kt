package leetcode.search_in_rotated_arr;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        Solution sol = new Solution();

        int[] arr = {1, 3};
        int target = 0;

        System.out.println(sol.search(arr, target));

//        System.out.println(sol.binarySearch(arr, 3));
    }

    public int search(int[] nums, int target) {
        int pivotIndex = findMinIndex(nums);

        int first = binarySearch(Arrays.copyOfRange(nums, 0, pivotIndex), target);

        if (first != -1) return first;

        int second = binarySearch(Arrays.copyOfRange(nums, pivotIndex, nums.length), target);

        if (second == -1) return -1;
        return second + pivotIndex;
    }

    private int findMinIndex(int[] a){
        int s = 0;
        int e = a.length - 1;

        while(s<e){
            int mid=(s+e)/2;
            if(a[mid]>a[e]) s=mid+1;
            else e=mid;
        }
        return s;
    }

    int binarySearch(int[] sortedArr, int target) {
        int mid;
        int left = 0;
        int right = sortedArr.length - 1;

        while (right >= left) {
            mid = (right + left) / 2;

            if (target == sortedArr[mid]) {
                return mid;
            }
            if (target < sortedArr[mid]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return -1;
    }
}