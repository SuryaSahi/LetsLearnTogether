class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null)return head;
        //getting length
        ListNode point = head;
        int length = 1;
        while(point.next != null){
            point = point.next;
            length++;
        }
        k = k % length;
        if(k == 0)return head;
        while(k-- > 0){
            ListNode prev = null;
            ListNode curr = head;
            while(curr.next != null){
                prev = curr;
                curr = curr.next;
            }
            prev.next = null;
            curr.next = head;
            head = curr;
        }
        return head;
    }
}

