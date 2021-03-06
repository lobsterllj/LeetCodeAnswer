import java.util.*;

public class main {
    public static void main(String[] args) {
        main main = new main();
        int[] ints=new int[]{1,2,3,4,5};
        System.out.println(main.maxProfit(ints));

    }

    public int maxProfit(int[] prices) {
        if(prices.length==0)
            return 0;
        int buy_price= prices[0];
        int sum_profit=0;
        for(int i=0;i<prices.length-1;++i){
            if(prices[i]<buy_price){
                buy_price=prices[i];
            }
            else
            {
                sum_profit+=prices[i]-buy_price;
                buy_price=prices[i];
            }
        }
        if(prices[prices.length-1]>buy_price){
            sum_profit+=prices[prices.length-1]-buy_price;
        }
        return sum_profit;
    }
}





