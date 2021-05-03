package programmers_64064

fun main() {
    val userId = arrayOf(
        "frodo", "fradi", "crodo", "abc123", "frodoc"
    )
    
    val bannedId = arrayOf(
        "fr*d*", "*rodo", "******", "******"
    )

    println(solution(userId, bannedId))
}

fun solution(user_id: Array<String>, banned_id: Array<String>): Int {
    val remainedUserId = user_id.copyOf()

    val candidates: List<List<String>> = banned_id.map {
        val regex = it.replace("*", "\\S").toRegex()

        val ret = findMatchedList(remainedUserId, regex)
        println()
        ret
    }

    var results: Set<MutableList<String>> = mutableSetOf()

    candidates.forEach { newSubResults ->
        if (results.isEmpty()) {
            results = newSubResults.map { mutableListOf(it) }.toSet()
        }
        else {
            results = results.flatMap { list ->
                newSubResults.map {
                    (list + listOf(it)).toMutableList()
                }
            }.filter { it.toSet().size == it.size }.toSet()
        }
    }

    val finalResults = results.map { it.toSet() }.toSet()

    return finalResults.size
}

fun findMatchedList(userId: Array<String>, regex: Regex): List<String> = userId.filter { regex.matches(it) }
