import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class main {

    public static void main(String[] args) {
        main main = new main();
        int[] gas = new int[]{1,2,3,4,5};
        int[] cost = new int[]{3,4,5,1,2};
        System.out.println(main.canCompleteCircuit(gas, cost));
    }
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int i=0;
        while(i < gas.length) {
            //遍历每一个起点
            int gasR=gas[i]-cost[i];
            if(gasR>=0){
                int k=i;
                while (gasR>=0){
                    k=(k+1)%gas.length;
                    if(k==i)
                        return k;
                    gasR+=gas[k]-cost[k];
                }
                if(k<i)
                    return -1;
                i=k;


            }
            i++;
        }
        return -1;
    }
    public int canCompleteCircuit1(int[] gas, int[] cost) {
        for (int i = 0; i < gas.length; ++i) {
            //遍历每一个起点
            if (gas[i] >= cost[i]) {
                int fund = gas[i] - cost[i];
                int k = i;
                while (fund >= 0) {
                    if (k == gas.length-1) {
                        k = 0;
                    } else {
                        k++;
                    }
                    fund += gas[k] - cost[k];
                    if (k == i) {
                        return k;
                    }
                }
            }
        }
        return -1;
    }

}





