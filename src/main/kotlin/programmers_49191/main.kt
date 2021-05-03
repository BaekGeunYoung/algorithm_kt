package programmers_49191

fun main() {
    val n = 2
    val results = arrayOf<IntArray>(
        intArrayOf(1, 2)
    )

    println(solution(n, results))
}

lateinit var winCache: Array<MutableSet<Int>?>
lateinit var loseCache: Array<MutableSet<Int>?>

fun solution(n: Int, results: Array<IntArray>): Int {
    val adjacencyList: List<Pair<MutableSet<Int>, MutableSet<Int>>> = (0 .. n).map { mutableSetOf<Int>() to mutableSetOf<Int>() }

    winCache = arrayOfNulls(n + 1)
    loseCache = arrayOfNulls(n + 1)

    results.forEach {
        adjacencyList[it[0]].first.add(it[1])
        adjacencyList[it[1]].second.add(it[0])
    }

    var result = 0

    (1 .. n).forEach {
        val winCount = getWinCount(it, adjacencyList)
        val loseCount = getLoseCount(it, adjacencyList)

        if (winCount + loseCount == n - 1) result++
    }

    return result
}

fun getWinCount(nodeNumber: Int, adjacencyList: List<Pair<MutableSet<Int>, MutableSet<Int>>>): Int =
    getWinList(nodeNumber, adjacencyList).size

fun getWinList(nodeNumber: Int, adjacencyList: List<Pair<MutableSet<Int>, MutableSet<Int>>>): MutableSet<Int> =
    if (winCache[nodeNumber] != null) winCache[nodeNumber]!!
    else {
        val winList: MutableSet<Int> = mutableSetOf(*adjacencyList[nodeNumber].first.toTypedArray())

        adjacencyList[nodeNumber].first.forEach {
            val subWinList = getWinList(it, adjacencyList)
            winList.addAll(subWinList)
        }

        winCache[nodeNumber] = winList

        winList
    }

fun getLoseCount(nodeNumber: Int, adjacencyList: List<Pair<MutableSet<Int>, MutableSet<Int>>>): Int =
    getLoseList(nodeNumber, adjacencyList).size

fun getLoseList(nodeNumber: Int, adjacencyList: List<Pair<MutableSet<Int>, MutableSet<Int>>>): MutableSet<Int> =
    if (loseCache[nodeNumber] != null) loseCache[nodeNumber]!!
    else {
        val loseList: MutableSet<Int> = mutableSetOf(*adjacencyList[nodeNumber].second.toTypedArray())

        adjacencyList[nodeNumber].second.forEach {
            val subLoseList = getLoseList(it, adjacencyList)
            loseList.addAll(subLoseList)
        }

        loseCache[nodeNumber] = loseList

        loseList
    }

