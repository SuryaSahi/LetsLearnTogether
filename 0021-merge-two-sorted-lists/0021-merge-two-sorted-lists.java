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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ArrayList<Integer> arr = new ArrayList<>();
        ListNode curr = list1;
        
        while(curr != null){
            arr.add(curr.val);
            curr = curr.next;
        }
        
        curr = list2;
        while(curr != null){
            arr.add(curr.val);
            curr = curr.next;
        }
        
        Collections.sort(arr); //sorting 
        ListNode dummy = new ListNode(0);
        ListNode newhead = dummy;
        int i = 0;
        while( i < arr.size()){
            ListNode temp = new ListNode(arr.get(i));
            newhead.next = temp;
            newhead = newhead.next;
            i++;
        }
        
        return dummy.next;
    }
}