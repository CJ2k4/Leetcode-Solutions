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
    public int averageOfSubtree(TreeNode root) {
        solve(root, 0, 0);
        return ans;
    }
    int ans = 0;
    int[] solve(TreeNode root, int sum , int size){
        if(root == null)return new int[]{0, 0};
        
        int[] left = solve(root.left, sum, size);
        int[] right = solve(root.right, sum, size);
        
        int avg = (left[0]+right[0]+root.val)/(left[1]+right[1]+1);// 0th is sum, and 1st is size
        if(avg == root.val)ans++;

        return new int[]{left[0]+right[0]+root.val, 1+left[1]+right[1]}; //sum, size
    }

}