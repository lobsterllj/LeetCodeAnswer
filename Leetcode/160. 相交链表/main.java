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
        ListNode b2 = new ListNode(2);
        ListNode c2 = new ListNode(3);
        ListNode d2 = new ListNode(4);
        ListNode e2 = new ListNode(5);
        a2.next = b2;
        b2.next = c2;
        c2.next = d2;
        d2.next = e2;

        //main.recursive(a2);

        ListNode a3 = new ListNode(4);
        ListNode b3 = new ListNode(1);
        ListNode c3 = new ListNode(8);
        ListNode d3 = new ListNode(4);
        ListNode e3 = new ListNode(5);
        a3.next = b3;
        b3.next = c3;
        c3.next = d3;
        d3.next = e3;

        ListNode a4 = new ListNode(5);
        ListNode b4 = new ListNode(0);
        ListNode c4 = new ListNode(1);
        a4.next = b4;
        b4.next = c4;
        c4.next = c3;

        System.out.println(main.getIntersectionNode(a3, b4).val);

//        ListNode dummy = a2;
//        a2 = a2.next;
//        System.out.println(dummy.val);
//        System.out.println(a2.val);
//        ListNode rever = main.mergesort(a);
//        while (rever != null) {
//            System.out.println(rever.val);
//            rever = rever.next;
//        }
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lenA=0,lenB=0;
        ListNode hA=headA;
        while (hA!=null){
            lenA++;
            hA=hA.next;
        }
        ListNode hB=headB;
        while (hB!=null){
            lenB++;
            hB=hB.next;
        }
        int dlen;
        if(lenA>lenB){
            dlen=lenA-lenB;
            while (dlen>0){
                headA=headA.next;
                dlen--;
            }
        }
        else if(lenA<lenB){
            dlen=lenB-lenA;
            while (dlen>0){
                headB=headB.next;
                dlen--;
            }
        }
        while (headA!=null){
            if(headA.equals(headB))
                return headA;
            headA=headA.next;
            headB=headB.next;
        }
        return null;
    }

    public ListNode recursive(ListNode head) {
        if (head == null)
            return head;
        ListNode headPre = recursive(head.next);
        System.out.println(head.val);
        return headPre;
    }


    //待完善
    public ListNode[] recursives(ListNode head1, ListNode head2) {
        if (head1 == null && head2 == null)
            return new ListNode[]{head1, head2};
        ListNode[] headPres = new ListNode[2];
        headPres[0] = head1;
        headPres[1] = head2;
        System.out.println("0:" + headPres[0].val + " 1:" + headPres[1].val);

        if (head1 != null && head2 != null) {
            headPres = recursives(head1.next, head2.next);
        } else if (head1 == null && head2 != null) {
            headPres = recursives(head1, head2.next);
        } else if (head1 != null && head2 == null) {
            headPres = recursives(head1.next, head2);
        }
        System.out.println("0:" + headPres[0].val + " 1:" + headPres[1].val);
        return headPres;
    }


    public ListNode merge(ListNode a1, ListNode a2) {
        if (a1 == null)
            return a2;
        if (a2 == null)
            return a1;
        if (a1.val < a2.val) {
            a1.next = merge(a1.next, a2);
            return a1;
        } else {
            a2.next = merge(a1, a2.next);
            return a2;
        }
    }

    public ListNode mergesort(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode dummy = head;
        ListNode fast = head.next;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode righthead = slow.next;
        slow.next = null;

        ListNode left = mergesort(dummy);
        ListNode right = mergesort(righthead);

        return merge(left, right);
    }

    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode res = new ListNode(-1);
        ListNode headLast = new ListNode(-1);

        while (head != null) {
            //外层按照原顺序遍历所有节点
            CopyandSort(head, res, headLast);
            head = head.next;
        }
        return res.next;
    }

    public void CopyandSort(ListNode head, ListNode headPre, ListNode headLast) {
        ListNode copy = headPre.next;//res中的节点
        ListNode uninserted = new ListNode(head.val);//待插入的节点
        if (headPre.next == null) {//res中无节点
            headPre.next = uninserted;
            headLast.next = uninserted;
            return;
        }
        if (uninserted.val < copy.val) {//比第一个节点小
            uninserted.next = copy;
            headPre.next = uninserted;
            return;
        }
        if (uninserted.val >= headLast.next.val) {//比最后一个节点大
            headLast.next.next = uninserted;
            headLast.next = uninserted;
            return;
        }
        ListNode copyPre = new ListNode(-1);//copy前节点
        copyPre.next = copy;
        while (copy != null) {
            if (uninserted.val < copy.val) {
                copyPre.next = uninserted;
                uninserted.next = copy;
                return;
            }
            copyPre = copyPre.next;
            copy = copy.next;
        }
    }


}
