class Solution {
    public int gcd(int a, int b) {
        if (b == 0) {
            return a;
        } else {
            return gcd(b, a % b);
        }
    }

    public ListNode insertGreatestCommonDivisors(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode prev = head;
        ListNode curr = head.next;

        while (curr != null) {  
            int num = gcd(prev.val, curr.val);
            ListNode add = new ListNode(num);
            prev.next = add;
            prev = add;
            add.next = curr;
            prev = curr;  
            curr = curr.next;
        }

        return head;
    }
}
