import java.util.*;

public class main {

    public static void main(String[] args) {
        main main = new main();
        ListNode a0 = new ListNode(3);
        ListNode a1 = new ListNode(2);
        ListNode a2 = new ListNode(0);
        ListNode a3 = new ListNode(-4);

        a0.next = a1;
        a1.next = a2;
        a2.next = a3;
        a3.next = a0;



        boolean res=main.hasCycle(a0);
        System.out.println(res);
//        while (res != null) {
//            System.out.println(res.val);
//            if (res.random != null)
//                System.out.println(res.random.val);
//            else
//                System.out.println(-1);
//            res = res.next;
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

    public boolean hasCycle(ListNode head) {
        if(head==null)
            return false;
        ListNode fast=head;
        ListNode slow=head;
        while (true){
            if(fast==null||fast.next==null||slow==null)
                return false;
            fast=fast.next.next;
            slow=slow.next;
            if(fast==slow)
                return true;

        }

    }

}





