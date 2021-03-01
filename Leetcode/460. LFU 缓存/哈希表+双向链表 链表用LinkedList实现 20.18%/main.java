import java.util.*;

public class main {
    public static void main(String[] args) {
        main main = new main();
        prtMatrix prtMatrix = new prtMatrix();
        prtInts prtInts = new prtInts();

        main.textLFU();

    }

    public void textLFU() {
        LFUCache lFUCache = new LFUCache(2);
        lFUCache.put(1, 1);   // cache=[1,_], cnt(1)=1
        lFUCache.put(2, 2);   // cache=[2,1], cnt(2)=1, cnt(1)=1
        System.out.println(lFUCache.get(1));      // 返回 1
        // cache=[1,2], cnt(2)=1, cnt(1)=2
        lFUCache.put(3, 3);   // 去除键 2 ，因为 cnt(2)=1 ，使用计数最小
        // cache=[3,1], cnt(3)=1, cnt(1)=2
        System.out.println(lFUCache.get(2));      // 返回 -1（未找到）
        System.out.println(lFUCache.get(3));      // 返回 3
        // cache=[3,1], cnt(3)=2, cnt(1)=2
        lFUCache.put(4, 4);   // 去除键 1 ，1 和 3 的 cnt 相同，但 1 最久未使用
        // cache=[4,3], cnt(4)=1, cnt(3)=2
        System.out.println(lFUCache.get(1));      // 返回 -1（未找到）
        System.out.println(lFUCache.get(3));      // 返回 3
        // cache=[3,4], cnt(4)=1, cnt(3)=3
        System.out.println(lFUCache.get(4));      // 返回 4
        // cache=[3,4], cnt(4)=2, cnt(3)=3
    }

    class LFUCache {
        //使用频次最小元素的使用频次
        int minfreq;

        //LFUCache容量大小
        int capacity;

        //key_Node 哈希表
        Map<Integer, Node> key_table;

        //freq_doublelinkedlist
        Map<Integer, LinkedList<Node>> freq_list;

        public LFUCache(int capacity) {
            this.capacity = capacity;
            minfreq = 0;
            key_table = new HashMap<>();
            freq_list = new HashMap<>();
        }

        public int get(int key) {
            if (capacity == 0)
                return -1;
            if (!key_table.containsKey(key)) {
                return -1;
            }
            //更新key_table与freq_list
            Node node = key_table.get(key);
            int val = node.val;
            int freq = node.freq;
            freq_list.get(freq).remove(node);

            //如果当前freq对应的freq_list内的链表为空，需要删除此链表
            if (freq_list.get(freq).size() == 0) {
                freq_list.remove(freq);
                //如果此freq为minfreq 当前被查找的元素的freq一定为minfreq 故将minfreq更新为freq + 1 即minfreq + 1
                if (minfreq == freq) {
                    minfreq++;
                }
            }

            //更新节点
            LinkedList<Node> cache = freq_list.getOrDefault(freq + 1, new LinkedList<Node>());
            cache.addFirst(new Node(key, val, freq + 1));
            freq_list.put(freq + 1, cache);
            key_table.put(key, freq_list.get(freq + 1).peekFirst());

            return val;
        }

        public void put(int key, int value) {
            if (capacity == 0) {
                return;
            }
            if (!key_table.containsKey(key)) {
                //如果原表内不含有该元素，故需要添加新元素，可能会导致超出容量范围
                if (key_table.size() == capacity) {
                    Node undeleted = freq_list.get(minfreq).pollLast();
                    key_table.remove(undeleted.key);
                    //如果当前minfreq对应的freq_list内的链表为空，需要删除此链表
                    if (freq_list.get(minfreq).size() == 0) {
                        freq_list.remove(minfreq);
                    }
                }

                //插入节点
                Node node = new Node(key, value, 1);
                LinkedList<Node> list = freq_list.getOrDefault(1, new LinkedList<Node>());
                list.addFirst(node);
                freq_list.put(1, list);
                key_table.put(key, freq_list.get(1).peekFirst());

                minfreq = 1;
            } else {
                //如果原表内已经含有该元素，故没有添加新元素，不会导致超出容量范围
                Node node = key_table.get(key);
                int freq = node.freq;
                freq_list.get(freq).remove(node);

                //如果当前freq对应的freq_list内的链表为空，需要删除此链表
                if (freq_list.get(freq).size() == 0) {
                    freq_list.remove(freq);
                    //如果此freq为minfreq 当前被查找的元素的freq一定为minfreq 故将minfreq更新为freq + 1 即minfreq + 1
                    if (minfreq == freq) {
                        minfreq++;
                    }
                }

                //更新节点
                LinkedList<Node> cache = freq_list.getOrDefault(freq + 1, new LinkedList<Node>());
                cache.addFirst(new Node(key, value, freq + 1));
                freq_list.put(freq + 1, cache);
                key_table.put(key, freq_list.get(freq + 1).peekFirst());

            }
        }
    }

    class Node {
        int key, val, freq;

        Node(int key, int val, int freq) {
            this.key = key;
            this.val = val;
            this.freq = freq;
        }
    }


    class edge {
        public int x;
        public int y;
        public int dis;

        public edge(int x, int y, int dis) {
            this.x = x;
            this.y = y;
            this.dis = dis;
        }

        public int getDis() {
            return dis;
        }
    }


    private class unionFind {
        int[] fathers;
        int[] size;
        int groupNum;

        public unionFind(int n) {
            fathers = new int[n];
            size = new int[n];
            groupNum = n;
            for (int i = 0; i < n; ++i) {
                fathers[i] = i;
                size[i] = 1;
            }
        }

        public int find(int x) {
            if (x != fathers[x]) {
                fathers[x] = find(fathers[x]);
            }
            return fathers[x];
        }

        public void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX == rootY)
                return;
            if (size[rootX] < size[rootY]) {
                fathers[rootX] = rootY;
                size[rootY] += size[rootX];
            } else {
                fathers[rootY] = rootX;
                size[rootX] += size[rootY];
            }
            groupNum--;
            return;
        }

        public boolean isConnected(int x, int y) {
            return find(x) == find(y);
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
}
