import java.util.*;

public class main {
    public static void main(String[] args) {
        main aa = new main();
        int[] a1=new int[]{1,2,2,1};
        int[] a2=new int[]{2,2};
        int[] res=aa.intersection(a1,a2);
        for (int it:res)
            System.out.println(it);

    }
    public int[] intersection(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        Set cache=new HashSet<Integer>();
        int i=0;
        int j=0;
        while(i< nums1.length&&j< nums2.length){
            if(nums1[i]<nums2[j]){
                i++;
            }
            else if(nums1[i]>nums2[j]){
                j++;
            }
            else {
                cache.add(nums1[i]);
                i++;
                j++;
            }
        }
        i=0;
        int[] res_int=new int[cache.size()];
        Iterator cac=cache.iterator();
        while(cac.hasNext()){
            res_int[i++]=(int)cac.next();
        }
            return res_int;
    }
}





