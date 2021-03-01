public class main {

    public static void main(String[] args) {
        main main=new main();
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(3);
        ListNode d = new ListNode(4);
        ListNode e = new ListNode(5);
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        ListNode rever = main.reverseList2(a);
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

    //迭代方法2
    public ListNode reverseList(ListNode head) {
        ListNode cur = null;
        ListNode pre = head;

        while (pre!= null) {
            ListNode cache=pre.next;
            pre.next=cur;
            cur=pre;
            pre=cache;
        }
        return cur;
    }
    //迭代方法1
    public ListNode reverseList1(ListNode head) {
        if (head == null )
            return null;
        ListNode newhead = head;
        ListNode cache = head.next;

        while (head.next != null) {
            head.next=cache.next;
            cache.next=newhead;
            newhead=cache;
            cache=head.next;


        }
        return newhead;
    }

    public ListNode reverseList2(ListNode head) {
        System.out.println("head-1 " + head.val);
        System.out.println("head.next-1 " + head.next.val);
        if (head == null || head.next == null) {
            return head;
        }
        ListNode res = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return res;
    }




}
