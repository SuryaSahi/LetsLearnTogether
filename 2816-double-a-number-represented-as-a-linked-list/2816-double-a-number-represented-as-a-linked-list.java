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
    
    public ListNode reverse(ListNode head){
        if(head == null || head.next == null)return head;
        
        ListNode curr = head;
        ListNode prev = null;
        ListNode next = null;
        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
    
}