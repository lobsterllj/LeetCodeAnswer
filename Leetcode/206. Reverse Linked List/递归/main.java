import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class main {
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
        main main = new main();
        ListNode a=new ListNode(1);
        ListNode b=new ListNode(2);
        ListNode c=new ListNode(3);
        ListNode d=new ListNode(4);
        ListNode e=new ListNode(5);
        a.next=b;
        b.next=c;
        c.next=d;
        d.next=e;
        ListNode rever=main.reverseList(a);
        while (rever!=null){
            System.out.println(rever.val);
            rever=rever.next;
        }

    }

    public ListNode reverseList(ListNode head) {
        System.out.println("head-1 "+head.val);
        if(head==null||head.next==null){
            System.out.println("head0 "+head.val);
            return head;
        }
        ListNode cur=reverseList(head.next);
        System.out.println("head1 "+head.val);

        head.next.next=head;
        head.next= null;
        return cur;
    }

}





