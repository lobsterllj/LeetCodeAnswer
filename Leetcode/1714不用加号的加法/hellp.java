public class hellp {

    public static int add(int a, int b) {
        int non_carry=a^b;
        System.out.println("non_carry0:"+non_carry);
        int carry=a&b;
        System.out.println("carry0:"+carry);
        int cache=non_carry;
        carry<<=1;  //4
        System.out.println("carry01:"+carry);

        while(carry!=0)
        {
            cache=non_carry;

            non_carry=carry^non_carry;  //1
            System.out.println("non_carry1:"+non_carry);

            carry=carry&cache;
            System.out.println("carry1:"+carry);

            carry<<=1;  //4
            System.out.println("carry11:"+carry);

        }
        return non_carry;
    }
    public static void main(String[] args) {
        //System.out.println("Hello World");
        int a=add(899,111);
        System.out.println(a);
    }

}
