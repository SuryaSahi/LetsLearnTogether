# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def reverse(self , head):
        curr = head
        prev = None 
        nextnode = None
        
        while curr != None:
            nextnode = curr.next
            curr.next = prev
            prev = curr
            curr = nextnode
            
        return prev
    def removeNthFromEnd(self, head: Optional[ListNode], n: int) -> Optional[ListNode]:
        if head is None:
            return head
        
        head = self.reverse(head)
        if n == 1:
            head = head.next
            return self.reverse(head)
        
        curr = head
        cnt = 1
        
        while curr != None and cnt < n - 1:
            cnt += 1
            curr = curr.next
            
        if curr and curr.next:
            curr.next = curr.next.next
        
        return self.reverse(head)
    
        
        
        
        
        