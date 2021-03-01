import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class main {
    public static void main(String[] args) {
        main main = new main();
        int[][] ints = new int[][]{{7, 0}, {4, 4}, {7, 1}, {5, 0}, {6, 1}, {5, 2}};
        ints = main.reconstructQueue(ints);
        for (int i = 0; i < ints.length; ++i) {

            System.out.println("ints[" + i + "]" + ints[i][0] + "|" + ints[i][1]);

        }
        System.out.println();
    }

    public int[][] reconstructQueue(int[][] people) {
        if (people.length == 0)
            return people;
        List<int[]> res = new LinkedList<>();
        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] != o2[0]) {
                    return o2[0] - o1[0];
                } else {
                    return o1[1] - o2[1];

                }
            }
        });

//        for (int i = 0; i < people.length; ++i) {
//            //System.out.println(people[i][1]+"  "+res.size());
//            if (people[i][1] >= res.size())
//                res.add(people[i]);
//            else {
//                //System.out.println("people[" + i + "][" + 0 + "]:" + people[i][0]);
//                res.add(people[i][1], people[i]);
//            }
//
//        }
        for (int i = 0; i < people.length; ++i) {
            //System.out.println(people[i][1]+"  "+res.size());

                res.add(people[i][1], people[i]);


        }
        return res.toArray(new int[people.length][2]);
//        int[][] res_int = new int[people.length][2];
//        for (int i = 0; i < res_int.length; ++i) {
//            res_int[i] = res.get(i);
//        }
//        return res_int;


    }
}





