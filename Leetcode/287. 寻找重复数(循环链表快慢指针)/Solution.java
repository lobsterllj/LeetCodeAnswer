public class Solution {
    public static void main(String[] args) {
        Solution aa=new Solution();
        int[] in={1,2,3,4,5,6,7,8,5};
        System.out.println(aa.findDuplicate(in));

    }

    public int findDuplicate(int[] nums) {
        int res = 0;
        int fast=0;
        int slow=0;
        while (true)
        {
            fast=nums[nums[fast]];
            slow=nums[slow];
            if(fast==slow)
            {
                fast=0;
                while (fast!=slow)
                {
                    fast=nums[fast];
                    slow=nums[slow];
                }
                res=fast;
                break;
            }
        }
        return  res;
    }


}
