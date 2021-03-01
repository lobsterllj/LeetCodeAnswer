public class Solution {
    public static void main(String[] args) {


        Solution aa=new Solution();
        int[] in={1,2,2,2,2,3,3,1};
        System.out.println(aa.major(in));

    }

    public int major(int[] nums)
    {
        int res=nums[0];
        int num_res=1;
        for (int i=1;i<nums.length;++i)
        {
            if(nums[i]==res)
            {
                num_res++;
            }
            else
            {
                num_res--;
            }
            if(num_res==0)
            {
                res=nums[i];
                num_res=1;
            }
        }


        return res;
    }

}
