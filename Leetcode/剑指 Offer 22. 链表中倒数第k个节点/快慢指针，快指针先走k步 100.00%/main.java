

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
        ListNode a1 = new ListNode(1);
        ListNode a2 = new ListNode(2);
        ListNode a3 = new ListNode(3);
        ListNode a4 = new ListNode(4);
        ListNode a5 = new ListNode(5);
        a1.next = a2;
        a2.next = a3;
        a3.next = a4;
        a4.next = a5;

        System.out.println(main.getKthFromEnd(a1,3).val);

    }

    public ListNode getKthFromEnd(ListNode head, int k) {
        if (head == null)
            return null;
        ListNode fast = head;
        while (k > 0 && fast != null) {
            k--;
            fast = fast.next;
        }
        if (fast == null && k > 0)
            return null;
        ListNode slow = head;
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }

}
