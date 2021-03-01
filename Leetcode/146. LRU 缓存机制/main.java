import java.util.*;

public class main {
    public static void main(String[] args) {
        main main = new main();
        prtMatrix prtMatrix = new prtMatrix();
        LRUCache lRUCache = new LRUCache(2);
        lRUCache.put(1, 1); // 缓存是 {1=1}
        lRUCache.put(2, 2); // 缓存是 {1=1, 2=2}
        System.out.println(lRUCache.get(1));    // 返回 1
        lRUCache.put(3, 3); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
        System.out.println(lRUCache.get(2));    // 返回 -1 (未找到)
        lRUCache.put(4, 4); // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}
        System.out.println(lRUCache.get(1));    // 返回 -1 (未找到)
        System.out.println(lRUCache.get(3));    // 返回 3
        System.out.println(lRUCache.get(4));    // 返回 4

    }

    static class LRUCache {
        class doublyLinkedNode {
            int key;
            int val;
            doublyLinkedNode next;
            doublyLinkedNode pre;

            public doublyLinkedNode() {

            }

            public doublyLinkedNode(int key, int val) {
                this.key = key;
                this.val = val;
            }

        }

        Map<Integer, doublyLinkedNode> map;
        int capacity;
        int size;
        doublyLinkedNode head;
        doublyLinkedNode tail;

        public LRUCache(int capacity) {
            this.capacity = capacity;
            this.size = 0;
            map = new HashMap<>(capacity);
            head = new doublyLinkedNode();
            tail = new doublyLinkedNode();
            head.next = tail;
            tail.pre = head;

        }

        /**
         * 删除双向列表中的node
         *
         * @param node
         */
        public void delete(doublyLinkedNode node) {
            doublyLinkedNode precache = node.pre;
            doublyLinkedNode nextcache = node.next;

            node.pre = null;
            node.next = null;

            precache.next = nextcache;
            nextcache.pre = precache;

        }

        /**
         * 将node插入到尾节点tail之前
         *
         * @param node
         */
        public void insert(doublyLinkedNode node) {
            doublyLinkedNode tailpre = tail.pre;

            tailpre.next = node;
            node.pre = tailpre;

            node.next = tail;
            tail.pre = node;

        }

        /**
         * 将双向列表中的node更新至尾节点tail之前
         *
         * @param node
         */
        public void update(doublyLinkedNode node) {
            delete(node);
            insert(node);
        }

        public int get(int key) {
            if (!map.containsKey(key))
                return -1;
            else {
                update(map.get(key));
                return map.get(key).val;
            }
        }

        public void put(int key, int value) {
            if (!map.containsKey(key)) {
                if (size < capacity) {
                    size++;

                } else {
                    doublyLinkedNode headNext = head.next;
                    map.remove(headNext.key);
                    delete(headNext);

                }
                doublyLinkedNode cur = new doublyLinkedNode(key, value);
                map.put(key, cur);
                insert(cur);

            } else {
                doublyLinkedNode cur = map.get(key);
                cur.val = value;
                update(cur);
            }
        }
    }

}

