/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public boolean hasCycle(ListNode head) {
        if (head == null) return false;

        Set <ListNode> seen = new HashSet <>();
        ListNode curr = head; 

        while (curr.next != null) {
            if (seen.contains(curr)) return true; 
            seen.add(curr);
            curr = curr.next;
        }
        return false;
    }
}
