import jdk.swing.interop.SwingInterOpUtils;

import javax.lang.model.type.IntersectionType;
import java.net.http.WebSocketHandshakeException;
import java.sql.SQLOutput;
import java.util.*;

public class main {

    public static void main(String[] args) {
        main main = new main();
        int[] ints = new int[]{1, -2, -5, -4, -3, 3, 3, 5};


//        List res = main.fourSum(ints, -11);
//        res.forEach(it -> System.out.println(it));

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

    public List<Integer> inorderTraversal(TreeNode root) {
        Deque<TreeNode> stack=new LinkedList<>();
        List<Integer> res=new ArrayList<>();
        while (root!=null||!stack.isEmpty()){
            while (root!=null){
                stack.push(root);
                root=root.left;
            }
            root=stack.pop();
            res.add(root.val);
            root=root.right;
        }
        return res;
    }


    public int kthSmallest(TreeNode root, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        midtraver1(root, maxHeap, k);
        return maxHeap.peek();

    }

    public void midtraver1(TreeNode root, PriorityQueue<Integer> maxHeap, int k) {
        if (root == null)
            return;
        midtraver1(root.left, maxHeap, k);
        if (maxHeap.size() < k)
            maxHeap.add(root.val);
        else if (maxHeap.peek() > root.val) {
            maxHeap.poll();
            maxHeap.add(root.val);
        }
        midtraver1(root.right, maxHeap, k);
    }


}
