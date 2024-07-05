/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int goodNodes(TreeNode root) {
        return countNode(root , Integer.MIN_VALUE);
    }
      public int countNode(TreeNode node , int maxSoFar){
          if(node == null){
            return 0;
          }
           int count =0;
           if(node.val >= maxSoFar){
            count++;
            maxSoFar = node.val;
           }
            count += countNode(node.left , maxSoFar);
            count += countNode(node.right , maxSoFar);

            return count;
      }
}