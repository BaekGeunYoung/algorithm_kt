package bracket

import java.util.*

fun main() {
    val sc = Scanner(System.`in`)

    val count = sc.nextInt()

    val inputs = (0 until count).map { sc.next() }

    inputs.forEach {
        println(balancedWorld.solution(it))
    }
}

fun solution(bracketString: String): String {
    val stack = Stack<Char>()

    bracketString.toCharArray().forEach {
        if (it == '(') stack.push('(')
        else if (it == ')') {
            if (stack.isEmpty()) return "NO"
            stack.pop()
        }
        else error("unreachable code")
    }

    return if (stack.isEmpty()) "YES" else "NO"
}
