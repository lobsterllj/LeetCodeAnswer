import javax.sound.midi.Soundbank;
import java.util.*;

public class main {
    public static void main(String[] args) {
        main main = new main();
        int[] ints = new int[]{1, 2, 3, 1};

        ListNode a6 = new ListNode(6);
        ListNode a5 = new ListNode(5, a6);
        ListNode a4 = new ListNode(4, a5);
        ListNode a3 = new ListNode(3, a4);
        ListNode a2 = new ListNode(2, a3);
        ListNode a1 = new ListNode(1, a2);
//        while (a1!=null){
//            System.out.println("a1.val:"+ a1.val);
//            a1=a1.next;
//        }
        ListNode res = main.oddEvenList(a1);
        while (res != null) {
            System.out.println("res.val:" + res.val);
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

    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null || head.next.next == null)
            return head;
        ListNode odd_head = new ListNode();
        ListNode odd = head;
        odd_head.next = odd;
        //System.out.println("odd_head.next.val:" + odd_head.next.val);
        ListNode even_head = new ListNode();
        ListNode even = head.next;
        even_head.next = even;
        //System.out.println("even_head.next.val:" + even_head.next.val);

        while (even.next != null) {
            //System.out.println("odd.val:" + odd.val);
            odd.next = odd.next.next;
            odd = odd.next;
            //System.out.println("odd.val:" + odd.val);

            if (even.next.next == null) {
                even.next = null;
                break;
            }
            //System.out.println("even.val:" + even.val);
            even.next = even.next.next;
            even = even.next;
            //System.out.println("even.val:" + even.val);
        }
        odd.next = even_head.next;

        return odd_head.next;
        //        System.out.println("odd_head.next.val:" + odd_head.next.val);
//        odd_head = odd_head.next;
//        System.out.println("odd_head.next.val:" + odd_head.next.val);
//        odd_head = odd_head.next;
//        System.out.println("odd_head.next.val:" + odd_head.next.val);
//        odd_head = odd_head.next;
//        System.out.println("odd_head.next.val:" + odd_head.next.val);
//        odd_head = odd_head.next;
//        System.out.println("odd_head.next.val:" + odd_head.next.val);
//        odd_head = odd_head.next;
//        System.out.println("odd_head.next.val:" + odd_head.next.val);
//        odd_head = odd_head.next;
//        System.out.println("odd_head.next.val:" + odd_head.next.val);
//        odd_head = odd_head.next;

//        ListNode newnode=odd_head.next;
//        while(newnode!=null)
//        {
//            System.out.println("newnode.val:"+ newnode.val);
//            newnode=newnode.next;
//        }
        //return new ListNode(1);
    }


}





