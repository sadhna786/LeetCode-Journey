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
    public int pairSum(ListNode head) {
        List<Integer> list = new ArrayList<>();
        ListNode ptr = head;
        while(ptr != null){
            list.add(ptr.val);
            ptr = ptr.next;
        }
         int maxSum =0;
         int n = list.size();
         for(int i=0 ; i<n ; i++){
            int currentSum = list.get(i) + list.get(n - i - 1);
            maxSum = Math.max(maxSum , currentSum);
         }
           return maxSum;
    }
}