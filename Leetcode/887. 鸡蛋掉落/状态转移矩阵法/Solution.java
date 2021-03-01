import javax.sound.midi.Soundbank;

public class Solution {
    public static void main(String[] args) {
        Solution aa=new Solution();
        for (int i=1;i<7;++i)
        {
//            for (int j=1;j<11;++j)
//            {
                //System.out.println("i:"+i+" j:"+11+" e:"+aa.superEggDro(i,11));
//            }
        }
        System.out.println("final:"+aa.superEggDro(2,100));
    }
    public int superEggDro(int K, int N) {
        int res=0;
        int[] dp=new int[K+1];

        for(int j=0;j<K+1;++j)
        {
            System.out.println("dp["+j+"]:"+dp[j]);
        }
        System.out.println("---------------------");


        while(dp[K]<N)
        {
            for(int i=K;i>0;--i)
            {

                dp[i]=dp[i]+dp[i-1]+1;
                System.out.println("dp["+i+"]:"+dp[i]);

            }
            res++;
        }
        return res;
    }

}
