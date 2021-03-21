package queue2

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter


fun main() {
    val stdIn = BufferedReader(InputStreamReader(System.`in`))
    val stdOut = BufferedWriter(OutputStreamWriter(System.out))

    val count = stdIn.readLine().toInt()

    val q = MyDeque()

    (0 until count).forEach {
        val command = stdIn.readLine()

        if (command.startsWith("push")) {
            val value = command.split(" ")[1].toInt()
            q.push(value)
        }
        else if (command.startsWith("pop")) {
            if (q.isEmpty()) stdOut.write("-1\n")
            else stdOut.write("${q.pollFront()}\n")
        }
        else if (command.startsWith("size")) {
            stdOut.write("${q.size}\n")
        }
        else if (command.startsWith("empty")) {
            stdOut.write("${if(q.isEmpty()) 1 else 0}\n")
        }
        else if (command.startsWith("front")) {
            if (q.isEmpty()) stdOut.write("-1\n")
            else stdOut.write("${q.getFirst()}\n")
        }
        else if (command.startsWith("back")) {
            if (q.isEmpty()) stdOut.write("-1\n")
            else stdOut.write("${q.getLast()}\n")
        }
        else error("unreachable code")
    }

    stdOut.flush()
}

class MyDeque {
    var size: Int = 0
    var front: Node<Int>? = null
    var back: Node<Int>? = null

    fun push(e: Int) {
        if (size == 0) {
            val newNode = Node(e)
            front = newNode
            back = newNode
            front!!.prev = newNode
            front!!.next = newNode
            size++
        }

        else {
            val newNode = Node(e)
            back!!.prev = newNode
            newNode.next = back
            back = newNode
            size++
        }
    }

    fun getLast(): Int = back?.value ?: -1

    fun getFirst(): Int = front?.value ?: -1

    fun isEmpty(): Boolean = size == 0

    fun pollFront(): Int {
        if (isEmpty()) return -1

        if (size == 1) {
            val value = front!!.value
            front = null
            back = null
            size--

            return value
        }
        else {
            val newFront = front!!.prev!!
            val value = front!!.value

            newFront.next = null
            front = newFront
            size--

            return value
        }
    }
}

data class Node<T>(
    val value: T
) {
    var prev: Node<T>? = null
    var next: Node<T>? = null
}
