import java.util.*;

public class main {

    public static void main(String[] args) {
        main main = new main();
        int[][] prerequisites=new int[][]{{1,0},{1,2},{0,1}};
        System.out.println(main.canFinish(3, prerequisites));

    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (numCourses == 1)
            return true;
        Map<Integer, List<Integer>> linked = new HashMap<>();
        Map<Integer, List<Integer>> father = new HashMap<>();
        boolean[] hasPre = new boolean[numCourses];
        for (int i = 0; i < prerequisites.length; ++i) {
            List<Integer> cache = linked.getOrDefault(prerequisites[i][1], new LinkedList<>());
            cache.add(prerequisites[i][0]);
            hasPre[prerequisites[i][0]] = true;
            linked.put(prerequisites[i][1], cache);
        }
        boolean[] visited = new boolean[numCourses];
        Deque<Integer> unsearched = new ArrayDeque<>();
        for (int i = 0; i < hasPre.length; ++i) {
            if (!hasPre[i]) {
                unsearched.addLast(i);
                visited[i] = true;
            }
        }
        System.out.println("unsearched:"+unsearched);
        while (!unsearched.isEmpty()) {
            System.out.println("unsearched:"+unsearched);
            int temp = unsearched.pollFirst();
            visited[temp] = true;
            List<Integer> cache = father.getOrDefault(temp, new LinkedList<>());
            List<Integer> cachecopy=new LinkedList<>(cache);
            cachecopy.add(temp);

            List<Integer> buffer = linked.get(temp);
            if (buffer != null && buffer.size() != 0) {
                for (int it : buffer) {
                    System.out.println("father:"+father);
                    father.put(it, cachecopy);
                    System.out.println("father:"+father);

                    if (cache.contains(it)) {
                        System.out.println("cache:"+cache);
                        //cache 当前节点的父节点们
                        System.out.println("it:"+it);
                        //当前节点的子节点出现在了cache内
                        return false;
                    }
                    if (!visited[it]) {
                        unsearched.addLast(it);
                        System.out.println("it:"+it);
                    }
                }
            }
        }

        for (int i = 0; i < visited.length; ++i) {
            if (!visited[i])
                return false;
        }
        return true;
    }


}
