package leetcode.longest_common_prefix

class Solution {
    fun longestCommonPrefix(strs: Array<String>): String {
        var result = ""
        var idx = 0

        val smallest = strs.minBy { it.length }!!

        while (idx < smallest.length) {
            if (strs.all { it[idx] == smallest[idx] }) {
                result += smallest[idx]
                idx++
            }
            else {
                break
            }
        }

        return result
    }
}