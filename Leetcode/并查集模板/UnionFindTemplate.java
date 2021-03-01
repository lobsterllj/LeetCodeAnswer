import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class UnionFindTemplate {
    class UnionFind {
        int[] fathers;
        int[] size;
        int groupNum;
        int capacity;

        public UnionFind(int n) {
            groupNum = n;
            capacity = n;
            fathers = new int[n];
            size = new int[n];
            for (int i = 0; i < n; ++i) {
                fathers[i] = i;
                size[i] = 1;
            }
        }

        public int find(int x) {
            if (x != fathers[x])
                fathers[x] = find(fathers[x]);
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
        }

        public boolean isConnected(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            return rootX == rootY;
        }

        public Map<Integer, Set<Integer>> getGroup() {
            Map<Integer, Set<Integer>> group = new HashMap<>();
            for (int i = 0; i < capacity; ++i) {
                int fatherI = find(i);
                Set root = group.getOrDefault(fatherI, new HashSet<Integer>());
                root.add(i);
                group.put(fatherI, root);
            }
            return group;
        }

    }
}
