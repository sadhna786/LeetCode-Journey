/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeNodes(ListNode head) {
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        ListNode itr = head.next;
        while(itr != null){
            int sum =0;
            while(itr != null && itr.val != 0){
                sum += itr.val;
                itr = itr.next;
            }
             itr = itr.next;
             current.next = new ListNode(sum);
             current = current.next; 
        }
          return dummy.next;
    }
}