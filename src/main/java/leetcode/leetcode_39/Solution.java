package leetcode.leetcode_39;

import java.util.*;

class Solution {
    public static void main(String[] args) {
        int[] candidates = {2,3,5};
        int target = 8;

        int[] c2 = {1};
        int t2 = 1;

        int[] c3 = {10};
        int t3 = 1;

        Solution sol = new Solution();

        System.out.println(sol.combinationSum(candidates, target));
        System.out.println(sol.combinationSum(c2, t2));
        System.out.println(sol.combinationSum(c3, t3));
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (target == 0) return result;

        for (int i = 0 ; i < candidates.length ; i++) {
            if (candidates[i] < target) {
                List<List<Integer>> partialResult = combinationSum(candidates, target - candidates[i]);

                for (List<Integer> integers : partialResult) {
                    integers.add(candidates[i]);
                    result.add(integers);
                }
            }
            else if (candidates[i] == target) {
                List<Integer> newList = new ArrayList<>();
                newList.add(candidates[i]);
                result.add(newList);
            }
        }

        Set<List<Integer>> ret = new HashSet<>();

        for (int i = 0 ; i < result.size() ; i++) {
            List<Integer> element = result.get(i);

            element.sort(Comparator.comparingInt(o -> o));

            ret.add(element);
        }

        return List.copyOf(ret);
    }
}