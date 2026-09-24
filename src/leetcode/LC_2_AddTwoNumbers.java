package leetcode;

import java.util.List;

public class LC_2_AddTwoNumbers {

    public static void main(String[] args) {
        LC_2_AddTwoNumbers addTwoNumbers = new LC_2_AddTwoNumbers();

        //test case 1
        //List<Integer> l1 = List.of(2,4,3);
        //List<Integer> l2 = List.of(5,6,4);

        //test case 2
        List<Integer> l1 = List.of(9);
        List<Integer> l2 = List.of(1,9,9,9,9,9,9,9,9,9);

        LC_2_AddTwoNumbers.ListNode aLN1 = createListNodeFromList(l1);
        LC_2_AddTwoNumbers.ListNode bLN1 = createListNodeFromList(l2);

        LC_2_AddTwoNumbers.ListNode result = addTwoNumbers.addTwoNumbers(aLN1, bLN1);
        System.out.print("Output: " + result.val);
        while (result.next != null) {
            result = result.next;
            System.out.print(" -> " + result.val);
        }
    }

    private static LC_2_AddTwoNumbers.ListNode createListNodeFromList(List<Integer> list) {
        LC_2_AddTwoNumbers.ListNode listNode = new LC_2_AddTwoNumbers.ListNode(list.get(0));
        LC_2_AddTwoNumbers.ListNode aux = listNode;
        for (int i = 1; i < list.size(); i++) {
            LC_2_AddTwoNumbers.ListNode newLn = new LC_2_AddTwoNumbers.ListNode(list.get(i));
            aux.next = newLn;
            aux = newLn;
        }
        return listNode;
    }

    /**
     * Definition for singly-linked list.
     */
    public static class ListNode {
        int val;
        public ListNode next;
        public ListNode() {}
        public ListNode(int val) { this.val = val; }
        public ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int a, b = 0;
        a = l1.val;
        b = l2.val;

        ListNode n1 = l1.next;
        ListNode n2 = l2.next;

        int mod = 10;
        while (n1 != null || n2 != null) {
            if (n1 != null) {
                a = (n1.val * mod) + a;
                n1 = n1.next;
            } else {
                a = a * 10;
            }
            if (n2 != null) {
                b = (n2.val * mod) + b;
                n2 = n2.next;
            } else {
                b = b*10;
            }
            mod = mod * 10;
        }

        int res = a + b;

        if (res < 10) {
            return new ListNode(res);
        } else {
            int aux = res % 10;
            ListNode resFirstLn = new ListNode(aux);
            ListNode currLn = resFirstLn;
            res = (int) Math.floor(res / 10);
            while (res > 9) {
                int nxt = res % 10;
                ListNode resNxt = new ListNode(nxt);
                currLn.next = resNxt;
                currLn = resNxt;
                res = (int) Math.floor(res / 10);
            }
            currLn.next = new ListNode(res);

            return resFirstLn;
        }
    }

}
