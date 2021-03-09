import java.util.Scanner;
public class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            long l1 = sc.nextLong();
            long l2 = sc.nextLong();
            System.out.println(l1 + l2);
        }
    }
}