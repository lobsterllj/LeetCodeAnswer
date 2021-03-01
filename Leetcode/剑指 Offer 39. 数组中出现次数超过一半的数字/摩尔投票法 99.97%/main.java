
public class main {

    public static void main(String[] args) {
        main main = new main();
        int[] ints=new int[]{1,2,3,4,2,2,2,2,2,2};
        System.out.println(main.majorityElement(ints));
    }

    public int majorityElement(int[] nums) {
        int n=nums.length;
        int votes=0;
        int res=nums[0];
        for(int i=0;i<n;++i){
            if(votes==0){
                res=nums[i];
                votes++;
            }
            else {
                if(nums[i]==res){
                    votes++;
                }
                else {
                    votes--;
                }
            }
        }
        return res;
    }
}

