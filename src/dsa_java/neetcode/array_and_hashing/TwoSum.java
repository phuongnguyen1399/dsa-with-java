package dsa_java.neetcode.array_and_hashing;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public static void main(String[] args) {
        int[] nums = {2,7,11,15};
        int target = 9;

        int[] result = twoSum(nums, target);

        if (result.length > 0) {
            for (int i : result) {
                System.out.print(i + " - ");
            }
        }

    }

    public static int[] twoSum(int[] nums, int target) {
        
        Map<Integer, Integer> maps = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (maps.containsKey(target - nums[i])) {
                return new int[] {maps.get(target - nums[i]), i};
            }
            maps.put(nums[i], i);
        }

        return null;
    }
}
