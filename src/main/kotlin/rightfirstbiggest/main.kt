package rightfirstbiggest

import java.util.*

fun main() {
    val sc = Scanner(System.`in`)

    val count = sc.nextInt()

    val numbers = (0 until count).map { sc.nextInt() }

    println(solution(numbers).joinToString(" "))
}

fun solution(numbers: List<Int>): List<Int> {
    val stack = Stack<Pair<Int, Int>>()

    val peekOrMax = { st: Stack<Pair<Int, Int>> -> if (st.isEmpty()) Int.MAX_VALUE else  st.peek().second }

    val result = mutableListOf<Pair<Int, Int>>()

    numbers.forEachIndexed { index, i ->
        val currentTop = peekOrMax(stack)

        if (currentTop >= i) stack.push(index to i)
        else {
            while (!stack.isEmpty() && stack.peek().second < i) {
                result.add(stack.pop().first to i)
            }

            stack.push(index to i)
        }
    }

    while (!stack.isEmpty()) {
        result.add(stack.pop().first to -1)
    }

    return result.sortedBy { it.first }.map { it.second }
}
