package com.company.Title_876;




public class Solution {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public static ListNode middleNode(ListNode head) {
        if (head == null || head.next == null){
            return head;
        }

        ListNode mid = head;
        ListNode tail = head;
        int count = 0;

        while (tail != null){
            tail = tail.next;
            count ++;
            if (count % 2 == 0){
                mid = mid.next;
            }
        }
        return mid;
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        ListNode node1 = new ListNode(2);
        node.next = node1;
        ListNode node2 = new ListNode(3);
        node1.next = node2;
        ListNode node3 = new ListNode(4);
        node2.next = node3;
        ListNode node4 = new ListNode(5);
        node3.next = node4;

        System.out.println(middleNode(node).val);
    }
}
