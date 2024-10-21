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


class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2){
        if(list1 == null || list2 == null){
            if(list1 == null)return list2;
            else if(list2 == null)return list1;
            else return null;
        }
        //without using extra space
        ListNode newhead = new ListNode(0);
        ListNode dummy = newhead;
        
        while(list1 != null && list2 != null){
            if(list1.val < list2.val){
                dummy.next = list1;
                //dummy = list1;
                list1 = list1.next;
            }
            else{
                dummy.next = list2;
                //dummy = list2;
                list2 = list2.next;
            }
            dummy = dummy.next;
        }
        if(list1 != null)dummy.next = list1;
        if(list2 != null)dummy.next = list2;
        return newhead.next;
    }
}