import java.util.*;

public class main {

    public static void main(String[] args) {
        main main = new main();
        List<List<String>> equations = new ArrayList<>();
        List<String> cache = new ArrayList<>();
        cache.add("a");
        cache.add("b");
        equations.add(cache);

        List<String> cache1 = new ArrayList<>();
        cache1.add("b");
        cache1.add("c");
        equations.add(cache1);

        List<String> cache2 = new ArrayList<>();
        cache2.add("bc");
        cache2.add("cd");
        equations.add(cache2);

        double[] values = {1.5d, 2.5d, 5.0d};

        List<List<String>> queries = new ArrayList<>();
        List<String> ache = new ArrayList<>();
        ache.add("a");
        ache.add("c");
        queries.add(ache);

        List<String> ache1 = new ArrayList<>();
        ache1.add("c");
        ache1.add("b");
        queries.add(ache1);

        List<String> ache2 = new ArrayList<>();
        ache2.add("bc");
        ache2.add("cd");
        queries.add(ache2);

        List<String> ache3 = new ArrayList<>();
        ache3.add("cd");
        ache3.add("bc");
        queries.add(ache3);

        double[] res = main.calcEquation(equations, values, queries);
        for (int i = 0; i < res.length; ++i) {
            System.out.println(res[i]);
        }
    }

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        int count = 0;
        //统计出现的所有字符，并赋予对应的index
        Map<String, Integer> map = new HashMap<>();
        for (List<String> list : equations) {
            for (String s : list) {
                if (!map.containsKey(s)) {
                    map.put(s, count++);
                }
            }
        }

        //构建一个矩阵来代替图结构
        double[][] graph = new double[count + 1][count + 1];

        //初始化
        for (String s : map.keySet()) {
            int x = map.get(s);
            graph[x][x] = 1.0;
        }
        int index = 0;
        for (List<String> list : equations) {
            String a = list.get(0);
            String b = list.get(1);
            int aa = map.get(a);
            int bb = map.get(b);
            double value = values[index++];
            graph[aa][bb] = value;
            graph[bb][aa] = 1 / value;
        }

        //Floyd法  o(n3)
        for (int transit = 0; transit < count; ++transit) {
            for (int i = 0; i < count; ++i) {
                for (int j = 0; j < count; ++j) {
                    if (i == j || graph[i][j] != 0)
                        continue;
                    if (graph[i][transit] != 0 && graph[transit][j] != 0) {
                        graph[i][j] = graph[i][transit] * graph[transit][j];
                    }

                }
            }
        }
        prtgraph(graph);
        //直接查询矩阵得到答案
        double[] res = new double[queries.size()];
        for (int i = 0; i < res.length; ++i) {
            String p1 = queries.get(i).get(0);
            String p2 = queries.get(i).get(1);
            if (map.containsKey(p1) && map.containsKey(p2)) {
                if (graph[map.get(p1)][map.get(p2)] != 0)
                    res[i] = graph[map.get(p1)][map.get(p2)];
                else
                    res[i] = -1d;
            } else {
                res[i] = -1d;
            }
        }

        return res;
    }

    public void prtgraph(double[][] graph) {
        System.out.println("graph:");
        for (int i = 0; i < graph.length; ++i) {
            for (int j = 0; j < graph[i].length; ++j) {
                System.out.print(graph[i][j] + "              /              ");
            }
            System.out.println();
        }
        System.out.println();
    }
}

