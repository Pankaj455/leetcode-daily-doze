import java.util.*;

public class leetcode103 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new LinkedList<>();
        if (root == null)
            return ans;
        Stack<TreeNode> ltor = new Stack<>();
        Stack<TreeNode> rtol = new Stack<>();
        ltor.add(root);
        while (!ltor.isEmpty() || !rtol.isEmpty()) {
            if (!ltor.isEmpty()) {
                List<Integer> li = new LinkedList<>();
                while (!ltor.isEmpty()) {
                    TreeNode node = ltor.pop();
                    li.add(node.val);
                    if (node.left != null)
                        rtol.push(node.left);
                    if (node.right != null)
                        rtol.push(node.right);
                }
                ans.add(li);
            } else {
                List<Integer> li = new LinkedList<>();
                while (!rtol.isEmpty()) {
                    TreeNode node = rtol.pop();
                    li.add(node.val);
                    if (node.right != null)
                        ltor.push(node.right);
                    if (node.left != null)
                        ltor.push(node.left);
                }
                ans.add(li);
            }
        }
        return ans;
    }
}
