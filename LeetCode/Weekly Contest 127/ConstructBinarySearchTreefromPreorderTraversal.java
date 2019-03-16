/**
 * https://leetcode.com/contest/weekly-contest-127/problems/construct-binary-search-tree-from-preorder-traversal/
 */

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class ConstructBinarySearchTreefromPreorderTraversal {

    public TreeNode bstFromPreorder(int[] preorder) {
        TreeNode tree = null;
        for (int i = 0; i < preorder.length; i++) {
            tree = put(tree, preorder[i]);
        }
        return tree;
    }
    
    private TreeNode put(TreeNode tree, int a) {
        if (tree == null)
            return new TreeNode(a);
        boolean cmp = a < tree.val;
        if (cmp)
            tree.left = put(tree.left, a); 
        if (!cmp)
            tree.right = put(tree.right, a);
        return tree;
    }
}

/**
 * Another Solution
 * 
 * Solution 2
 *  Give the function a bound the maximum number it will handle.
 *  The left recursion will take the elements smaller than node.val
 *  The right recursion will take the remaining elements smaller than bound
 *
 *  Complexity
 *  bstFromPreorder is called exactly N times.
 *  It's same as a preorder traversal.
 *  Time: O(N)
 * 
 */
// class ConstructBinarySearchTreefromPreorderTraversal {

//     int i = 0;
//     public TreeNode bstFromPreorder(int[] A) {
//         return bstFromPreorder(A, Integer.MAX_VALUE);
//     }

//     public TreeNode bstFromPreorder(int[] A, int bound) {
//         if (i == A.length || A[i] > bound) return null;
//         TreeNode root = new TreeNode(A[i++]);
//         root.left = bstFromPreorder(A, root.val);
//         root.right = bstFromPreorder(A, bound);
//         return root;
//     }
// }
