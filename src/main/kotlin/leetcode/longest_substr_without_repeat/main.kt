package leetcode.longest_substr_without_repeat

fun main() {
    val str = "abcabcbb"
    println(Solution().lengthOfLongestSubstring(str))
}

class Solution {
    fun lengthOfLongestSubstring(s: String): Int {
        var result = 0

        for (i in s.indices) {
            val map = mutableMapOf<Char, Unit>()

            var longestLength = s.length - i

            for (j in (i until s.length)) {
                val c = s[j]

                if (map[c] == null) {
                    map[c] = Unit
                }
                else {
                    longestLength = j - i
                    break
                }
            }

            if (result < longestLength) result = longestLength
        }

        return result
    }
}