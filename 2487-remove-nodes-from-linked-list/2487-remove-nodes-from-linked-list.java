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
    public ListNode removeNodes(ListNode head) {
        if(head == null || head.next == null)return head;
        
        head = reverse(head);
        ListNode curr = head;
        ListNode prev = null;
        int value = head.val;
        while(curr != null){
            value = Math.max(curr.val , value);
            if(value > curr.val)prev.next = prev.next.next;
            else prev = curr;
            curr = curr.next;
        }
        return reverse(head);
    }
    
    public ListNode reverse(ListNode head){
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