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
    public ListNode doubleIt(ListNode head) {
    ListNode rhead = reverse(head);
        ListNode temp = rhead, prev = null;
        int carry = 0;
        while(temp != null) {
            int val = temp.val * 2 + carry;
            temp.val = val % 10;
            carry = val / 10;
            prev = temp;
            temp = temp.next;
        }
        if(carry > 0) {
            prev.next = new ListNode(carry);
        }
        
        return reverse(rhead);
    }
    
    private ListNode reverse(ListNode node) {
        if(node == null || node.next == null) return node;
        
        ListNode temp = node;
        ListNode prev = null;
        
        while(temp != null) {
            ListNode t = temp.next;
            temp.next = prev;
            prev = temp;
            temp = t;
        }
        
        return prev;
    }
}
