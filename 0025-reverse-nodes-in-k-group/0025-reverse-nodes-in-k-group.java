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
class Solution1 {
    public ListNode reverseKGroup(ListNode head, int k) {
       ListNode curr = head;
        ArrayList<Integer> arr = new ArrayList<>();
       while(curr.next != null) {
           arr.add(curr.val);
           curr = curr.next;
       }
        for(int i = 0; i<arr.size(); i = i + k){
//             int cnt = 0;
//             while(cnt < k){
//                 cnt++;
//             }
            
//             if(cnt == k)reverse(i,cnt - 1,arr);
            if (i + k <= arr.size()) {
                reverse(arr, i, i + k - 1);
            }
        }
        ListNode dummy = new ListNode(arr.get(0));
        ListNode temp = dummy;
        int i  = 0;
        while(++i < arr.size()){
            temp.next = new ListNode(arr.get(i));
            temp = temp.next;
        }
        return dummy;
    }
    // public void reverse( ArrayList<Integer> arr , int i , int j ){
    //     Collections.sort(arr , Collections.reverseOrder());
    // }
    private void reverse(ArrayList<Integer> arr, int start, int end) {
        while (start < end) {
            int temp = arr.get(start);
            arr.set(start, arr.get(end));
            arr.set(end, temp);
            start++;
            end--;
        }
    }
}

class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k == 1) {
            return head;
        }
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode curr = dummy;
        
        while (curr != null) {
            curr = reverseNextK(curr, k);
        }
        
        return dummy.next;
    }
    
    private ListNode reverseNextK(ListNode curr, int k) {
        ListNode next = curr;
        // Check if there are at least k nodes remaining
        for (int i = 0; i < k; i++) {
            if (next.next == null) {
                return null; // Less than k nodes remaining
            }
            next = next.next;
        }
        
        ListNode prev = null;
        ListNode currNode = curr.next;
        ListNode first = currNode;
        
        // Reverse k nodes
        for (int i = 0; i < k; i++) {
            ListNode temp = currNode.next;
            currNode.next = prev;
            prev = currNode;
            currNode = temp;
        }
        
        // Connect reversed segment with the rest of the list
        curr.next = prev;
        first.next = currNode;
        
        return first;
    }
}