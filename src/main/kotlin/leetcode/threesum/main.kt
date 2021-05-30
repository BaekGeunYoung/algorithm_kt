package leetcode.threesum

fun main() {
    val nums = intArrayOf(-1,0,1,2,-1,-4)
    println(threeSum2(nums))
}

fun threeSum(nums: IntArray): List<List<Int>> {
    val result: MutableList<List<Int>> = mutableListOf()

    for (i in 0 until nums.size - 2) {
        for (j in i + 1 until nums.size - 1) {
            for (k in j + 1 until nums.size) {
                if (nums[i] + nums[j] + nums[k] == 0) {
                    result.add(listOf(nums[i], nums[j], nums[k]).sorted())
                }
            }
        }
    }

    return result.toSet().toList()
}

fun threeSum2(nums: IntArray): List<List<Int>> {
    val positives = nums.filter { it >= 0 }
    val positivesMap = positives.associateWith {  }
    val negatives = nums.filter { it < 0 }
    val negativesMap = negatives.associateWith {  }

    val result: MutableList<List<Int>> = mutableListOf()

    for (i in 0 until positives.size - 1) {
        for (j in i + 1 until positives.size) {
            val twoSum = positives[i] + positives[j]

            if (negativesMap[-twoSum] != null) {
                result.add(listOf(positives[i], positives[j], -twoSum).sorted())
            }
        }
    }

    for (i in 0 until negatives.size - 1) {
        for (j in i + 1 until negatives.size) {
            val twoSum = negatives[i] + negatives[j]

            if (positivesMap[-twoSum] != null) {
                result.add(listOf(negatives[i], negatives[j], -twoSum).sorted())
            }
        }
    }

    if (positives.filter { it == 0 }.size >= 3) {
        result.add(listOf(0, 0, 0))
    }

    return result.toSet().toList()
}