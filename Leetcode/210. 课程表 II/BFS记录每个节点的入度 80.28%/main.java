import java.util.*;

public class main {

    public static void main(String[] args) {
        main main = new main();
        int[][] prerequisites = new int[][]{{1, 0}};
        int[] ints=main.findOrder(2, prerequisites);
        for(int it:ints){
            System.out.print(it+" ");
        }

    }

    public int[] findOrder(int numCourses, int[][] prerequisites) {
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

    public boolean canFinish(int numCourses, int[][] prerequisites) {
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
