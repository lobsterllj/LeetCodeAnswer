import javafx.css.Size;

import java.security.PublicKey;
import java.util.*;

public class main {
    public static void main(String[] args) {
        main main = new main();


    }

    class RandomizedSet {
        Map<Integer,Integer> val_index;
        List<Integer> nums;
        /** Initialize your data structure here. */
        public RandomizedSet() {
            val_index=new HashMap<>();
            nums=new LinkedList<>();
        }

        /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
        public boolean insert(int val) {
            if(!val_index.containsKey(val)){
                nums.add(val);
                val_index.put(val,nums.size()-1);
                return true;
            }
            return false;
        }

        /** Removes a value from the set. Returns true if the set contained the specified element. */
        public boolean remove(int val) {
            if(val_index.containsKey(val)){
                int val_i=val_index.get(val);
                if(val_i==nums.size()-1){
                    nums.remove(nums.size()-1);
                    val_index.remove(val);
                }
                else {
                    nums.set(val_i,nums.get(nums.size()-1));
                    val_index.put(nums.get(nums.size()-1),val_i);
                    nums.remove(nums.size()-1);
                    val_index.remove(val);
                }
                return true;
            }
            return false;
        }

        /** Get a random element from the set. */
        public int getRandom() {
            Random random=new Random();
            return nums.get(random.nextInt(nums.size()));
        }
    }



}
