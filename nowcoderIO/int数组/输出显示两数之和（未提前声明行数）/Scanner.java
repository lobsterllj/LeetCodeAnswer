import java.util.Scanner;
public class nowcoderIO {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str;
        while (sc.hasNextLine()) {
            str = sc.nextLine();
            String[] ints = str.split(" ");
            System.out.println(Integer.parseInt(ints[0]) + Integer.parseInt(ints[1]));
        }
    }
}