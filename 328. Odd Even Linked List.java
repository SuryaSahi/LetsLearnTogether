class Solution {
    public ListNode oddEvenList(ListNode head) {
        if(head == null || head.next == null)return head;

        //ListNode dummy = head;
        ListNode oddhead = head;        
        ListNode evenhead = head.next;
        ListNode even = evenhead;
        ListNode odd = oddhead;

        //cause even will always be ahead of odd    
        while(even != null && even.next != null){
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }
        odd.next = evenhead;
        return head;
    }
}
