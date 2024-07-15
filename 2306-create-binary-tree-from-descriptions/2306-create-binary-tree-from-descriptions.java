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
    public TreeNode createBinaryTree(int[][] descriptions) {
        Map<TreeNode , TreeNode> childToParent = new HashMap<>();
        Map<Integer, TreeNode> valueToNode = new HashMap<>();

        for(int[] des : descriptions){
            int parent = des[0];
            int child = des[1];
            int isLeft = des[2];

            TreeNode parentNode = valueToNode.getOrDefault(parent , new TreeNode(parent));
            TreeNode childNode = valueToNode.getOrDefault(child , new TreeNode(child));
            valueToNode.put(parent , parentNode);
            valueToNode.put(child , childNode);
            childToParent.put(childNode , parentNode);
            if(isLeft == 1){
                parentNode.left = childNode;

            }
             else{
                parentNode.right = childNode;
             }
        }
             TreeNode root = childToParent.keySet().iterator().next();
             while(childToParent.containsKey(root)){
                root = childToParent.get(root);
             }
           
        
          return root;
    }
}