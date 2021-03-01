import java.util.*;
import java.util.stream.Stream;

public class main {

    public static void main(String[] args) {
        main main = new main();

    }
    public int[] sortArray(int[] nums) {
        if(nums.length<2)
            return nums;
        for(int i=1;i< nums.length;++i){
            int uninsert=nums[i];
            int j=i-1;
            while (j>=0&&nums[j]>uninsert){
                nums[j+1]=nums[j];
                j--;
            }
            nums[j+1]=uninsert;
        }
        return nums;
    }
//    public insertionSort(int[] nums,int left,int right){
//
//    }
//    public void mergeSort(int[] nums,int left,int right,int[] cache){
//
//    }
//    public void mergeTwosorted(int[] nums,int left,int mid,int right,int[] cache){
//
//    }
}
