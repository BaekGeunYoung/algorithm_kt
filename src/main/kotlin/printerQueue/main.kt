package printerQueue

import java.util.LinkedList
import java.util.Queue
import java.util.Scanner

fun main() {
    val sc = Scanner(System.`in`)

    val cnt = sc.nextInt()

    (0 until cnt).forEach {
        val number = sc.nextInt()
        val targetIndex = sc.nextInt()

        val list = LinkedList<Int>()
        (0 until number).forEach {
            list.add(sc.nextInt())
        }

        println(solution(list, targetIndex))
    }
}

fun solution(list: LinkedList<Int>, targetIndex: Int): Int {
    val sorted = list.sortedByDescending { it }.toMutableList()
    val indexedList = list.mapIndexed { index, i -> i to index }

    var printedCnt = 0

    val q: Queue<Pair<Int, Int>> = LinkedList(indexedList)

    while (q.isNotEmpty()) {
        val value = q.poll()
        if (value.first != sorted.first()) {
            q.offer(value)
        }
        else {
            printedCnt++

            sorted.removeAt(0)

            if (value.second == targetIndex) return printedCnt
        }
    }

    error("unreachable code")
}
