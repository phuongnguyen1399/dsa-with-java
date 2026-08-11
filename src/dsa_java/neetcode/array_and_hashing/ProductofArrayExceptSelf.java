package dsa_java.neetcode.array_and_hashing;

public class ProductofArrayExceptSelf {
    public static void main(String[] args) {
        int[] nums = { 1,2,3,4 }; 
        int[] rs = productExceptSelf2(nums);
        for (int i : rs) {
            System.out.print(i + " - ");
        }
    }

    //Solution 1: O(n) time complexity
    public static int[] productExceptSelf1(int[] nums) {
        
        int[] prefixProduct = new int[nums.length];
        int[] suffixProduct = new int[nums.length];

        int i = 0;
        int j = nums.length - 1;

        while (i < nums.length && j >= 0) {
            if (i == 0) {
                prefixProduct[i] = 1;
                suffixProduct[j] = 1;
            } else {
                prefixProduct[i] = nums[i - 1] * prefixProduct[i - 1];
                suffixProduct[j] = nums[j + 1] * suffixProduct[j + 1];
            }
            i++;
            j--;
        }

        int[] result = new int[nums.length];
        for (int k = 0; k < result.length; k++) {
            result[k] = prefixProduct[k] * suffixProduct[k];
        }

        return result;
    }

    //Solution 2: O(n) time complexity and O(1) space complexity
    public static int[] productExceptSelf2(int[] nums) {
        int len = nums.length;

        //Create result array which is also a prefix product array
        int[] result = new int[len];
        result[0] = 1;

        //First loop to create prefix product
        for (int i = 1; i < len; i++) {
            result[i] = result[i - 1] * nums[i - 1];
        }

        //Second loop with suffix temp variable to calculate result //{ 1,1,2,6 }; 
        int suffTmp = 1;
        for (int i = len - 1; i >= 0; i--) {
            result[i] = suffTmp * result[i];
            suffTmp = suffTmp * nums[i];
        }

        return result;
    }
}
