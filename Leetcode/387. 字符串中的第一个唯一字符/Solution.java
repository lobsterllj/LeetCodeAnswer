public class Solution {
    public static void main(String[] args) {
        String a = "aabcd";
        String b = "ssadd";
        Solution aa = new Solution();

        System.out.println(aa.firstUniqChaR(a));
        isAnagraM aaa = new isAnagraM();
        //System.out.println(aaa.isAnagram(a,b));
    }

    public int firstUniqChaR(String s) {
        if (s.length() == 0) {
            return 0;
        } else {
            int[] s_int = new int[26];
            for (char c : s.toCharArray()) {
                s_int[c - 'a']++;
            }
            for (int i = 0; i < s.length(); ++i) {
                if (s_int[s.charAt(i) - 'a'] == 1) {
                    return i;
                }
            }
            return 0;
        }
    }


}
