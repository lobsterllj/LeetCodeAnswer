import java.util.HashMap;
import java.util.List;

public class main {

    public static void main(String[] args) {
        main main = new main();
        ListNode a = new ListNode(4);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(1);
        ListNode d = new ListNode(3);
        ListNode e = new ListNode(5);
        a.next = b;
        b.next = c;
        c.next = d;


        ListNode a1 = new ListNode(-1);
        ListNode b1 = new ListNode(5);
        ListNode c1 = new ListNode(3);
        ListNode d1 = new ListNode(4);
        ListNode e1 = new ListNode(0);
        a1.next = b1;
        b1.next = c1;
        c1.next = d1;
        d1.next = e1;

        ListNode a2 = new ListNode(1);
        ListNode b2 = new ListNode(1);
        a2.next = b2;

        ListNode rever = main.insertionSortList(a2);
        while (rever != null) {
            System.out.println(rever.val);
            rever = rever.next;
        }
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode res = new ListNode(-1);
        ListNode headLast = new ListNode(-1);

        while (head != null) {
            //外层按照原顺序遍历所有节点
            CopyandSort(head, res,headLast);
            head = head.next;
        }
        return res.next;
    }

    public void CopyandSort(ListNode head, ListNode headPre,ListNode headLast) {
        ListNode copy = headPre.next;//res中的节点
        ListNode uninserted = new ListNode(head.val);//待插入的节点
        if (headPre.next == null) {//res中无节点
            headPre.next = uninserted;
            headLast.next=uninserted;
            return;
        }
        if (uninserted.val < copy.val) {//比第一个节点小
            uninserted.next = copy;
            headPre.next = uninserted;
            return;
        }
        if(uninserted.val>=headLast.next.val){//比最后一个节点大
            headLast.next.next=uninserted;
            headLast.next=uninserted;
            return;
        }
        ListNode copyPre= new ListNode(-1);//copy前节点
        copyPre.next=copy;
        while (copy != null) {
            if (uninserted.val<copy.val) {
                copyPre.next=uninserted;
                uninserted.next = copy;
                return;
            }
            copyPre=copyPre.next;
            copy=copy.next;
        }
    }


}
