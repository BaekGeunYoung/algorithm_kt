package leetcode.letter_comb

fun main() {
    val digits = "23"
    println(letterCombinations(digits))
}


fun letterCombinations(digits: String): List<String> {
    val list = digits.map {
        when (it) {
            '2' -> listOf('a','b','c')
            '3' -> listOf('d','e','f')
            '4' -> listOf('g','h','i')
            '5' -> listOf('j','k','l')
            '6' -> listOf('m','n','o')
            '7' -> listOf('p','q','r','s')
            '8' -> listOf('t','u','v')
            else -> listOf('w','x','y','z')
        }
    }

    var result = listOf<String>()

    list.forEach { chars ->
        if (result.isEmpty()) result = chars.map { it.toString() }
        else result = result.flatMap { str -> chars.map { str + it } }
    }

    return result
}
