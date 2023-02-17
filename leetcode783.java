/**
 * leetcode783
 * minimum difference between any nodes in BST
 */
public class leetcode783 {
    ArrayList<Integer> nodeList;

    public int minDiffInBST(TreeNode root) {
        nodeList = new ArrayList<>();
        createList(root);
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < nodeList.size() - 1; i++) {
            int diff = Math.abs(nodeList.get(i) - nodeList.get(i + 1));
            min = Math.min(min, diff);
        }
        return min;
    }

    public void createList(TreeNode root) {
        if (root == null)
            return;
        createList(root.left);
        nodeList.add(root.val);
        createList(root.right);
    }
}