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
    int count =0;
    public int countPairs(TreeNode root, int distance) {
        dfs(root , distance);
        return count;
    }
    public  int[] dfs(TreeNode node , int distance){
        int[] d = new int[distance + 1];
        if(node == null){
            return d;
        } 
         if(node.left == null && node.right == null){
            d[0] = 1;
            return d;
         }

        int[] dl = dfs(node.left , distance);
        int[] dr = dfs(node.right , distance);

        for(int i=0 ; i< distance ; i++){
            for(int j =0 ; j< distance ; j++){
                if(i + j + 2 <= distance){
                    count += dl[i] * dr[j];
                }
            }
        }
           for(int i=0 ; i< distance ; i++){
              d[i+1] = dl[i] + dr[i];
           }

           return d;
    }
}