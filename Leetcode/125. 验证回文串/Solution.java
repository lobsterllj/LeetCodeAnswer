public class Solution {
    public static void main(String[] args) {
        Solution aa=new Solution();
        String bb="adddffggffddda.'/'/";
        String cc=aa.upper2low(bb);
        System.out.println(cc);
        System.out.println(aa.isoUo(cc));
    }

    public String upper2low(String aa)
    {
        StringBuffer res_buffer=new StringBuffer();
        for(int i=0;i<aa.length();++i)
        {
            char sel=aa.charAt(i);
            if(Character.isUpperCase(sel))
            {
                res_buffer.append(Character.toLowerCase(sel));
            }
            else if(Character.isLowerCase(sel)||Character.isDigit(sel))
            {
                res_buffer.append(sel);
            }
        }

        String res=res_buffer.toString();
        return res;
    }
    public boolean isoUo(String aa)
    {
        boolean res=false;
        if(aa.length()==0)
        {
            res=true;
        }
        else {
            int i = 0;
            int j = aa.length() - 1;

            while (i<=j)
            {
                char sel_1=aa.charAt(i);
                char sel_2=aa.charAt(j);
                if(sel_1==sel_2)
                {
                    i++;
                    j--;
                    res=true;
                }
                else
                {
                    res=false;
                    break;
                }
            }
        }
        return res;
    }
}
