import java.util.*;

public class main {
    public static void main(String[] args) {
        main main = new main();
        int[] ints=new int[]{4,2,5,7};
        ints=main.sortArrayByParityII(ints);
        for (int i = 0; i < ints.length; i++) {
            System.out.println(ints[i]);
        }

    }
    public int[] sortArrayByParityII(int[] A) {
        Deque<Integer> odd=new ArrayDeque<>();
        for(int i=0;i<A.length;i+=2){
            if((A[i]&1)!=0){
                odd.addFirst(A[i]);
            }
        }
        for(int i=1;i<A.length;i+=2){
            if((A[i]&1)==0){
                odd.addLast(A[i]);
                A[i]=odd.pollFirst();
            }
        }
        for(int i=0;i<A.length;i+=2){
            if((A[i]&1)!=0){
                A[i]=odd.pollFirst();
            }
        }
        return A;
    }

}





