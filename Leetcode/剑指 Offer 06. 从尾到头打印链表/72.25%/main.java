import java.util.ArrayList;
import java.util.List;

public class main {

    public static void main(String[] args) {
        main main = new main();

    }

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public int[] reversePrint(ListNode head) {
        if (head == null)
            return new int[]{};
        List<Integer> res_list = new ArrayList<>();
        visit(head, res_list);
        int[] res = new int[res_list.size()];
        for (int i = 0; i < res.length; ++i) {
            res[i] = res_list.get(res.length - i - 1);
        }
        return res;
    }

    public void visit(ListNode head, List<Integer> res_list) {
        while (head != null) {
            res_list.add(head.val);
            head = head.next;
        }
    }
}
