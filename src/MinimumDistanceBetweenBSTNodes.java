class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class MinimumDistanceBetweenBSTNodes {
    long result = Integer.MAX_VALUE;

    public int minDiffInBST(TreeNode root) {
        computeMinAbsoluteDifference(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
        return (int) result;
    }

    public void computeMinAbsoluteDifference(TreeNode root, long left, long right) {
        if (root == null) return;
        result = Math.min(result, Math.min(root.val - left, right - root.val));
        computeMinAbsoluteDifference(root.left, left, root.val);
        computeMinAbsoluteDifference(root.right, root.val, right);
    }
}
