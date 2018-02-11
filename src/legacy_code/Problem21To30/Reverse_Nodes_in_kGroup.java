package legacy_code.Problem21To30;

import public_class.ListNode;
import java.util.*;

public class Reverse_Nodes_in_kGroup {

    /**
     * 25. Reverse Nodes in k-Group
     * Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.

     k is a positive integer and is less than or equal to the length of the linked list. If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.

     You may not alter the values in the nodes, only nodes itself may be changed.

     Only constant memory is allowed.

     For example,
     Given this linked list: 1->2->3->4->5

     For k = 2, you should return: 2->1->4->3->5

     For k = 3, you should return: 3->2->1->4->5
     */

    /**
     * Solution: Similar as swap nodes in pairs, replace exchange part to a nth node reverse
     *      1. reverse linkedList algorithm
     *      2. use stack to save the node and poll all to a list
     */

    /**
     * Solution 1.1: Iterative (iterative to reverse)
     */
    public ListNode reverseKGroupS1_1(ListNode head, int k) {
        ListNode dummy = new ListNode(0), res = dummy;
        dummy.next = head;
        while (head != null) {
            /*
            Define a local head variable, which will not consider if rest of nodes is less than k
                1. if rest of list have larger or equal to k nodes, append nodes from results of reverse algorithm
                2. if less than k, append head immediately
             */
            ListNode cur = head, pre = null;
            int num = k;
            /*
            Need to verify if there's enough nodes to reverse at first, because the reverse algorithm will already modify the connection rule,
             so need to verify at first and if valid then do reverse part
             if using stack, could no matter enough or not, do reverse immediately, push to stack will not modify the link between two nodes
             */
            while (cur != null && num > 0) {
                cur = cur.next;
                num--;
            }
            if (num > 0) dummy.next = head;
            else {
                cur = head;
                num = k;
                while (cur != null && num > 0) {
                    ListNode next = cur.next;
                    cur.next = pre;
                    pre = cur;
                    cur = next;
                    num--;
                }
                dummy.next = pre;
                dummy = head;
                dummy.next = cur;
            }
            head = cur;
        }
        return res.next;
    }

    /**
     * Solution 1.2: Iterative (stack to reverse)
     */
    public ListNode reverseKGroupS1_2(ListNode head, int k) {
        ListNode dummy = new ListNode(0), res = dummy;
        dummy.next = head;
        while (head != null) {
            /*
            Define a local head variable, which will not consider if rest of nodes is less than k
                1. if rest of list have larger or equal to k nodes, append nodes from stack and finally cur at last
                2. if less than k, append head immediately
             */
            ListNode cur = head;
            int num = k;
            Stack<ListNode> stack = new Stack<>();
            while (cur != null && num > 0) {
                stack.push(cur);
                cur = cur.next;
                num--;
            }
            //If num == 0, the rest number of nodes is larger or equal than k, use nodes from stack and cur
            if (num == 0) {
                while (!stack.isEmpty()) {
                    dummy.next = stack.pop();
                    dummy = dummy.next;
                }
                dummy.next = cur;
            } else dummy.next = head;
            //If current loop, used stack and cur, need to set head to cur for next loop
            head = cur;
        }
        return res.next;
    }

}
