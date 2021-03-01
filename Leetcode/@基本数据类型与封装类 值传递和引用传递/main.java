import java.util.*;
import java.util.stream.Stream;

public class main {

    public static void main(String[] args) {
        main main = new main();
        MyInterface mi = (a, b) -> (int) (b - a);
        foo((a, b) -> (int) (b - a));
        int[] nums = new int[10];
        for (int i = 0; i < 10; ++i) nums[i] = i + 1;
        Arrays.stream(nums).filter(a -> a % 2 == 1).filter(a -> a > 5).forEach(a -> System.out.println(a));
        List<Integer> list = new LinkedList<>();
        int a = 1;
        list.add(a);
        int b = list.get(0);

        String s1 = "abc";
        String s2 = "abc";

        Integer i1 = 1;
        Integer i2 = 1;
        Integer i3 = 666;
        Integer i4 = 666;

        i3 += i4;

        //Integer i5 = i3 + i4;

        int ii5 = i3.intValue() + i4.intValue();
        Integer i5 = new Integer(ii5);
        i3 = i5;

        System.out.println(i1 == i2);       //guess: false
        System.out.println(i3 == i4);       //guess: false
        System.out.println(i1.equals(i2));  //guess: true
        System.out.println(i3.equals(i4));  //guess: true

        mai();
    }

    public static void foo(MyInterface a){

    }

    static void mai(){

        int[] arr = new int[3];
        edit(arr, 2, 1);
        System.out.println(arr[2]);
    }

    static void edit(int[] arr, int pos, int a){
        arr[pos] = a;
    }

    int cal(int x, int y){
        x += 100;
        y += 100;
        return x + y;
    }



//    public int[] sortArray(Integer[] nums) {
////        Arrays.sort(nums, (a, b) -> b -a);
//        class ComImpl implements Comparator<Integer>{
//            @Override
//            public int compare(Integer o1, Integer o2){
//                return o2 - o1;
//            }
//        }
//        Arrays.sort(nums, new ComImpl());
//
//        int[] a=new int[5];
//        Arrays.sort(a,new Comparator<>());
//
//
//        return null;
//    }
}
