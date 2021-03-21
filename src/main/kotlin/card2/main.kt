package card2

import java.util.LinkedList
import java.util.Queue
import java.util.Scanner

fun main() {
    val sc = Scanner(System.`in`)

    val number = sc.nextInt()

    println(solution(number))
}

fun solution(number: Int): Int {
    val q: Queue<Int> = LinkedList()

    (1 .. number).forEach { q.offer(it) }


    while (q.size > 1) {
        q.poll()
        val value = q.poll()
        q.offer(value)
    }

    return q.peek()
}