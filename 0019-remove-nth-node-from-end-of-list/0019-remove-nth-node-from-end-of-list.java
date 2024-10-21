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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null)return head;
        // if(n == 1)return head.next;
        
        ListNode newnode = reverse(head);
        if(n == 1)return reverse(newnode.next);
        
        int cnt = 1;
        ListNode curr = newnode;
        while(curr != null && cnt < n - 1){
            cnt++;
            curr = curr.next;
        }
        
        if(curr != null && curr.next != null && cnt == n - 1){
            curr.next = curr.next.next;
        }

        return reverse(newnode);
    }
    
    public ListNode reverse(ListNode head ){
        ListNode prev = null;
        ListNode next = null;
        ListNode curr = head;
        
        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}

class Solution1 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
    if(head == null)return null;   
        
    ListNode fast = head;
    ListNode slow = head;
    for(int i = 0; i<n; i++){
        fast = fast.next;
        }    
        
     while(fast.next != null){
         fast = fast.next;
         slow = slow.next;
        }   
    
        if (fast == null)return head.next;
        
     slow.next = slow.next.next;
        
        return head;
    }
}