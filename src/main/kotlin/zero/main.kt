package zero

import java.util.*

fun main() {
    val sc = Scanner(System.`in`)

    val count = sc.nextInt()

    val numbers = (0 until count).map { sc.nextInt() }

    println(solution(numbers))
}

fun solution(numbers: List<Int>): Int {
    val stack = Stack<Int>()

    numbers.forEach {
        if (it == 0) stack.pop()
        else stack.push(it)
    }

    return stack.foldRight(0) { t, acc ->
        t + acc
    }
}