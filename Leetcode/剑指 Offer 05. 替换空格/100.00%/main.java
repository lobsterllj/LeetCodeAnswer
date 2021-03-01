public class main {

    public static void main(String[] args) {
        main main = new main();
        String s="a b c";
        System.out.println(main.replaceSpace(s));
    }

    public String replaceSpace(String s) {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < s.length(); ++i) {
            if (s.charAt(i) == ' ') {
                res.append('%');
                res.append("20");
            } else
                res.append(s.charAt(i));
        }
        return res.toString();
    }

}
