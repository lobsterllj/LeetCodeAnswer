import java.util.Stack;

public class main {


    public static int[] singleNumber1(int[] nums) {
        int[] res = new int[2];
        int res1_res2 = nums[0];
        int res1 = 0;
        int res2 = 0;


        for (int i = 1; i < nums.length; ++i) {
            res1_res2 = res1_res2 ^ nums[i];
        }
        System.out.println("res1_res2:" + res1_res2);

        int index_low = index_low(res1_res2);
        System.out.println("index_low:" + index_low);
        int compare = 1 << index_low;
        System.out.println("compare:" + compare);

        for(int i=0;i<nums.length;++i)
        {
            if(intToBit(nums[i])[index_low]==0)
            {
                res1^=nums[i];
            }
            else
            {
                res2^=nums[i];
            }

        }

        res[0] = res1;
        res[1] = res2;
        return res;

    }

    public static int XNOR(int a,int b)
    {
        int res=0;
        int[] res_bit=new int[32];

        int[] a_bit=intToBit(a);
        int a_bit_index=0;
        int[] b_bit=intToBit(b);
        int b_bit_index=0;
        int index=0;
        for(int i=31;i>-1;--i)
        {
            if(a_bit[i]!=0)
            {
                a_bit_index=i;
                break;
            }
        }
        for(int i=31;i>-1;--i)
        {
            if(b_bit[i]!=0)
            {
                b_bit_index=i;
                break;
            }
        }
        if(a_bit_index>b_bit_index)
        {
            index=a_bit_index;
        }
        else
        {
            index=b_bit_index;
        }

        for (int i=0;i<index+1;++i)
        {
            if(a_bit[i]==b_bit[i])
            {
                res_bit[i]=1;
            }

        }
        for (int i=0;i<res_bit.length;++i)
        {
            res+=res_bit[i]<<i;
        }
        return res;

    }
    public static int[] intToBit(int b) {
        int[] res=new int[32];

        for(int i=0;i<32;++i)
        {
            res[i]=(byte)(b&0x01);
            b=b>>1;
        }

        return res;
    }


    public static int index_low(int res1_res2) {

        int index_low_1 = 31;
        if ((res1_res2 & 0xffff) > 0) {
            index_low_1 -= 16;
            res1_res2 &= 0xffff;
        }
        if ((res1_res2 & 0xff00ff) > 0) {
            index_low_1 -= 8;
            res1_res2 &= 0xff00ff;
        }
        if ((res1_res2 & 0xf0f0f0f) > 0) {
            index_low_1 -= 4;
            res1_res2 &= 0xf0f0f0f;
        }
        if ((res1_res2 & 0x33333333) > 0) {
            index_low_1 -= 2;
            res1_res2 &= 0x33333333;
        }
        if ((res1_res2 & 0x55555555) > 0) {
            index_low_1 -= 1;
            res1_res2 &= 0x55555555;
        }

        return index_low_1;

    }

    public static void main(String[] args) {

        main aa = new main();
        int[] in = {1, 2, 1, 3, 2, 5};
        int[] res;


//        System.out.println("--------------");
//        int[] test=aa.intToBit(15);
//        for(int i=0;i<test.length;++i)
//        {
//            System.out.println(test[i]);
//        }
//        System.out.println("--------------");

        res = singleNumber1(in);
        System.out.println("out[0]:" + res[0]);
        System.out.println("out[1]:" + res[1]);
//        System.out.println(6 ^ 3 );
//        System.out.println(aa.XNOR(6,3));
//        System.out.println(6 ^ 5 );
//        System.out.println(aa.XNOR(6,5));
    }

}
