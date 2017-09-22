package Leetcode;

public class MaximumDepthOfBinaryTree {

	 // Definition for a binary tree node.
	 public class TreeNode {
	     int val;
	     TreeNode left;
	     TreeNode right;
	     TreeNode(int x) { val = x; }
	 }
	class Solution {
	    public int maxDepth(TreeNode root) {
	        int depth = 0;
	        int maxDepth = getMaxDepth(root, depth);
	        return maxDepth;
	    }
	    
	    public int getMaxDepth(TreeNode node, int depth) {
	        if(node == null) {
	            return depth;
	        }
	        return Math.max((getMaxDepth(node.right, depth + 1)),(getMaxDepth(node.left, depth + 1)));
	    }
	}
}
