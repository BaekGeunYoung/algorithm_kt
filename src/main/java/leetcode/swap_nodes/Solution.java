package leetcode.swap_nodes;

class Solution {
    public static void main(String[] args) {
        Solution sol = new Solution();
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4))));

        System.out.println(sol.swapPairs(head));
    }

    public ListNode swapPairs(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            ListNode first = curr;
            ListNode second = curr.next;

            if (second == null) return head;

            if (prev == null) {
                head = second;
                first.next = second.next;
                second.next = first;
            }
            else {
                prev.next = second;
                first.next = second.next;
                second.next = first;
            }

            prev = first;
            curr = first.next;
        }

        return head;
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }


    @Override
    public String toString() {
        ListNode curr = this;
        String result = "";
        while (curr != null) {
            result += curr.val + ", ";
            curr = curr.next;
        }

        return result;
    }
}
