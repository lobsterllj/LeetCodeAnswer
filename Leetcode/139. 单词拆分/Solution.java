import java.util.LinkedList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        Solution aa=new Solution();

        String in="catsand";
        List<String> test=new LinkedList<String>();
        test.add("cats");
        test.add("cat");
        test.add("sand");

        System.out.println(aa.compare(in,test));

    }

    public boolean compare(String s, List<String> wordDict)
    {
        boolean[] res=new boolean[s.length()+1];
        res[0]=true;

        for(int i=1;i<s.length()+1;++i)
        {
            for(int j=0;j<i;++j)
            {
                if(res[j]&&wordDict.contains(s.substring(j,i)))
                {
                    res[i]=true;
                    //break;
                }
            }
        }
        return res[s.length()];
    }





}
