
public class main {
    public static void main(String[] args) {
        main aa = new main();

        n_189 n_189=new n_189();
        int[] ints=new int[]{1,2,3,4,5};
        aa.rotate(ints,8);
        for(int it:ints)
            System.out.println(it);

    }
    public void rotate(int[] nums, int k) {
        int lst_i;
        if(nums.length<2)
            return;
        else
            lst_i=nums.length-1;
        k=k%nums.length;
        reverse(nums,0,lst_i);
        reverse(nums,0,k-1);
        reverse(nums,k,lst_i);

    }
    public int[] reverse(int[] nums,int begin,int end)
    {
        if(nums.length<2)
            return nums;
        else {
            int cache;
            while (begin<end)
            {
                cache=nums[begin];
                nums[begin++]=nums[end];
                nums[end--]=cache;
            }
            return nums;
        }
    }
}
