# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def addTwoNumbers(self, l1: Optional[ListNode], l2: Optional[ListNode]) -> Optional[ListNode]:
        
        if l1 == None:
            return l2;
        if l2 == None:
            return l1;
    
        newnode = ListNode()
        curr = newnode
        carry = 0
        while l1 is not None or l2 is not None or carry == 1:
            sum_node = 0;
            if l1 != None:
                sum_node += l1.val
                l1 = l1.next
            if l2 != None:
                sum_node += l2.val
                l2 = l2.next
            sum_node += carry
            carry = sum_node // 10;
            curr.next = ListNode(sum_node % 10)
            curr = curr.next
        return newnode.next    
            