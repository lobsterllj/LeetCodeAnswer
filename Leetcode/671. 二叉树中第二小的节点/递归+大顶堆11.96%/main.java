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

    public int findSecondMinimumValue(TreeNode root) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        midtraver(root, maxHeap);
        if (maxHeap.size() == 2)
            return maxHeap.peek();
        else
            return -1;
    }

    public void midtraver(TreeNode root, PriorityQueue<Integer> maxHeap) {
        if (root == null)
            return;
        midtraver(root.left, maxHeap);
        if (maxHeap.size() == 0)
            maxHeap.add(root.val);
        else if (maxHeap.size() == 1 && maxHeap.peek() != root.val) {
            maxHeap.add(root.val);
        } else if (maxHeap.size() == 2 && maxHeap.peek() > root.val) {
            int org=maxHeap.poll();
            if (maxHeap.peek() != root.val)
                maxHeap.add(root.val);
            else {
                maxHeap.add(org);
            }
        }
        midtraver(root.right, maxHeap);
    }


}
