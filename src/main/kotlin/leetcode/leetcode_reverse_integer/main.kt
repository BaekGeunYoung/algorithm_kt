package leetcode.leetcode_reverse_integer

import java.lang.NumberFormatException
import kotlin.math.abs

fun reverse(x: Int): Int {
    val isNegative = x < 0

    val absX = abs(x)

    try {
        val reversed = absX.toString().reversed()

        return if (isNegative) "-${reversed}".toInt() else reversed.toInt()
    } catch (e: NumberFormatException) {
        return 0
    }
}
