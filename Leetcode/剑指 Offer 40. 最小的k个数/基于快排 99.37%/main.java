import java.util.PriorityQueue;

public class main {

    public static void main(String[] args) {
        main main = new main();

        int[] ints = new int[]{0, 1, 1, 1, 4, 5, 3, 7, 7, 8, 10, 2, 7, 8, 0, 5, 2, 16, 12, 1, 19, 15, 5, 18, 2, 2, 22, 15, 8, 22, 17, 6, 22, 6, 22, 26, 32, 8, 10, 11, 2, 26, 9, 12, 9, 7, 28, 33, 20, 7, 2, 17, 44, 3, 52, 27, 2, 23, 19, 56, 56, 58, 36, 31, 1, 19, 19, 6, 65, 49, 27, 63, 29, 1, 69, 47, 56, 61, 40, 43, 10, 71, 60, 66, 42, 44, 10, 12, 83, 69, 73, 2, 65, 93, 92, 47, 35, 39, 13, 75};
        int[] ints1 = new int[]{0, 0, 2, 3, 2, 1, 1, 2, 0, 4};
        int[] res = main.getLeastNumbers(ints1, 10);
        for (int i = 0; i < res.length; ++i)
            System.out.print(res[i] + " ");
        System.out.println();

    }

    public int[] getLeastNumbers(int[] arr, int k) {
        if (k == 0)
            return new int[]{};
        int[] res = new int[k];
        quickpartion(arr, 0, arr.length - 1, k);
        int index = 0;
        while (index < k)
            res[index] = arr[index++];
        return res;
    }


    public int quickpartion(int[] arr, int sta, int end, int k) {
        if(sta>=end)
            return end;
        int pivot = arr[sta];
        int lessthanpivot = sta;
        //all in[sta+1,lt] <pivot
        //all in[lt+1,end] >=pivot
        for (int i = sta + 1; i <= end; ++i) {
            if (arr[i] < pivot) {
                lessthanpivot++;
                swap(arr, i, lessthanpivot);
            }
        }
        //all in[sta,lt-1] <pivot
        swap(arr, sta, lessthanpivot);
        if (lessthanpivot == k)
            return lessthanpivot;
        else if (lessthanpivot < k) {
            quickpartion(arr, lessthanpivot + 1, end, k);
        } else {
            quickpartion(arr, sta, lessthanpivot - 1, k);
        }
        return lessthanpivot;
    }

    public void swap(int[] arr, int i, int j) {
        int cache = arr[i];
        arr[i] = arr[j];
        arr[j] = cache;
    }
}

