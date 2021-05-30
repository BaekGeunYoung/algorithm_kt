package leetcode.int_to_roman

class Solution {
    fun intToRoman(num: Int): String {
        var curr = num

        var delimiter = 10

        var result = ""
        while (curr != 0) {
            val target = curr % delimiter
            curr -= target

            result = toRoman(target, delimiter) + result
            delimiter *= 10

        }

        return result
    }

    private fun toRoman(target: Int, delimiter: Int): String {
        return if (delimiter == 10) convert1(target)
        else if (delimiter == 100) convert10(target)
        else if (delimiter == 1000) convert100(target)
        else convert1000(target)
    }

    private fun convert1(lsd: Int): String =
        when (lsd) {
            0 -> ""
            1 -> "I"
            2 -> "II"
            3 -> "III"
            4 -> "IV"
            5 -> "V"
            6 -> "VI"
            7 -> "VII"
            8 -> "VIII"
            else -> "IX"
        }

    private fun convert10(lsd: Int): String =
        when (lsd) {
            0 -> ""
            10 -> "X"
            20 -> "XX"
            30 -> "XXX"
            40 -> "XL"
            50 -> "L"
            60 -> "LX"
            70 -> "LXX"
            80 -> "LXXX"
            else -> "XC"
        }


    private fun convert100(lsd: Int): String =
        when (lsd) {
            0 -> ""
            100 -> "C"
            200 -> "CC"
            300 -> "CCC"
            400 -> "CD"
            500 -> "D"
            600 -> "DC"
            700 -> "DCC"
            800 -> "DCCC"
            else -> "CM"
        }

    private fun convert1000(lsd: Int): String =
        when (lsd) {
            0 -> ""
            1000 -> "M"
            2000 -> "MM"
            else -> "MMM"
        }
}
