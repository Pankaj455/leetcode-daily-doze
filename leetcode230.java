/*
 * kth smallest element in BST
 */
public class leetcode230 {
    int kth = 1, val = 0;

    public int kthSmallest(TreeNode root, int k) {
        kthSmallestHelper(root, k);
        return val;
    }

    public void kthSmallestHelper(TreeNode root, int k) {
        if (root == null)
            return;
        kthSmallestHelper(root.left, k);
        if (kth == k) {
            val = root.val;
        }
        kth++;
        kthSmallestHelper(root.right, k);
    }
}
