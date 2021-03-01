public class main {
    public static void main(String[] args) {
        main main = new main();
        System.out.println(main.hammingWeight(-1));
    }
    public int hammingWeight(int n) {
        int res=0;
        while(n!=0){
            res+=(n&1);
            n>>>=1;//无符号右移1位
        }
        return res;
    }

}





