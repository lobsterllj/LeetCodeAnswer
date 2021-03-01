public class Solution {
    public static void main(String[] args) {
        Solution aa = new Solution();
        String a = "aabcd";
        String b = "abcde";

        char[] b_char=b.toCharArray();
        aa.reverseStrinG(b_char);
        for(char c:b_char)
        {
            System.out.println(c);

        }


//        387
//        firstUniqChar firstUniqChar_0=new firstUniqChar();
//        System.out.println(firstUniqChar_0.firstUniqChaR(a));

//        242
//        isAnagraM aaa = new isAnagraM();
//        System.out.println(aaa.isAnagram(a,b));
    }

    public void reverseStrinG(char[] s) {
        int s_len = s.length;
        if (s_len < 2) {
            return;
        } else {
            for (int i = 0; i < s_len / 2; ++i) {
                int j = s_len - i - 1;
                s[i] ^= s[j];
                s[j] ^= s[i];
                s[i] ^= s[j];
            }
        }
    }


}
