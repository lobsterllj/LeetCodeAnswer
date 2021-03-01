import java.util.*;

public class main {
    public static void main(String[] args) {
        main main = new main();
        prtMatrix prtMatrix = new prtMatrix();
        prtInts prtInts = new prtInts();


    }

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

    public List<TreeNode> generateTrees(int n) {
        List<TreeNode> res = new ArrayList<>();
        if (n == 0)
            return res;
        if (n == 1) {
            res.add(new TreeNode(1));
            return res;
        }

        return getTrees(1, n);
    }

    // 返回由 [sta, end] 组成的二叉搜索树的根节点集合
    public List<TreeNode> getTrees(int sta, int end) {
        List<TreeNode> res = new ArrayList<>();
        if (sta > end)
            return res;
        if (sta == end) {
            res.add(new TreeNode(sta));
            return res;
        }

        for (int curV = sta; curV <= end; ++curV) {
            List<TreeNode> lefts = getTrees(sta, curV - 1);
            List<TreeNode> rights = getTrees(curV + 1, end);
            if (lefts.size() == 0) {
                for (TreeNode t : rights) {
                    TreeNode cur = new TreeNode(curV, null, t);
                    res.add(cur);
                }
            } else if (rights.size() == 0) {
                for (TreeNode t : lefts) {
                    TreeNode cur = new TreeNode(curV, t, null);
                    res.add(cur);
                }
            } else {
                for (TreeNode tl : lefts) {
                    for (TreeNode tr : rights) {
                        TreeNode cur = new TreeNode(curV, tl, tr);
                        res.add(cur);
                    }
                }
            }
        }

        return res;
    }

}
