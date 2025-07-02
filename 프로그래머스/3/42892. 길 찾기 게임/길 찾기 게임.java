import java.util.*;

class Solution {
    static List<Integer> preOrder = new ArrayList<>();
    static List<Integer> postOrder = new ArrayList<>();

    static class TreeNode {
        int number;
        int x;
        int y;
        TreeNode left;
        TreeNode right;

        public TreeNode(int x, int y, int number) {
            this.number = number;
            this.x = x;
            this.y = y;
            this.left = null;
            this.right = null;
        }
    }

    private static void insert(TreeNode parent, TreeNode child) {
        if (child.x < parent.x) {
            if (parent.left == null) {
                parent.left = child;
            } else {
                insert(parent.left, child);
            }
        } else {
            if (parent.right == null) {
                parent.right = child;
            } else {
                insert(parent.right, child);
            }
        }
    }

    private void preorder(TreeNode node) {
        if (node == null) {
            return;
        }
        preOrder.add(node.number);
        preorder(node.left);
        preorder(node.right);
    }

    private void postorder(TreeNode node) {
        if (node == null) {
            return;
        }
        postorder(node.left);
        postorder(node.right);
        postOrder.add(node.number);
    }


    public static int[][] solution(int[][] nodeinfo) {
        int[][] nodeinfos = new int[nodeinfo.length][3];
        for (int i = 0; i < nodeinfo.length; i++) {
            nodeinfos[i][0] = nodeinfo[i][0];
            nodeinfos[i][1] = nodeinfo[i][1];
            nodeinfos[i][2] = i + 1;
        }

        Arrays.sort(nodeinfos, (int[] a, int[] b) -> {
            if (a[1] == b[1]) {
                return a[0] - b[0];
            } else {
                return b[1] - a[1];
            }
        });
        TreeNode root = new TreeNode(nodeinfos[0][0], nodeinfos[0][1], nodeinfos[0][2]);

        for (int i = 1; i < nodeinfo.length; i++) {
            insert(root, new TreeNode(nodeinfos[i][0], nodeinfos[i][1], nodeinfos[i][2]));
        }
        Solution sol = new Solution();
        sol.preorder(root);
        sol.postorder(root);

        int[][] answer = new int[2][];
        int[] pre = new int[preOrder.size()];
        for (int i = 0; i < preOrder.size(); i++) {
            pre[i] = preOrder.get(i);
        }
        int[] post = new int[postOrder.size()];
        for (int i = 0; i < postOrder.size(); i++) {
            post[i] = postOrder.get(i);
        }
        answer[0] = pre;
        answer[1] = post;


        return answer;
    }
}