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
    /***
     * EASY
     * 
     * You are given the heads of two sorted linked lists list1 and list2.
     * 
     * Merge the two lists into one sorted list. The list should be made by splicing together the nodes of the first two lists.
     * 
     * Return the head of the merged linked list.
     * 
     * @param headList1 head node of list 1
     * @param headList2 head node of list 2
     */
    public ListNode mergeTwoLists(ListNode headList1, ListNode headList2) {
        // head 1 is null, but head 2 is present, so merged is head 2
        if (headList1 == null && headList2 != null) {
            return headList2;
        }
        // head 2 is null, but head 1 is present, so merged is head 1
        if (headList2 == null && headList1 != null) {
            return headList1;
        }
        // both heads are null, so merged is null
        if (headList1 == null && headList2 == null) {
            return null;
        }

        //compare value of both heads, lower value means it comes first
        ListNode mainNode = (headList1.val < headList2.val) ? headList1 : headList2;

        //head oposite of main one is the secondary
        ListNode secondaryNode = !(headList1.val < headList2.val) ? headList1 : headList2;

        //define a current node, start being the main one
        ListNode currentNode = mainNode;
        
        //walk through all nodes and merge
        //currentNode has a next value and secondaryNode is not empty yet
        while (currentNode.next != null && secondaryNode != null) {
            //define values for comparison
            int currValue = currentNode.val; //current value
            int nxtValue = currentNode.next.val; //value of next node from current
            int scndValue = secondaryNode.val; //value of current second node head

            //if secondary value is less value than the next node from current
            //then this second node must come between current node and its next node
            if (scndValue <= nxtValue) {
                // A1 -> A2 -> A3; B1 becomes 
                // A1 -> B1 -> A2 -> A3; B2 
                //define an auxiliary node to help push secondary node between current and next node
                //aux is B2, to keep reference
                ListNode auxNode = secondaryNode.next;
                // Make B1 point to A2
                secondaryNode.next = currentNode.next;
                // Make A1 point to B1
                currentNode.next = secondaryNode;
                // Make secondary head the B2
                secondaryNode = auxNode;
            } else {
                //second value is bigger, so just walk from A1 -> A2
                currentNode = currentNode.next;
            }
            // loop until all nodes are walked
        }

        //if secondary node is not empty, then its value comes at the end
        //just connect current/last node to second head
        if (secondaryNode != null) {
            currentNode.next = secondaryNode;
        }

        // return head of merged lists
        return mainNode;
    }
}