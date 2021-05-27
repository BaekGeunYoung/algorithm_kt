package leetcode.atoi

import java.lang.NumberFormatException

fun main() {
    val sol = Solution()

    val s = "-91283472332"
    println(sol.myAtoi(s))
}

class Solution {
    fun myAtoi(s: String): Int {
        val regex = "([\\s]*)([-+]?)([\\d]+)(.*)".toRegex()

        if (regex.matches(s)) {
            val groups = regex.find(s)!!.groupValues

            return try {
                val int = groups[3].toInt()

                if (groups[2] == "+" || groups[2] == "") int
                else int * -1
            } catch (e: NumberFormatException) {
                if (groups[2] == "+" || groups[2] == "") Int.MAX_VALUE
                else Int.MIN_VALUE
            }
        }

        return 0
    }
}