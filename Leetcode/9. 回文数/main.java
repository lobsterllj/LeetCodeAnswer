
public class main {
    public static void main(String[] args) {
        main aa = new main();
        int a=1221;
        System.out.println(aa.reverse_int(a));
        System.out.println(aa.isPalindrome(a));
    }
    public boolean isPalindrome(int x) {
        if(x==0)
            return true;
        else if(x<0)
            return false;
        else
            return x==reverse_int(x);
    }

    public int reverse_int(int x) {
        int temp = 0;
        int res = 0;
        while (x != 0) {
            res = res * 10 + x % 10;
            if (temp != res / 10) {
                return 0;
            }
            temp=res;
            x=x/10;
        }

        return res;
    }


}
