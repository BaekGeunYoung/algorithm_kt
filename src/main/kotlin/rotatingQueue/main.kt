package rotatingQueue

import java.util.LinkedList
import java.util.Scanner

fun main() {
    val sc = Scanner(System.`in`)

    val n = sc.nextInt()
    val extractCnt = sc.nextInt()

    val extract = mutableListOf<Int>()

    (0 until extractCnt).forEach {
        extract.add(sc.nextInt())
    }

    println(solution(n, extract))
}

fun solution(n: Int, extractList: List<Int>): Int {
    val deq: LinkedList<Int> = LinkedList((1 .. n).map { it })

    val rotatingQueue = RotatingQueue(deq)

    var result = 0
    extractList.forEach {
        val (isLeftBiased, step) = rotatingQueue.isLeftBiased(it)
        if (isLeftBiased) {
            (0 until step).forEach {
                rotatingQueue.rotateToLeft()
                result++
            }
            rotatingQueue.extract()
        }
        else {
            (0 until step).forEach {
                rotatingQueue.rotateToRight()
                result++
            }
            rotatingQueue.extract()
        }
    }

    return result
}

data class RotatingQueue(val deq: LinkedList<Int>) {
    fun isLeftBiased(e: Int): Pair<Boolean, Int> {
        val index = deq.indexOf(e)

        if (index == 0) return true to 0

        val isBiased = deq.size / index  >= 2

        return if (isBiased) isBiased to index
        else isBiased to deq.size - index
    }

    fun extract(): Int = deq.pollFirst()

    fun rotateToLeft() {
        val first = deq.pollFirst()
        deq.offerLast(first)
    }

    fun rotateToRight() {
        val last = deq.pollLast()
        deq.offerFirst(last)
    }
}