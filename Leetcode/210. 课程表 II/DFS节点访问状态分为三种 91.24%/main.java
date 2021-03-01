import java.util.*;

public class main {

    public static void main(String[] args) {
        main main = new main();
        int[][] prerequisites = new int[][]{{1, 0}};
//        System.out.println(main.canFinish(2, prerequisites));

        int[] ints = main.findOrder(2, prerequisites);
        for (int it : ints) {
            System.out.print(it + " ");
        }

    }

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        if (numCourses == 1)
            return new int[]{0};
        ArrayList<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < numCourses; ++i)
            adj.add(new ArrayList<>());
        for (int[] it : prerequisites) {
            adj.get(it[1]).add(it[0]);
        }
        int[] vst = new int[numCourses];

        Deque<Integer> res = new ArrayDeque<>();
        int[] way = new int[numCourses];
        int index = 0;
        for (int i = 0; i < numCourses; ++i) {
            if (!dfs1(i, adj, vst, res))
                return new int[]{};
        }
        while (!res.isEmpty()) {
            way[index++]=res.pollFirst();
        }
        return way;
    }

    public boolean dfs1(int node, ArrayList<List<Integer>> adj, int[] vst, Deque<Integer> res) {
        if (vst[node] == 1)
            return false;
        else if (vst[node] == -1)
            return true;
        vst[node] = 1;
        for (Integer it : adj.get(node)) {
            if (!dfs1(it, adj, vst, res))
                return false;
        }
        res.addFirst(node);
        vst[node] = -1;
        return true;
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (numCourses == 1)
            return true;
        ArrayList<List<Integer>> Adjacency = new ArrayList<>();
        for (int i = 0; i < numCourses; ++i) {
            Adjacency.add(new ArrayList<Integer>());
        }
        for (int[] it : prerequisites) {
            Adjacency.get(it[1]).add(it[0]);
        }
        int[] visitedState = new int[numCourses];
        for (int i = 0; i < numCourses; ++i) {
            if (!dfs(i, Adjacency, visitedState))
                return false;
        }
        return true;
    }

    public boolean dfs(int node, ArrayList<List<Integer>> adj, int[] vst) {
        if (vst[node] == 1)
            return false;
        else if (vst[node] == -1)
            return true;
        vst[node] = 1;
        List<Integer> cache = adj.get(node);
        for (Integer it : cache) {
            if (!dfs(it, adj, vst))
                return false;
        }
        vst[node] = -1;
        return true;
    }


    public int[] findOrder1(int numCourses, int[][] prerequisites) {
        if (numCourses == 1)
            return new int[]{0};
        ArrayList<List<Integer>> Adjacency = new ArrayList<>();
        for (int i = 0; i < numCourses; ++i) {
            Adjacency.add(new ArrayList<Integer>());
        }
        int[] in_degree = new int[numCourses];
        for (int[] it : prerequisites) {
            Adjacency.get(it[1]).add(it[0]);
            in_degree[it[0]]++;
        }

        Queue<Integer> Unsearched = new ArrayDeque<>();
        for (int i = 0; i < in_degree.length; ++i) {
            if (in_degree[i] == 0) {
                Unsearched.offer(i);
            }
        }
        int[] res = new int[numCourses];
        int index = 0;
        while (!Unsearched.isEmpty()) {
            int temp = Unsearched.poll();
            res[index++] = temp;
            List<Integer> buffer = Adjacency.get(temp);

            if (buffer != null && buffer.size() != 0) {
                for (int it : buffer) {
                    in_degree[it]--;
                    if (in_degree[it] == 0) {
                        Unsearched.offer(it);
                    }
                }
            }
        }
        if (index == numCourses)
            return res;
        return new int[]{};
    }

    public boolean canFinish1(int numCourses, int[][] prerequisites) {
        if (numCourses == 1)
            return true;

        ArrayList<List<Integer>> Adjacency = new ArrayList<>();
        for (int i = 0; i < numCourses; ++i) {
            Adjacency.add(new ArrayList<Integer>());
        }
        int[] in_degree = new int[numCourses];
        for (int[] it : prerequisites) {
            Adjacency.get(it[1]).add(it[0]);
            in_degree[it[0]]++;
        }

        Deque<Integer> unsearched = new ArrayDeque<>();
        for (int i = 0; i < in_degree.length; ++i) {
            if (in_degree[i] == 0) {
                unsearched.addLast(i);
            }
        }
        int cntVisited = 0;
        while (!unsearched.isEmpty()) {
            int temp = unsearched.pollFirst();
            cntVisited++;
            List<Integer> buffer = Adjacency.get(temp);

            if (buffer != null && buffer.size() != 0) {
                for (int it : buffer) {
                    in_degree[it]--;
                    if (in_degree[it] == 0) {
                        unsearched.addLast(it);
                    }
                }
            }
        }
        return cntVisited == numCourses;
    }


}
