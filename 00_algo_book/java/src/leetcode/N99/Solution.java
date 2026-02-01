package leetcode.N99;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class Solution {

    TreeNode first;
    TreeNode second;
    TreeNode prev ;

    public void recoverTree(TreeNode root) {
        recursive(root);
        int tmp = first.val;
        first.val = second.val;
        second.val = tmp;
        System.out.println();
    }

    public void recursive(TreeNode root) {
        if (root == null) return;


        recursive(root.left);
        if (prev != null && prev.val > root.val) {
            if (first == null) first = prev;
            second = root;
        }

        prev = root;
        recursive(root.right);

    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(4);
        root.right = new TreeNode(2);

//        TreeNode root = new TreeNode(3);
//        root.left = new TreeNode(2);
//        root.right = new TreeNode(1);

        sol.recoverTree(root);
    }
}
