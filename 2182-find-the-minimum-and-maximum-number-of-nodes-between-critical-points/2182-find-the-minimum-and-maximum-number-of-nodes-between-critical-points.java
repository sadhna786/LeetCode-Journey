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
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        if(head == null || head.next == null || head.next.next == null){
            return new int[] {-1 , -1};
        }
         int lastCp = -1 ;
         int firstCp = -1;
         int index =1;
         int minDis = Integer.MAX_VALUE;
         int preValue = head.val;
         ListNode prev = head;
         ListNode current = head.next;

         while(current.next != null){
             int nextValue = current.next.val;
             if((current.val > nextValue && current.val > preValue) || (current.val < nextValue && current.val < preValue) ){
                 if(firstCp == -1){
                    firstCp = index;
                 }
                 else{
                    minDis = Math.min(minDis , index - lastCp);
                 }
                  lastCp = index;
             }
               preValue = current.val;
               current = current.next;
               index++;

         }
         if(firstCp == lastCp){
            return new int[] {-1 ,-1};
         }
          int maxDis = lastCp - firstCp;
          return new int[] {minDis , maxDis};
    }
}