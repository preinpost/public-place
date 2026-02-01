package leetcode.N662;

import java.util.LinkedList;
import java.util.Queue;

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

class Pair {
    TreeNode treeNode;
    int index;

    public Pair(TreeNode treeNode, int index) {
        this.treeNode = treeNode;
        this.index = index;
    }

    public TreeNode getTreeNode() {
        return treeNode;
    }

    public int getIndex() {
        return index;
    }
}


public class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        return BFS(root);
    }

    public int BFS(TreeNode root) {

        Queue<Pair> Q = new LinkedList<>();
        Q.offer(new Pair(root, 1));
        int width = 0;

        while (!Q.isEmpty()) {
            int size = Q.size();

            int min = 0;
            int max = 0;


            for (int i = 0; i < size; i++) {
                Pair currentPair = Q.poll();

                if (currentPair.getTreeNode().left != null) Q.offer(new Pair(currentPair.getTreeNode().left, 2 * currentPair.getIndex()));
                if (currentPair.getTreeNode().right != null) Q.offer(new Pair(currentPair.getTreeNode().right, 2 * currentPair.getIndex() + 1));

                if (i == 0) min = currentPair.getIndex();
                if (i == size - 1) max = currentPair.getIndex();
            }
            width = Math.max(width, max - min + 1);
        }

        return width;
    }

    public static void main(String[] args) {

        Solution T = new Solution();

        Integer[] inputs = new Integer[] {1,3,2,5,3,null,9};

        TreeNode root = new TreeNode(1);
        TreeNode a = new TreeNode(3);
        TreeNode b = new TreeNode(2);
        TreeNode c = new TreeNode(5);
        TreeNode d = new TreeNode(3);
        TreeNode f = new TreeNode(9);

        root.left = a;
        root.right = b;
        root.left.left = c;
        root.left.right = d;
        root.right.right = f;

        int i = T.widthOfBinaryTree(root);
    }
}