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

    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) return 0; 
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
        int rootDiameter = leftHeight + rightHeight; 

        int leftDiameter = diameterOfBinaryTree(root.left);
        int rightDiameter = diameterOfBinaryTree(root.right);
        int subDiameter = Math.max(leftDiameter, rightDiameter);

        return Math.max(rootDiameter, subDiameter);
    }

    public int height (TreeNode curr){
        if (curr == null) return 0; 
        int leftHeight = height(curr.left);
        int rightHeight = height(curr.right);
        return 1  + Math.max (leftHeight, rightHeight);
    }
}