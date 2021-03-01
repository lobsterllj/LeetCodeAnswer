import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class Solution {
    public static void main(String[] args) {
        Solution aa=new Solution();

//        int a=0;
//        int b=a;
//        b++;
//        System.out.println(a==b);
//        System.out.println(b);
//
//        List<Integer> r1=new ArrayList<>();
//        r1.add(0);
//        List<Integer> r2=r1;
//        List<Integer> r3=new ArrayList<>(r1);
//        r2.add(1);
//
//
//        System.out.println(r1);
//        System.out.println(r2);
//        System.out.println(r3);

        String s="abcba";


        List<List<String>> split=new ArrayList<>();
        aa.dfs_sploUo(s,0,new ArrayList<String>() ,split);
        System.out.println("split:"+split);

//        boolean[][] res=aa.getmatrix(s);
//        for(int j=0;j<res.length;++j)
//        {
//            for(int i=0;i<=j;++i)
//            {
//                System.out.println("res["+i+"]["+j+"]:"+res[i][j]);
//            }
//            //System.out.println("----------------");
//        }


//        List<List<String>> re = aa.oUospl(res,s);
//        System.out.println(re);

//        for (List<String> li : re) {
//            System.out.println(li);
//            for(String strli : li)
//            {
//                System.out.println(strli);
//
//            }
//        }

    }

    //分割为全是回文的子串集合
    public void dfs_sploUo(String s, int index, ArrayList<String> cache, List<List<String>> split) {
        if (index == s.length()) {
            cache = new ArrayList<>(cache);
            split.add(cache);
            //split.add(new ArrayList<>(cache));
            System.out.println("return");
            return;
        }
        for (int i = index; i < s.length(); ++i) {
            System.out.println("i:"+(i+1));
            String ss = s.substring(index, i + 1);
            if (!isoUo(ss)) {
                System.out.println("no");
                continue;
            }
//            System.out.println(ss);
            cache.add(ss);
            //System.out.println("bef_dps:" + cache);
            dfs_sploUo(s, i + 1, cache, split);
            System.out.println("aft_dps:" + cache);
            cache.remove(cache.size() - 1);
        }
    }
    //判断字符串是否是回文字符串
    private boolean isoUo(String s)
    {
        boolean res=true;
        int i=0;
        int j=s.length()-1;
        while (i<j)
        {
            if(s.charAt(i)!=s.charAt(j))
            {
                res=false;
                break;
            }
            i++;
            j--;
        }

        return res;
    }




    //寻找所有回文子串
    private List<List<String>> oUospl(boolean[][] in,String s)
    {
        List<List<String>> result = new ArrayList<>();
        List<String> temple = null;

        for(int j=0;j<in.length;++j)
        {
            for(int i=0;i<=j;++i)
            {
                temple = new ArrayList<>();
                if(in[i][j])
                {
                    temple.add(s.substring(i,j+1));
                    result.add(temple);
                }
            }

        }

        return result;
    }
    //res[i][j]表示i至j为回文，其中i<=j有效
    private boolean[][] getmatrix(String s)
    {
        char[] s2char=s.toCharArray();
        boolean[][] res=new boolean[s2char.length][s2char.length];
        for (int i=0;i<s2char.length;++i)
        {
            res[i][i]=true;
        }
        for (int j=1;j<s2char.length;++j)
        {
            for (int i=0;i<j;++i)
            {
                if(s2char[i]==s2char[j]&&((j-i)<=2||res[i+1][j-1]))
                {
                    res[i][j]=true;
                }
            }
        }
        return res;
    }
}
