public class Solution {
    public static void main(String[] args) {
        String a="dasds";
        String b="ssadd";

        Solution aa=new Solution();
        System.out.println(aa.isAnagraM(a,b));

    }
    public boolean isAnagraM(String a,String b)
    {
        if(a.length()!=b.length())
        {
            return false;
        }
        else
        {
            int[] a_int=new int[26];
            int[] b_int=new int[26];
            for(char c:a.toCharArray())
            {
                a_int[c-'a']++;
            }
            for(char c:b.toCharArray())
            {
                b_int[c-'a']++;
            }
            for (int i=0;i<26;++i)
            {
                if(a_int[i]!=b_int[i])
                {
                    return false;
                }
            }
            return true;
        }
    }
}
