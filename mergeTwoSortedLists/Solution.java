//Merge two sorted linked lists and return it as a new list. The new list should be made by splicing
// together the nodes of the first two lists.
//https://leetcode.com/problems/merge-two-sorted-lists/
//
//        Example:
//
//        Input: 1->2->4, 1->3->4
//        Output: 1->1->2->3->4->4
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        List<Integer> list = new ArrayList<>();
        while(l1 != null){
            list.add(l1.val);
            l1 = l1.next;
        }
        while(l2 != null){
            list.add(l2.val);
            l2 = l2.next;
        }
        Collections.sort(list);
        if(list.size() > 0){
            ListNode result = new ListNode(list.get(0));
            if(list.size() > 1) {
                ListNode next = new ListNode(list.get(1));
                result.next = next;
                int i = 2;
                while(i < list.size()){
                    next.next = new ListNode(list.get(i));
                    next = next.next;
                    i++;
                }
            }
            return result;
        }
        return null;
    }
}