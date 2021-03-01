import java.util.*;

public class main {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
        main main = new main();

    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();

        if (root == null)
            return res;
        Deque<TreeNode> unvisited = new ArrayDeque<>();
        boolean leftflag = true;
        unvisited.addLast(root);
        while (!unvisited.isEmpty()) {
            List<Integer> temp = new ArrayList<>();
            for (int i = unvisited.size(); i > 0; --i) {
                if (leftflag) {
                    TreeNode cache = unvisited.pollFirst();
                    temp.add(cache.val);
                    if (cache.left != null)
                        unvisited.addLast(cache.left);
                    if (cache.right != null)
                        unvisited.addLast(cache.right);
                } else {
                    TreeNode cache = unvisited.pollLast();
                    temp.add(cache.val);
                    if (cache.right != null)
                        unvisited.addFirst(cache.right);
                    if (cache.left != null)
                        unvisited.addFirst(cache.left);
                }
            }
            res.add(temp);
            leftflag = !leftflag;
        }
        return res;
    }

}

