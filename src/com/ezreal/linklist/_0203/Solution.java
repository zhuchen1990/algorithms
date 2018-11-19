package com.ezreal.linklist._0203;

/**
 * Remove all elements from a linked list of integers that have value val.
 *
 * Example:
 *
 * Input:  1->2->6->3->4->5->6, val = 6
 * Output: 1->2->3->4->5
 * @author ezreal
 */
public class Solution {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    public ListNode removeElements(ListNode head, int val) {
        ListNode result = new ListNode(-1);
        result.next = head;
        ListNode pre = result;
        while (head != null){
            if (head.val == val){
                pre.next = head.next;
            }else {
                pre = pre.next;
            }
            head = head.next;
        }
        return result.next;
    }
}
