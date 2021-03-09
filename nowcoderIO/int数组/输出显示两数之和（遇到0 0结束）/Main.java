import java.util.Scanner;
public class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str;
        while ((str = sc.nextLine()) != null){
            String[] strings = str.split(" ");
            int i1 = Integer.parseInt(strings[0]);
            int i2 = Integer.parseInt(strings[1]);
            if (i1 == 0 && i2 == 0)
                break;
            System.out.println(i1 + i2);
        }
    }
}