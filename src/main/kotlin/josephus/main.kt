package josephus

import java.util.LinkedList
import java.util.Queue
import java.util.Scanner

fun main() {
    val sc = Scanner(System.`in`)

    val n = sc.nextInt()
    val k = sc.nextInt()

    println(solution(n, k))
}

fun solution(n: Int, k: Int): String {
    val q: Queue<Int> = LinkedList()

    (1 .. n).forEach { q.offer(it) }

    val result = mutableListOf<Int>()

    while (q.isNotEmpty()) {
        (0 until k).forEach {
            if (it == k - 1) result.add(q.poll())
            else q.offer(q.poll())
        }
    }

    return "<${result.joinToString(", ")}>"
}