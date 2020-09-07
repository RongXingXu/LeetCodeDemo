package com.company.Title_24;
//给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
//
// 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
//
//
//
// 示例:
//
// 给定 1->2->3->4, 你应该返回 2->1->4->3.
//
// Related Topics 链表
// 👍 610 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

import com.company.Title_2.Solution_1;

import java.util.List;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static ListNode swapPairs(ListNode head) {

        if (head == null){
            return null;
        }

        ListNode first = head;
        if (first.next != null){
            head = first.next;
        }
        ListNode third = null;
        while (first != null && first.next != null) {
            ListNode second = first.next;
            ListNode temp = second.next;
            second.next = first;
            first.next = temp;
            if (third != null){
                third.next = second;
            }
            third = first;
            first = first.next;
        }

        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode node = head;

        node.next = new ListNode(2);
        node = node.next;

        node.next = new ListNode(3);
        node = node.next;

        node.next = new ListNode(4);
        node = node.next;

        ListNode result = swapPairs(head);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
