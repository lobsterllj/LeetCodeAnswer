import java.util.*;

public class main {
    public static void main(String[] args) {
        main main = new main();
        //System.out.println(main.calculate("1+2*5/3+6/4*2"));
        String[] strings=new String[]{"2","1","+","3","*"};
        System.out.println(main.evalRPN(strings));
        //System.out.println(main.calculate("1+2-3"));
        //System.out.println(main.calculate("1+2+3+4+5"));
    }
    public int evalRPN(String[] tokens) {
        Deque<Integer> unPocess=new ArrayDeque();
        int num1=0,num2=0;
        for(int i=0;i<tokens.length;++i){
            if(tokens[i].equals("+")){
                num2=unPocess.pollFirst();
                num1=unPocess.pollFirst();
                num1=num1+num2;
                unPocess.addFirst(num1);
            }
            else if(tokens[i].equals("-")){
                num2=unPocess.pollFirst();
                num1=unPocess.pollFirst();
                num1=num1-num2;
                unPocess.addFirst(num1);
            }
            else if(tokens[i].equals("*")){
                num2=unPocess.pollFirst();
                num1=unPocess.pollFirst();
                num1=num1*num2;
                unPocess.addFirst(num1);
            }
            else if(tokens[i].equals("/")){
                num2=unPocess.pollFirst();
                num1=unPocess.pollFirst();
                num1=num1/num2;
                unPocess.addFirst(num1);
            }
            else
            {
                unPocess.addFirst(Integer.parseInt(tokens[i]));
            }
        }
        return unPocess.peekFirst();
    }



