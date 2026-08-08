package dsa_java.neetcode.array_and_hashing;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ContainsDuplicate {
    public static void main(String[] args) {
        int nums[] = {1, 2, 3, 4};
        System.out.println(containsDuplicate(nums));
    }

    //Solution 1: HashMap
    public static boolean containsDuplicate(int[] nums) {
        Map<Integer, Integer> maps = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (maps.putIfAbsent(nums[i], nums[i]) != null) {
                return true;
            }
        }
        return false;
    }

    //Solution 2: HashSet
    public static boolean hasDuplicate(int[] nums) {
        Set<Integer> setNums = new HashSet<>();
        
        for (int i : nums) {
            if (setNums.contains(i)) {
                return true;
            }
            setNums.add(i);
        }
        return false;
    }
    
}
