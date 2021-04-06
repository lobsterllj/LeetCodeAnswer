import java.util.*;

public class main {

    public static void main(String[] args) {
        main main = new main();

        TreeNode a0 = new TreeNode(1);
        TreeNode a1 = new TreeNode(2);
        TreeNode a2 = new TreeNode(3);
        a0.left = a1;
        a0.right = a2;


        TreeNode a3 = new TreeNode(4);
        TreeNode a4 = new TreeNode(5);

        a2.left = a3;
        a2.right = a4;
        String s=main.serialize(a0);
        main.deserialize(s);


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


    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null)
            return "[null]";
        Deque<TreeNode> unvisited = new ArrayDeque<>();
        StringBuilder res = new StringBuilder();
        res.append("[");
        res.append(root.val + ",");
        unvisited.addLast(root);
        while (!unvisited.isEmpty()) {
            TreeNode cache = unvisited.pollFirst();
            if (cache.left != null) {
                res.append(cache.left.val + ",");
                unvisited.addLast(cache.left);
            } else {
                res.append("null,");
            }
            if (cache.right != null) {
                res.append(cache.right.val + ",");
                unvisited.addLast(cache.right);
            } else {
                res.append("null,");
            }
        }
        res.setLength(res.length() - 1);
        res.append("]");
        return res.toString();
    }


    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        data=data.substring(1,data.length()-1);
//        System.out.println(data);
        String[] nodes_str=data.split(",");
        if(nodes_str.length==1)
            return getnode(nodes_str[0]);
        for (int i = 0; i < nodes_str.length; i++) {
            System.out.println(nodes_str[i]);
        }
        TreeNode root=getnode(nodes_str[0]);
        Deque<TreeNode> parents=new ArrayDeque<>();
        parents.addLast(root);
        boolean isright=false;
        for(int i=1;i< nodes_str.length;++i){
            TreeNode cur=getnode(nodes_str[i]);
            if(cur!=null)
                parents.addLast(cur);

            if(!isright){
                TreeNode father=parents.peekFirst();
                father.left=cur;
                isright=true;
            }
            else {
                TreeNode father=parents.peekFirst();
                father.right=cur;
                isright=false;
                parents.pollFirst();
            }

        }
        return root;
    }

    public TreeNode getnode(String s) {
        if (s.equals("null"))
            return null;
        else
            return new TreeNode(Integer.valueOf(s));
    }


}
