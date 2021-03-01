import java.util.*;

public class main {
    static class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    }

    public static void main(String[] args) {
        main main = new main();
        Node a1 = new Node(4);
        Node a2 = new Node(2);
        Node a3 = new Node(5);
        Node a4 = new Node(1);
        Node a5 = new Node(3);
        a1.left = a2;
        a1.right = a3;
        a2.left = a4;
        a2.right = a5;

//        main.visit(a1);

        Node b1 = new Node(2);
        Node b2 = new Node(1);
        b1.right = b2;

        Node c1 = new Node(-1);
        Node c2 = new Node(1);
        Node c3 = new Node(9);
        c1.right = c2;
        c2.right = c3;


        Node res = main.treeToDoublyList(c1);
        int index = 10;
        while (index > 0) {
            System.out.println(res.val);
            res = res.right;
            index--;
        }
    }
    public void visit(Node root) {
        if(root==null)
            return;
        visit(root.left);
        System.out.println(root.val);
        visit(root.right);
    }
    public Node treeToDoublyList(Node root) {
        if (root == null)
            return null;

        Node mid1 = root;
        Node mid2 = root;
        link(root);
        while (mid1.right != null) {
            mid1 = mid1.right;
        }
        while (mid2.left != null) {
            mid2 = mid2.left;
        }

        mid1.right = mid2;
        mid2.left = mid1;
        return mid2;
    }
    public Node pre=null;
    public void link(Node root) {
//        if (root != null)
//            System.out.println(root.val);
        if (root == null)
            return;
        link(root.left);
        if(pre!=null){
            pre.right=root;
            root.left=pre;
        }
        pre=root;
        link(root.right);
    }


}

