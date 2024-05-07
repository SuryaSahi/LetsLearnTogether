//{ Driver Code Starts
import java.io.*;
import java.util.*;
class Node
{
    int data;
    Node next;
    
    Node(int x)
    {
        data = x;
        next = null;
    }
}
class GfG
{
    public static void printList(Node node) 
    { 
        while (node != null)
        { 
            System.out.print(node.data);
            node = node.next; 
        }  
        System.out.println();
    } 
    public static void main(String args[])throws IOException
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    String s = sc.next();
                    Node head = new Node( s.charAt(0) - '0' );
                    Node tail = head;
                    for(int i=1; i<s.length(); i++)
                    {
                        tail.next = new Node( s.charAt(i) - '0' );
                        tail = tail.next;
                    }
                    Solution obj = new Solution();
                    head = obj.addOne(head);
                    printList(head); 
                }
        }
}
// } Driver Code Ends


/*
class Node{
    int data;
    Node next;
    
    Node(int x){
        data = x;
        next = null;
    }
} 
*/

class Solution {
    public static Node reverse(Node head) {
        if (head == null || head.next == null) return head;
        
        Node curr = head;
        Node prev = null;
        Node next = null;
        
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        
        return prev;
    }

    public static Node addOne(Node head) {
        head = reverse(head); // Reverse the list to make it easier to add 1

        Node temp = head;
        int carry = 1; // Start with carry 1 to add 1 to the number

        while (temp != null && carry != 0) {
            int sum = temp.data + carry;
            temp.data = sum % 10;
            carry = sum / 10;
            temp = temp.next;
        }

        if (carry != 0) {
            // If carry is still not 0, we need an extra node for it
            Node newHead = new Node(carry);
            temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newHead;
        }

        return reverse(head); // Reverse again to get the original order
    }
}
