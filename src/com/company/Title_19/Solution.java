package com.company.Title_19;
//给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
//
// 示例：
//
// 给定一个链表: 1->2->3->4->5, 和 n = 2.
//
//当删除了倒数第二个节点后，链表变为 1->2->3->5.
//
//
// 说明：
//
// 给定的 n 保证是有效的。
//
// 进阶：
//
// 你能尝试使用一趟扫描实现吗？
// Related Topics 链表 双指针
// 👍 970 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    // 双指针
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode firstNode = new ListNode(-1);
        firstNode.next = head;
        head = firstNode;

        int firstIndex = 0;
        while (firstNode.next != null && firstIndex < n){
            firstNode = firstNode.next;
            firstIndex ++;
        }

        ListNode secondNode = head;
        while (firstNode.next != null){
            firstNode = firstNode.next;
            secondNode = secondNode.next;
        }

        secondNode.next = secondNode.next.next;
        return head.next;
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        ListNode head = node;

//        node.next = new ListNode(2);
//        node = node.next;
//
//        node.next = new ListNode(3);
//        node = node.next;
//
//        node.next = new ListNode(4);
//        node = node.next;
//
//        node.next = new ListNode(5);

        ListNode result = removeNthFromEnd(head, 1);

        while (result != null){
            System.out.println(result.val);
            result = result.next;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
