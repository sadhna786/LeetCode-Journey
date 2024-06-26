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

    public void inOrder(TreeNode node , List<Integer> nodes){
        if(node == null) return;
        inOrder(node.left , nodes);
        nodes.add(node.val);
        inOrder(node.right , nodes);
    }

    public TreeNode buildBST(List<Integer> nodes , int start , int end){
        if(start > end) return null;
        int mid = start + (end - start)/2;
        TreeNode node = new TreeNode(nodes.get(mid));
        node.left = buildBST(nodes , start , mid-1);
        node.right = buildBST(nodes , mid+1 , end);

        return node;
    }

    public TreeNode balanceBST(TreeNode root) {
        List<Integer> nodes = new ArrayList<>();
         inOrder(root , nodes);
         return buildBST(nodes , 0 , nodes.size()-1);

    }
}