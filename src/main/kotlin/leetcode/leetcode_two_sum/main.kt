package leetcode.leetcode_two_sum

fun twoSum(nums: IntArray, target: Int): IntArray {
    for (i in (nums.indices)) {
        val num1 = nums[i]
        for (j in (i + 1 until nums.size)) {
            val num2 = nums[j]

            if (num1 + num2 == target) return intArrayOf(i, j)
        }
    }

    throw Exception()
}