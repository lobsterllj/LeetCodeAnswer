import java.util.*;

public class main {

    public static void main(String[] args) {
        main main = new main();
        ListNode a0 = new ListNode(1);
        ListNode a1 = new ListNode(2);
        ListNode a2 = new ListNode(4);
        a0.next = a1;
        a1.next = a2;

        ListNode b0 = new ListNode(1);
        ListNode b1 = new ListNode(3);
        ListNode b2 = new ListNode(4);
        b0.next = b1;
        b1.next = b2;


        ListNode res = main.mergeTwoLists(a0, b0);
//        System.out.println(res);
        while (res != null) {
            System.out.println(res.val);
            res = res.next;
        }

    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1==null)
            return l2;
        if(l2==null)
            return l1;
        if(l1.val< l2.val){
            l1.next=mergeTwoLists(l1.next,l2);
            return l1;
        }
        else {
            l2.next=mergeTwoLists(l1,l2.next);
            return l2;
        }
    }

}





