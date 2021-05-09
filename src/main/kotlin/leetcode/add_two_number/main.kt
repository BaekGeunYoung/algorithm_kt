package leetcode.add_two_number

fun main() {
    val l1 = ListNode.of(listOf(9,9,9,9,9,9,9))
    val l2 = ListNode.of(listOf(9,9,9,9))

    val s = Solution()

    println(s.addTwoNumbers(l1, l2))
}

/**
 * Example:
 * var li = ListNode(5)
 * var v = li.`val`
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */
class Solution {
    fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
        var currL = l1
        var currR = l2

        var result: ListNode? = null
        lateinit var resultCursor: ListNode
        var carry = 0

        while (currL != null && currR != null) {
            val sum = currL.`val` + currR.`val` + carry

            if (result == null) {
                result = ListNode(sum % 10)
                resultCursor = result
            }
            else {
                resultCursor.next = ListNode(sum % 10)
                resultCursor = resultCursor.next!!
            }

            carry = if (sum >= 10) 1 else 0

            currL = currL.next
            currR = currR.next
        }

        if (currL == null) {
            while (currR != null) {
                val sum = currR.`val` + carry

                if (result == null) {
                    result = ListNode(sum % 10)
                    resultCursor = result
                }
                else {
                    resultCursor.next = ListNode(sum % 10)
                    resultCursor = resultCursor.next!!
                }
                carry = if (sum >= 10) 1 else 0

                currR = currR.next

            }
        }
        else if (currR == null) {
            while (currL != null) {
                val sum = currL.`val` + carry

                if (result == null) {
                    result = ListNode(sum % 10)
                    resultCursor = result
                }
                else {
                    resultCursor.next = ListNode(sum % 10)
                    resultCursor = resultCursor.next!!
                }

                carry = if (sum >= 10) 1 else 0

                currL = currL.next
            }
        }

        if (carry == 1) {
            resultCursor.next = ListNode(1)
        }

        return result
    }
}

class ListNode(var `val`: Int) {
    var next: ListNode? = null

    companion object {
        fun of(ls: List<Int>): ListNode {
            val result = ListNode(ls.first())
            var resultCursor = result

            for (i in (1 until ls.size)) {
                resultCursor.next = ListNode(ls[i])
                resultCursor = resultCursor.next!!
            }

            return result
        }
    }

    override fun toString(): String {
        var curr: ListNode? = this
        val ints = mutableListOf<Int>()
        while (curr != null) {
            ints.add(curr.`val`)
            curr = curr.next
        }
        return "[${ints.joinToString(", ")}]"
    }
}