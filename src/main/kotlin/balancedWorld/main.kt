package balancedWorld

import java.util.*

fun main() {
    val sc = Scanner(System.`in`)

    var isOnGoing = true

    val sentences = mutableListOf<String>()

    while (isOnGoing) {
        val sentence = sc.nextLine()
        if (sentence == ".") isOnGoing = false
        else sentences.add(sentence)
    }

    sentences.forEach {
        println(solution(it))
    }
}

fun solution(sentence: String): String {
    val onlyBrackets = sentence.filter(isBracket)

    val stack = Stack<Char>()

    onlyBrackets.forEach {
        if (isLeft(it)) stack.push(it)

        else if (isRight(it)) {
            if (stack.isEmpty()) return "no"

            if (isSmall(it)) {
                if (isSmall(stack.peek())) stack.pop()
                else return "no"
            }
            else {
                if (isLarge(stack.peek())) stack.pop()
                else return "no"
            }
        }
    }

    return if (stack.isEmpty()) "yes" else "no"
}

val isBracket = { c: Char -> c == '(' || c == ')' || c == '[' || c == ']'}

val isLeft = { c: Char -> c == '(' || c == '['}
val isRight = { c: Char -> c == ')' || c == ']'}

val isSmall = { c: Char -> c == '(' || c == ')'}
val isLarge = { c: Char -> c == '[' || c == ']'}