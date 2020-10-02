// https://leetcode.com/problems/remove-duplicates-from-sorted-list/solution
package leetcode_remove_duplicates_from_sorted_list;

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return head;
        }

        ListNode i = head;
        ListNode j = i.next;

        while (j != null) {
            if (i.val != j.val) {
                i.next = j;
                i = j;
                j = i.next;
            } else {
                j = j.next;
            }
        }

        i.next = j;

        return head;
    }
}
