package ac

import queue2.MyDeque
import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() {
    val stdIn = BufferedReader(InputStreamReader(System.`in`))
    val stdOut = BufferedWriter(OutputStreamWriter(System.out))

    val cnt = stdIn.readLine().toInt()

    (0 until cnt).forEach {
        val cmd = stdIn.readLine()

        stdIn.readLine()

        val arrStr = stdIn.readLine()
        val arr = parseToArr(arrStr)

        try {
            val result = apply(arr, cmd)
            stdOut.write("${result}\n")
        } catch (e: NoSuchElementException) {
            stdOut.write("error\n")
        }
    }
    stdOut.flush()
}

fun parseToArr(str: String): List<Int> =
    if (str.length != 2) str.substring(1, str.length - 1).split(",").map { it.toInt() }
    else listOf()

fun apply(arr: List<Int>, cmd: String): MyDeque {
    val deque = listToDeque(arr)

    cmd.forEach { action ->
        when (action) {
            'R' -> {
                deque.reverse()
            }
            'D' -> {
                val front = deque.pollByFlag()
                if (front == -1) throw NoSuchElementException()
            }
        }
    }

    return deque
}

fun listToDeque(list: List<Int>): MyDeque {
    val deque = MyDeque()

    list.forEach { deque.pushBack(it) }

    return deque
}
