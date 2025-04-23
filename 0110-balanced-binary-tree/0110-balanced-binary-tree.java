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
    static int minVal = Integer.MAX_VALUE;
    static int maxVal = 0;

    public static void treeLevel(TreeNode node, int level) {
        if (node == null) {
            if (minVal > level - 1) {
                minVal = level - 1;
            }
            return;
        }
        if (maxVal < level) {
            maxVal = level;
        }
        TreeNode left = node.left;
        TreeNode right = node.right;
        treeLevel(left, level + 1);
        treeLevel(right, level + 1);
    }

    public boolean isBalanced(TreeNode root) {
        if (root != null) {
            // 루트만 있어도 균형잡힌 것
            if (root.left == null && root.right == null) {
                return true;
            }
            treeLevel(root, 0);
            if (maxVal - minVal <= 1) {
                return true;
            } else {
                return false;
            }
            
        } else {  // 빈 것이면 균형이므로 true
            return true;
        }
    
    }
}