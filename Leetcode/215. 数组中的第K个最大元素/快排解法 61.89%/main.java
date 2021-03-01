public class main {
    public static void main(String[] args) {
        main main = new main();
        prtMatrix prtMatrix = new prtMatrix();
        prtInts prtInts = new prtInts();

        int[] nums = new int[]{3, 2, 3, 1, 2, 4, 5, 5, 6};
        int k = 4;
        System.out.println(main.findKthLargest(nums, k));

    }


    public int findKthLargest(int[] nums, int k) {
        int first = 0;
        int last = nums.length - 1;
        int res;
        int kindex = nums.length - k;
        while (true) {
            res = partition3(nums, first, last);
            if (res == kindex) {
                return nums[res];
            } else if (res < kindex) {
                first = res + 1;
            } else {
                last = res - 1;
            }
        }
    }

    public int partition3(int[] nums, int first, int last) {
        if (first == last) {
            return first;
        }
        int lt = first;
        int gt = last + 1;
        int index = first + 1;
        int pivot = nums[first];
        //[first+1,lt] < pivot
        //[lt+1,index - 1] = pivot
        //[gt,last] > pivot
        while (index < gt) {
            int comp = nums[index];
            if (comp < pivot) {
                lt++;
                swap(nums, index, lt);
                index++;
            } else if (comp == pivot) {
                index++;
            } else {
                gt--;
                swap(nums, index, gt);
            }
        }
        swap(nums, first, lt);
        //[first,lt-1] < pivot
        //[lt,gt - 1] = pivot
        //[gt,last] > pivot
        return gt - 1;
    }

    public void swap(int[] nums, int n1, int n2) {
        int cache = nums[n1];
        nums[n1] = nums[n2];
        nums[n2] = cache;
    }


}
