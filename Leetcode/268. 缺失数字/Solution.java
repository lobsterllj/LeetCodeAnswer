public class Solution {
    public static void main(String[] args) {

        Solution aa=new Solution();
        int[] in={0,1,2,3,5};
        System.out.println(aa.lostnum(in));

    }

    public int lostnum(int[] in)
    {
        int res=in.length;
        for (int i=0;i<in.length;++i)
        {
            res^=in[i];
            res^=i;
        }


        return res;
    }


}
