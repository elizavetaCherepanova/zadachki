//You are given two non-empty linked lists representing two non-negative
//        integers. The digits are stored in reverse order and each of their
//        nodes contain a single digit. Add the two numbers and return it as a linked list.
//
//        You may assume the two numbers do not contain any leading zero, except the number 0 itself.
//
//        Example:
//
//        Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
//        Output: 7 -> 0 -> 8
//        Explanation: 342 + 465 = 807.
//        https://leetcode.com/problems/add-two-numbers/
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode res = new ListNode(0);
        ListNode head = res;
        ListNode l11 = l1;
        ListNode l22 = l2;
        while(l11 !=null || l22 != null || carry > 0){
            int s1 = l11 == null ? 0 : l11.val;
            int s2 = l22 == null ? 0 : l22.val;
            int sum = s1 + s2 + carry;
            head.next = new ListNode(sum % 10);
            head = head.next;

            carry = sum / 10;
            if(l11 != null) {
                l11 = l11.next;
            }
            if(l22 != null) {
                l22 = l22.next;
            }
        }
        return res.next;

    }
}