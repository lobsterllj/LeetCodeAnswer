import java.util.ArrayList;
import java.util.List;

public class main {

    public static void main(String[] args) {
        main main = new main();

        int[] preorder = new int[]{1, 2, 3};
        int[] inorder = new int[]{3, 2, 1};

        main.buildTree(preorder, inorder);

    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0)
            return null;
        if (preorder.length == 1)
            return new TreeNode(preorder[0]);
        return recur(preorder, inorder, 0, 0, preorder.length);
    }

    public TreeNode recur(int[] preorder, int[] inorder, int sta_P, int sta_i, int len) {
        System.out.println("sta_P:" + sta_P + " sta_i:" + sta_i + " len:" + len);

        if (len <= 0)
            return null;
        TreeNode root = new TreeNode(preorder[sta_P]);
        if (len == 1)
            return root;

        int split_index = 0;
        for (int i = sta_i; i < sta_i + len; ++i) {
            if (inorder[i] == preorder[sta_P]) {
                split_index = i;
                break;
            }
        }

        System.out.println("splitPoint:" + inorder[split_index]);
        int len_l;
        int len_r;

        int sta_P_L = 0;
        int sta_i_L = 0;

        int sta_P_R = 0;
        int sta_i_R = 0;

        len_l = split_index - sta_i;
        len_r = len - 1 - len_l;


        //len不为1，故左右至少有一非空
        if (len_l == 0) {
            //左子树为空
            sta_P_R = sta_P + 1;
            sta_i_R = sta_i + 1;
        } else if (len_r == 0) {
            //右子树为空
            sta_P_L = sta_P + 1;
            sta_i_L = sta_i;
        } else {
            //左右均非空
            //左子树
            sta_P_L = sta_P + 1;
            sta_i_L = sta_i;
            //右子树
            sta_P_R = sta_P + len_l + 1;
            sta_i_R = sta_i + len_l + 1;

        }

        System.out.println("len_l:" + len_l + " len_r:" + len_r);
        root.left = recur(preorder, inorder, sta_P_L, sta_i_L, len_l);
        root.right = recur(preorder, inorder, sta_P_R, sta_i_R, len_r);

        return root;
    }
}