    public int calculate(String s) {
        Deque<Integer> nums = new ArrayDeque<Integer>();
        Deque<Character> oprs = new ArrayDeque<Character>();
        Deque mix = new ArrayDeque();
        Deque mix_after = new ArrayDeque();
        Deque mix_after_after = new ArrayDeque();
        Object[] mid;

        //读取操作数与操作符，得出中缀表达式(栈形式)
        char cache;
        int i = 0;
        while (i < s.length()) {
            cache = s.charAt(i);
            if (cache > 47 && cache < 58) {
                nums.addLast(string2int(s, i)[0]);
                i = string2int(s, i)[1];
            }
            if (cache == '+' || cache == '-' || cache == '*' || cache == '/') {
                oprs.addLast(cache);
            }
            i++;

        }
        System.out.println("nums:" + nums);
        System.out.println("oprs:" + oprs);
        while (!oprs.isEmpty()) {
            mix.addLast(nums.pollFirst());
            mix.addLast(oprs.pollFirst());
        }
        mix.addLast(nums.pollFirst());
        System.out.println("mix:" + mix);

        //得出中缀表达式(数组形式)
        mid = new Object[mix.size()];
        int index=0;
        while (index< mid.length){
            mid[index++]=mix.pollFirst();
        }
//        for(int j=0;j< mid.length;++j){
//            System.out.println("mid"+j+":"+mid[j]);
//        }
        System.out.println("mix_after:" + mix_after);
        //从左至右计算所有‘*’与‘/’
        for(int k=0;k< mid.length;++k){
            if(isOpr(mid[k])){
                if((Character)mid[k]=='*'){
                    int it=(int) mix_after.pollLast();
                    it=it*(int)mid[k+1];
                    mix_after.addLast(it);
                    k++;
                }
                else if((Character)mid[k]=='/'){
                    int it=(int) mix_after.pollLast();
                    it=it/(int)mid[k+1];
                    mix_after.addLast(it);
                    k++;
                }
                else{
                    mix_after.addLast(mid[k]);
                }
            }
            else{
                mix_after.addLast(mid[k]);
            }
        }
        System.out.println("mix_after:" + mix_after);

        //计算所有‘+’、‘-’
        Object[] after=new Object[mix_after.size()];
        int index_after=0;
        while(!mix_after.isEmpty()){
            after[index_after++]=mix_after.pollFirst();
        }
        long res=0;
        for(int m=0;m<after.length;++m){
            if(after[m].equals('+')){
                int it=(int) mix_after_after.pollLast();
                it=it+(int)after[m+1];
                mix_after_after.addLast(it);
                m++;
            }
            else if(after[m].equals('-')){
                int it=(int) mix_after_after.pollLast();
                it=it-(int)after[m+1];
                mix_after_after.addLast(it);
                m++;
            }
            else{
                mix_after_after.addLast(after[m]);
            }
        }
        return (int)mix_after_after.peekFirst();
        //由中缀表达式到后缀表达式
        //题目没有括号输入，导致先*后/ 与先/后*很难统一
//        while (!mix.isEmpty()) {
//            Object temp = mix.pollFirst();
//
//            if (temp.equals('+') || temp.equals('-') || temp.equals('*') || temp.equals('/')) {
//                if(oprs.isEmpty())
//                    oprs.addFirst((Character) temp);
//                //'+'、'-'遇到了堆顶的'+'、'-'
//                else if ((getPriority(temp) == 1) && (getPriority(oprs.peekFirst()) == 1)) {
//                    //压入oprs
//                    oprs.addFirst((Character) temp);
//                }
//                //'+'、'-'遇到了堆顶的‘*’、‘/’
//                else if ((getPriority(temp) == 1) && (getPriority(oprs.peekFirst()) == 2)) {
//                    tokens[index_token++] = temp;
//                    char opr = oprs.pollFirst();
//                }
//                //‘*’、‘/’遇到了堆顶的‘+’、‘-’
//                else if ((getPriority(temp) == 2) && (getPriority(oprs.peekFirst()) == 1)) {
//                    //压入oprs
//                    oprs.addFirst((Character) temp);
//                }
//                //‘*’、‘/’遇到了堆顶的‘*’、‘/’
//                else if ((getPriority(temp) == 2) && (getPriority(oprs.peekFirst()) == 2)) {
//
//                }
//
//            } else {
//                tokens[index_token++] = temp;
//            }
//
//        }
//        if (mix.isEmpty()) {
//            while (!oprs.isEmpty()) {
//                char top = (Character) oprs.pollFirst();
//                tokens[index_token++] = top;
//            }
//
//        }


//        for (int i1 = 0; i1 < tokens.length; ++i1) {
//            System.out.println("tokens" + i1 + " :" + tokens[i1]);
//        }
//        //利用后缀表达式计算结果
//        for (int times = 0; times < tokens.length; ++times) {
//            if (tokens[times].equals('+')) {
//                int op2 = nums.pollFirst();
//                int op1 = nums.pollFirst() + op2;
//                nums.addFirst(op1);
//            } else if (tokens[times].equals('-')) {
//                int op2 = nums.pollFirst();
//                int op1 = nums.pollFirst() - op2;
//                nums.addFirst(op1);
//            } else if (tokens[times].equals('*')) {
//                int op2 = nums.pollFirst();
//                int op1 = nums.pollFirst() * op2;
//                nums.addFirst(op1);
//            } else if (tokens[times].equals('/')) {
//                int op2 = nums.pollFirst();
//                int op1 = nums.pollFirst() / op2;
//                nums.addFirst(op1);
//            } else {
//                nums.addFirst((Integer) tokens[times]);
//            }
//            System.out.println("nums:" + nums);
//        }


        //return nums.peekFirst();

    }

//    public static int getPriority(Object op) {
//        switch ((Character) op) {
//            case '+':
//                return 1;
//            case '-':
//                return 1;
//            case '*':
//                return 2;
//            case '/':
//                return 2;
//            default:
//                return 0;
//        }
//    }

//    public boolean A_higherPrioritythan_B(char a, char b) {
//        return ((a == '*' || a == '/') && (b != '*' && b != '/'));
//    }

    public boolean isOpr(Object in){
        return in.equals('+')||in.equals('-')||in.equals('*')||in.equals('/');
    }
    public int[] string2int(String s, int index) {
        if (index > s.length() - 1)
            return new int[]{};
        int[] res = new int[]{0, 0};
        for (int i = index; i < s.length(); ++i) {
            if (i == s.length() - 1)
                res[1] = i;
            if (s.charAt(i) < 48 || s.charAt(i) > 57) {
                res[1] = --i;
                break;
            }
            res[0] = res[0] * 10 + (s.charAt(i) - '0');
        }
        return res;
    }

}





