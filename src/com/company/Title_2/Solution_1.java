package com.company.Title_2;

public class Solution_1 {

    //     Definition for singly-linked list.
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode resultHead = null;
        ListNode temp = null;
        ListNode temp1 = null;
        do {

            if (resultHead == null){
                resultHead = temp = new ListNode(0);
            }
            int mid = l1.val + l2.val;
            temp.val += (mid % 10);
            if (mid > 9){
                temp.next = new ListNode(1);
            } else {
                temp.next = new ListNode(0);
            }
            temp1 = temp;
            temp = temp.next;
            l1 = l1.next;
            l2 = l2.next;
        }while (l1 != null && l2 != null);

        if (temp.val == 0 && temp1 != null){
            temp1.next = null;
            temp = null;
        }

        if (l1 != null){
            if (temp == null){
                temp = l1;
            } else {
                temp.val += l1.val;
                temp.next = l1.next;
            }
        }

        if (l2 != null){
            if (temp == null){
                temp = l2;
            } else {
                temp.val += l2.val;
                temp.next = l2.next;
            }
        }

        return resultHead;
    }

    // [2.4.3],[5,6,4]
    // [1],[9,9]
    public static ListNode addTwoNumbers1(ListNode l1, ListNode l2) {
        if(l1 == null){
            return l2;
        }
        if(l2 == null){
            return l1;
        }
        ListNode head = l1;
        ListNode tail = l1;
        int temp = 0;
        while(l1 != null && l2 != null){
            int sum = l1.val + l2.val + temp;
            l1.val = sum % 10;
            temp = sum / 10;
            tail = l1;
            l1 = l1.next;
            l2 = l2.next;
        }

        while(l1 != null){
            int sum = l1.val + temp;
            l1.val = sum % 10;
            temp = sum / 10;
            tail = l1;
            l1 = l1.next;
        }

        if(l2 != null){
            tail.next = l2;
        }

        while(l2 != null){
            int sum = l2.val + temp;
            l2.val = sum % 10;
            temp = sum / 10;
            tail = l2;
            l2 = l2.next;
        }

        if(temp > 0){
            tail.next = new ListNode(temp);
        }
        return head;
    }

    public static void main(String[] args){
        ListNode head1 = new ListNode(2);
        head1.next = new ListNode(4);
        head1.next.next = new ListNode(3);
        ListNode head2 = new ListNode(5);
        head2.next = new ListNode(6);
        head2.next.next = new ListNode(4);
        addTwoNumbers(head1, head2);
        ListNode node = addTwoNumbers1(head1, head2);
        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }
    }
}
