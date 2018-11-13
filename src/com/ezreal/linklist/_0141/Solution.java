package com.ezreal.linklist._0141;

import java.util.HashSet;
import java.util.Set;

/**
 * Given a linked list, determine if it has a cycle in it.
 * @author ezreal
 */
public class Solution {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }
    public boolean hasCycle(ListNode head) {
        if (head == null) return false;
        ListNode flag = head;
        Set<ListNode> set = new HashSet<>();
        while (head.next != null){
            if (set.contains(head.next)){
                return true;
            }
            set.add(head.next);
            head = head.next;
        }
        return false;
    }
}
