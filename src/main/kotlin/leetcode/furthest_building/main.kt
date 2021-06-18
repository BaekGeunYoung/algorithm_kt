package leetcode.furthest_building

fun main() {
    val heights = intArrayOf(1,5,1,2,3,4,10000)
    val bricks = 4
    val ladders = 1

    val sol = Solution()

    println(sol.furthestBuilding(heights, bricks, ladders))
}

class Solution {
    fun furthestBuilding(heights: IntArray, bricks: Int, ladders: Int): Int {
        val heightDiffs = (0 until heights.size - 1).map { heights[it + 1] - heights[it] }

        val positiveSorted = heightDiffs.filter { it > 0 }.sorted().toMutableList()

        val negativeIndices = heightDiffs.mapIndexed { index, diff -> index to diff }.filter { it.second <= 0 }.toMutableList()

        val sortedDiffs = mutableListOf<Int>()

        for (i in (heightDiffs.indices)) {
            if (negativeIndices.isNotEmpty() && i == negativeIndices.first().first) {
                sortedDiffs.add(negativeIndices.first().second)
                negativeIndices.removeAt(0)
            }
            else {
                sortedDiffs.add(positiveSorted.first())
                positiveSorted.removeAt(0)
            }
        }

        
        var result = 0
        var remainedBricks = bricks
        var remainedLadders = ladders
        for (j in (sortedDiffs.indices)) {
            val diff = sortedDiffs[j]

            if (diff <= 0) result++
            else {
                if (remainedBricks >= diff) {
                    remainedBricks -= diff
                    result++
                }
                else if (remainedLadders > 0) {
                    remainedLadders--
                    result++
                }
                else break
            }
        }

        return result
    }
}