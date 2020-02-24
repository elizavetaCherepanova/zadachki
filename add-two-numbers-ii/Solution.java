//https://leetcode.com/problems/add-two-numbers-ii/
//You are given two non-empty linked lists representing two non-negative integers.
// The most significant digit comes first and each of their nodes contain a single digit.
// Add the two numbers and return it as a linked list.
//
//        You may assume the two numbers do not contain any leading zero, except the number 0 itself.
//
//        Follow up:
//        What if you cannot modify the input lists? In other words, reversing the lists is not allowed.
//
//        Example:
//
//        Input: (7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
//        Output: 7 -> 8 -> 0 -> 7
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
        Stack<Integer> s1 = new Stack<Integer>();
        Stack<Integer> s2 = new Stack<Integer>();
        while(l1 != null){
            s1.push(l1.val);
            l1 = l1.next;
        }
        while(l2 != null){
            s2.push(l2.val);
            l2 = l2.next;
        }
        int carry = 0;

        ListNode head = null;
        while(!s1.isEmpty() || !s2.isEmpty()){
            int n1 = s1.isEmpty() ? 0 : s1.pop();
            int n2 = s2.isEmpty() ? 0 : s2.pop();
            int sum = n1 + n2 + carry;
            ListNode n = new ListNode(sum % 10);
            n.next = head;
            //make current node our result
            head = n;
            carry = sum / 10;
        }
        if(carry > 0){
            ListNode n = new ListNode(carry);
            n.next = head;
            head = n;
        }
        return head;
    }
}

