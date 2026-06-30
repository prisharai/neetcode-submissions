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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (subRoot == null) return true; 
        if (root == null) return false;

        if (isSameTree(root, subRoot)) return true;

        //return (isSubtree(root.left, subRoot) && isSubtree(root.right, subRoot));
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);

    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        return Arrays.equals(dfs(p),dfs(q));
    }

    public int [] dfs (TreeNode root){
        // preorder traversal - root, left, right
        if (root == null) return new int[]{Integer.MIN_VALUE};
        int [] left = dfs(root.left);
        int [] right = dfs(root.right);
        int [] result = new int [1 + left.length + right.length];

        result[0] = root.val; 
        System.arraycopy(left, 0, result, 1, left.length);
        System.arraycopy(right, 0, result, 1 + left.length, right.length);
        
        return result; 
   }
}
