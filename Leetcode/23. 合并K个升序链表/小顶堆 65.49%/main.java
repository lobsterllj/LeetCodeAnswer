import java.util.PriorityQueue;

public class main {

    public class ListNode {
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

    public static void main(String[] args) {
        main main = new main();

    }


    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0)
            return null;
        if (lists.length == 1)
            return lists[0];
//        ListNode[] heads = new ListNode[lists.length];
//        for (int i = 0; i < lists.length; ++i)
//            heads[i] = new ListNode();
        ListNode dummy = new ListNode();
        PriorityQueue<ListNode> minheap = new PriorityQueue<>((a, b) -> a.val - b.val);
        for (int i = 0; i < lists.length; ++i) {
            if (lists[i] != null) {
                minheap.add(lists[i]);
            }
        }
        dummy.next = minheap.peek();
        while (!minheap.isEmpty()) {
            ListNode cache1 = minheap.poll();
            if (cache1.next != null)
                minheap.add(cache1.next);
            cache1.next = minheap.peek();

        }
        return dummy.next;
    }


}
