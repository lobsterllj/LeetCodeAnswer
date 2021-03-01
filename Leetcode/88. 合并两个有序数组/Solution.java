public class Solution {
    public static void main(String[] args) {
        Solution aa=new Solution();
        int[] in1={1,2,3,0,0,0};
        int[] in2={2,3,4};
        aa.merg(in1,3,in2,3);
        for(int i=0;i<in1.length;++i)
        {
            System.out.println(in1[i]);

        }

    }
    public void merg(int[] nums1, int m, int[] nums2, int n) {
        int k1=m-1;
        int k2=n-1;
        for(int i=m+n-1;i>-1;--i)
        {
            if((k2>-1)&&(k1==-1||nums1[k1]<nums2[k2]))
            {
                nums1[i]=nums2[k2];
                k2--;
            }
            else
            {
                nums1[i]=nums1[k1];
                k1--;
            }
        }

    }

}
