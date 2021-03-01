import java.util.*;

public class main {

    public static void main(String[] args) {
        main main = new main();
        Node a0 = new Node(7);
        Node a1 = new Node(13);
        Node a2 = new Node(11);
        Node a3 = new Node(10);
        Node a4 = new Node(1);
        a0.next = a1;
        a0.random = null;
        a1.next = a2;
        a1.random = a0;
        a2.next = a3;
        a2.random = a4;
        a3.next = a4;
        a3.random = a2;
        a4.random = a0;

        Node res = main.copyRandomList(a0);
//        while (res != null) {
//            System.out.println(res.val);
//            if (res.random != null)
//                System.out.println(res.random.val);
//            else
//                System.out.println(-1);
//            res = res.next;
//        }

    }

    static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    public Node copyRandomList(Node head) {
        if (head == null)
            return null;
        Map<Integer, Node> headrandom_sourceindex = new HashMap<>();//原链表 索引--随机节点
        Map<Node,Integer> headnode_headindex=new HashMap<>();//原链表 节点--索引
        Map<Integer,Node> index_node=new HashMap<>();//深拷贝链表 节点--索引
        int index = 0;
        Node deep_copy = new Node(head.val);
        Node copy_pre = new Node(0);
        Node head_pre = new Node(0);
        copy_pre.next = deep_copy;
        head_pre.next = head;
        Node nullnode = new Node(-1);

        while (head.next != null) {
            headnode_headindex.put(head,index);
            index_node.put(index,deep_copy);
            if (head.random == null)
                headrandom_sourceindex.put(index++, nullnode);
            else
                headrandom_sourceindex.put(index++, head.random);
            head = head.next;
            Node cache = new Node(head.val);
            deep_copy.next = cache;
            deep_copy = deep_copy.next;

        }
        headnode_headindex.put(head,index);
        index_node.put(index,deep_copy);
        if (head.random == null)
            headrandom_sourceindex.put(index++, nullnode);
        else
            headrandom_sourceindex.put(index++, head.random);


        System.out.println(headrandom_sourceindex.size());
        System.out.println("headrandom_sourceindex");
        for (int it : headrandom_sourceindex.keySet()) {
            System.out.println(it + "  " + headrandom_sourceindex.get(it).val);
        }
        System.out.println("headnode_headindex");
        for (Node it : headnode_headindex.keySet()) {
            System.out.println(it.val + "  " + headnode_headindex.get(it));
        }
        System.out.println("index_node");
        for (int it : index_node.keySet()) {
            System.out.println(it + "  " + index_node.get(it).val);
        }


        Node deep_copy1 = copy_pre.next;
        index=0;
        while (deep_copy1!= null) {
            System.out.println("index:"+index);
            Node cache_node=headrandom_sourceindex.get(index++);
            if(cache_node.equals(nullnode))
                deep_copy1.random=null;
            else {
                int cache_index=headnode_headindex.get(cache_node);
                deep_copy1.random=index_node.get(cache_index);
            }
            deep_copy1 = deep_copy1.next;
        }
        return copy_pre.next;
    }

}





