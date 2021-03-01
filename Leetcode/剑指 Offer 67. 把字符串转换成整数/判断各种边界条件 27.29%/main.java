import java.util.*;

public class main {

    public static void main(String[] args) {
        main main = new main();
        String str="42";
        System.out.println(main.strToInt(str));
    }

    public int strToInt(String str) {
        if (str.length() == 0)
            return 0;
        char[] chars = str.toCharArray();
        List<Character> valid=new ArrayList<>(chars.length);
        int index=0;
        while (index<chars.length&&chars[index]==' '){
            index++;
        }
        if(index==chars.length||!((chars[index]>='0'&&chars[index]<='9')||chars[index]=='+'||chars[index]=='-'))
            return 0;
        if(chars[index]=='+'||chars[index]=='-'){
            valid.add(chars[index]);
            index++;
        }
        for(int i=index;i<chars.length;++i){
            if((chars[i]>='0'&&chars[i]<='9'))
                valid.add(chars[i]);
            else
                break;;
        }

        if(valid.size()==0)
            return 0;
        long res=0;
        long max=2147483647;
        long min=max+1;
        if(valid.get(0)=='-'){
            for(int i=1;i<valid.size();++i){
                if(valid.get(i)>='0'&&valid.get(i)<='9'){
                    res=res*10+(valid.get(i)-'0');
                }
                if(res>min)
                    return Integer.MIN_VALUE;
            }
            return -(int)res;
        }else if(valid.get(0)=='+'){
            for(int i=1;i<valid.size();++i){
                if(valid.get(i)>='0'&&valid.get(i)<='9'){
                    res=res*10+(valid.get(i)-'0');
                }
                if(res>max)
                    return Integer.MAX_VALUE;
            }
            return (int)res;
        }else {
            for(int i=0;i<valid.size();++i){
                if(valid.get(i)>='0'&&valid.get(i)<='9'){
                    res=res*10+(valid.get(i)-'0');
                }
                if(res>max)
                    return Integer.MAX_VALUE;
            }
            return (int)res;
        }

    }


}

