import java.util.Scanner;
public class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int cnt = Integer.parseInt(sc.nextLine());
        String str;
        while (cnt-- > 0){
            str = sc.nextLine();
            String[] ints = str.split(" ");
            System.out.println(Integer.parseInt(ints[0]) + Integer.parseInt(ints[1]));
        }
    }
}