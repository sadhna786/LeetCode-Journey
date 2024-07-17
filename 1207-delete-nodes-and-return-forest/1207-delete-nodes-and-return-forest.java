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
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        List<TreeNode> forest = new ArrayList<>();
        Set<Integer> deleteNode = new HashSet<>();
        for(int num : to_delete){
            deleteNode.add(num);
        }
        helper(root , forest , deleteNode , true);
        return forest;
    }
     public static TreeNode helper(TreeNode root , List<TreeNode> forest , Set<Integer> deleteNode , boolean isRoot){
         if(root == null)return null;
         boolean deleted = deleteNode.contains(root.val);
         if(isRoot && !deleted){
            forest.add(root);
         }
         root.left = helper(root.left , forest , deleteNode , deleted);
         root.right = helper(root.right , forest , deleteNode , deleted);

         return deleted ? null : root;
     }
}