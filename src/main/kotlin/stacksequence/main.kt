package stacksequence

import java.util.*

fun main() {
    val sc = Scanner(System.`in`)

    val count = sc.nextInt()

    val numbers = (0 until count).map { sc.nextInt() }

    val s = solution(numbers)

    s?.let {
        it.forEach { println(it) }
    } ?: println("NO")
}

fun solution(numbers: List<Int>): List<Char>? {
    val stack = Stack<Int>()

    val peekOrZero = { st: Stack<Int> -> if (st.isEmpty()) 0 else st.peek() }

    val result = mutableListOf<Char>()

    var currentMax = 0

    numbers.forEach {
        val currentTop = peekOrZero(stack)
        if (it > currentTop) {
            (currentMax + 1 until it).forEach {
                stack.push(it)
                result.add('+')
            }
            result.add('+')
            result.add('-')

            if (currentMax < it) currentMax = it
        }
        else {
            if (it == currentTop) {
                stack.pop()
                result.add('-')
            }
            else return null
        }
    }

    return result
}