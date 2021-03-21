package deque

import queue2.MyDeque
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

        if (command.startsWith("push_front")) {
            val value = command.split(" ")[1].toInt()
            q.pushFront(value)
        }
        else if (command.startsWith("push_back")) {
            val value = command.split(" ")[1].toInt()
            q.pushBack(value)
        }
        else if (command.startsWith("pop_front")) {
            if (q.isEmpty()) stdOut.write("-1\n")
            else stdOut.write("${q.pollFront()}\n")
        }
        else if (command.startsWith("pop_back")) {
            if (q.isEmpty()) stdOut.write("-1\n")
            else stdOut.write("${q.pollBack()}\n")
        }
        else if (command.startsWith("size")) {
            stdOut.write("${q.size}\n")
        }
        else if (command.startsWith("empty")) {
            stdOut.write("${if(q.isEmpty()) 1 else 0}\n")
        }
        else if (command.startsWith("front")) {
            if (q.isEmpty()) stdOut.write("-1\n")
            else stdOut.write("${q.getFront()}\n")
        }
        else if (command.startsWith("back")) {
            if (q.isEmpty()) stdOut.write("-1\n")
            else stdOut.write("${q.getBack()}\n")
        }
        else error("unreachable code")
    }

    stdOut.flush()
}