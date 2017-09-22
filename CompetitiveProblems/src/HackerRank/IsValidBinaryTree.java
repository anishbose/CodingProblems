package HackerRank;
import java.util.*;
public class IsValidBinaryTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	class Node {
        int data;
        Node left;
        Node right;
     }
	
    boolean checkBST(Node root) {
        return bstHelper(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    boolean bstHelper(Node root, int min, int max) {
        if(root == null) {
            return true;
        }
        
        if(root.data < min || root.data > max) return false;
        
        return (bstHelper(root.left, min, root.data-1) && bstHelper(root.right, root.data+1, max));
    }

}
