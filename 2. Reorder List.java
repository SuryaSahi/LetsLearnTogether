class Solution {
    public ListNode midNode(ListNode head){
        ListNode fast =  head, slow  =  head;
        while(fast.next!=null && fast.next.next!=null){
            fast =  fast.next.next;
            slow =  slow.next;
        }
        return slow;
    }
    
    public ListNode reverse(ListNode head){
        ListNode curr =  head, prev=  null, next = null;
        while(curr!=null){
            next  =  curr.next;
            curr.next =  prev ;
            prev =  curr;
            curr  =  next;
        }
        return prev;
    }

    
    public void reorderList(ListNode head) {
        
        ListNode midNode =  midNode(head);
        ListNode nextToMid =  midNode.next;
        midNode.next = null;
        ListNode point1 =  reverse(nextToMid);
        
        ListNode point2 =  head ,point2Next;    
        while(point2!=null && point1!=null){
            point2Next =  point2.next;                                    
			point2.next =  point1;
			           
            point2 =  point1;
            point1 =point2Next;                        
        }                
    }            
}
