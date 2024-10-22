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
    public ListNode mergeKLists(ListNode[] lists) {
        ArrayList<Integer> arr = new ArrayList<>();
        for(ListNode node : lists){
            while(node != null){
                arr.add(node.val);
                node = node.next;
            }
        }
        
        Collections.sort(arr);
        ListNode newnode = new ListNode(0);
        ListNode dummy = newnode;
        
        for(int i : arr){
            ListNode temp = new ListNode(i);
            dummy.next = temp;
            dummy = dummy.next;
        }
        
        return newnode.next;
    }
}