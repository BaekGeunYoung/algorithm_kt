package leetcode.roman_to_int

class Solution {
    /**
     * I, V, X, L, C, D, M
     * IV, IX
     * XL, XC,
     * CD, CM
     */
    fun romanToInt(s: String): Int {
        var i = 0
        var result = 0

        while (i < s.length) {
            val curr = s[i]

            if (i == s.length - 1) {
                result += romanCharToInt(curr)
                break
            }

            val next = s[i+1]

            when (curr + next.toString()) {
                "IV" -> {
                    result += 4
                    i++
                }
                "IX" -> {
                    result += 9
                    i++
                }
                "XL" -> {
                    result += 40
                    i++
                }
                "XC" -> {
                    result += 90
                    i++
                }
                "CD" -> {
                    result += 400
                    i++
                }
                "CM" -> {
                    result += 900
                    i++
                }
                else -> {
                    result += romanCharToInt(curr)
                }
            }
            i++
        }

        return result
    }

    private fun romanCharToInt(char: Char): Int = when (char) {
        'I' -> 1
        'V' -> 5
        'X' -> 10
        'L' -> 50
        'C' -> 100
        'D' -> 500
        'M' -> 1000
        else -> throw Exception()
    }
}