package leetcode.threesumclosest

import kotlin.math.abs

fun threeSumClosest(nums: IntArray, target: Int): Int {
    var result = 10001

    for (i in 0 until nums.size - 2) {
        for (j in i + 1 until nums.size - 1) {
            for (k in j + 1 until nums.size) {
                val sum = nums[i] + nums[j] + nums[k]
                val diff = abs(sum - target)
                if (diff < abs(result - target)) {
                    result = sum
                }
            }
        }
    }

    return result
}