import java.math.BigInteger;

public class Solution {
    public static void main(String[] args) {

        Solution aa = new Solution();
        System.out.println("===" + aa.fisrtnum(5));

    }

    public boolean notsmallVersion(long version) {
        boolean flag = false;
        int set = 4;
        if (version >= set) {
            flag = true;
        }
        return flag;
    }

    public int fisrtnum(int in) {
        long lo = 1;
        long hi = in;
        long res = 0;

        while ((hi - lo) > 1) {
            res = (lo + hi) / 2;
            if (notsmallVersion(res)) {
                hi = res;
            } else {
                lo = res;
            }
        }
        if (notsmallVersion(lo)) {
            res = lo;
        } else {
            res = lo + 1;
        }
        return (int)res;
    }

}
