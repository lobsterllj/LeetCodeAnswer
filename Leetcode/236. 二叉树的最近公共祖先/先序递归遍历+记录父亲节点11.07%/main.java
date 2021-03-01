import jdk.swing.interop.SwingInterOpUtils;

import javax.lang.model.type.IntersectionType;
import java.net.http.WebSocketHandshakeException;
import java.sql.SQLOutput;
import java.util.*;

public class main {

    public static void main(String[] args) {
        main main = new main();
        int[] ints = new int[]{1, -2, -5, -4, -3, 3, 3, 5};

        TreeNode a0 = new TreeNode(3);
        TreeNode a1 = new TreeNode(5);
        TreeNode a2 = new TreeNode(1);
        a0.left = a1;
        a0.right = a2;


        TreeNode a3 = new TreeNode(2);
        TreeNode a4 = new TreeNode(7);
        TreeNode a5 = new TreeNode(4);
        a1.right = a3;
        a3.left = a4;
        a3.right = a5;

        System.out.println(main.lowestCommonAncestor(a0, a1, a5).val);



    }

    static class TreeNode {
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

    public void dfs(TreeNode root, Map val_father) {
        if (root == null)
            return;
        if (root.left != null) {
            val_father.put(root.left.val, root);
            dfs(root.left, val_father);
        }
        if (root.right != null) {
            val_father.put(root.right.val, root);
            dfs(root.right, val_father);
        }
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        Map<Integer, TreeNode> val_father = new HashMap<>();
        Set<Integer> ancestor_p = new HashSet<>();
        dfs(root, val_father);
        ancestor_p.add(p.val);
        while (val_father.get(p.val) != null) {
            p = val_father.get(p.val);
            ancestor_p.add(p.val);
        }
        while (q != null) {
            if (ancestor_p.contains(q.val)) {
                return q;
            }
            q = val_father.get(q.val);
        }
        return null;
    }




}
