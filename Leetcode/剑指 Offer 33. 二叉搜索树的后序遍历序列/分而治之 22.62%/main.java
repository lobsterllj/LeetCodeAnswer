import java.util.*;

public class main {
    public static void main(String[] args) {
        main main = new main();
        int[] ints = new int[]{5, 2, -17, -11, 25, 76, 62, 98, 92, 61};
        System.out.println(main.verifyPostorder(ints));

    }


    public boolean verifyPostorder(int[] postorder) {
        if (postorder.length < 3)
            return true;
        return issearch(postorder, 0, postorder.length - 1);
    }

    public boolean issearch(int[] postorder, int sta, int end) {
        if (sta == end)
            return true;
        boolean left = false;
        int index_left = -1;
        for (int i = end - 1; i >= sta; --i) {
            if (left) {
                if (postorder[i] > postorder[end])
                    return false;
            }
            if (postorder[i] < postorder[end]) {
                left = true;
                index_left = i;
            }
        }
        //左子树为空，遍历右子树合理性
        if (index_left == -1)
            return issearch(postorder, sta, end - 1);
        //右子树为空，遍历左子树合理性
        else if(index_left==sta)
            return issearch(postorder, sta, end - 1);
        else
            return issearch(postorder, sta, index_left) && issearch(postorder, index_left + 1, end - 1);
    }

}

