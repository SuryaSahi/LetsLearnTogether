class Solution {
    public ListNode removeNodes(ListNode head) {
        if (head == null || head.next == null) {
            return head; // Return the head if it's empty or has only one node.
        }
        head = reverse(head);
        ListNode curr = head;
        ListNode prev = null;
        int value = head.val;
        while(curr != null){
          value = Math.max(value , curr.val);
          if(value > curr.val){
            prev.next = prev.next.next;
          }
          else{
            prev = curr;
          }
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
