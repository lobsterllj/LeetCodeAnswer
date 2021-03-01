import java.util.LinkedList;
import java.util.List;

public class main {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {

        TreeNode a = new TreeNode(1);
        TreeNode b = new TreeNode(2);
        TreeNode c = new TreeNode(3);
        TreeNode d = new TreeNode(4);

        a.left = b;
        a.right = c;
        b.left = d;

        main main = new main();
        System.out.println(main.sumNumbers(a));


    }

    public int sumNumbers(TreeNode root) {
        if (root == null)
            return 0;
        else {
            List<Integer> cache = new LinkedList<>();
            List<Integer> temp = new LinkedList<>();
            visit(root, cache, temp);
            int res = 0;
            for (Integer it : temp)
                res += it;
            return res;
        }
    }

    public void visit(TreeNode root, List<Integer> cache, List<Integer> temp) {
        cache.add(root.val);
        if (root.left == null && root.right == null) {
            System.out.println("return_node:" + root.val);
            int buffer = 0;
            for (int it : cache) {
                buffer = buffer * 10 + it;
            }
            temp.add(buffer);

            for (int it : cache) {
                System.out.println("it:" + it);
            }
            System.out.println("temp:" + temp);
            return;
        }
        System.out.println("root.val:" + root.val);

        if (root.left != null) {
            visit(root.left, cache, temp);
            cache.remove(cache.size() - 1);
        }
        if (root.right != null) {
            visit(root.right, cache, temp);
            cache.remove(cache.size() - 1);
        }
    }

}
