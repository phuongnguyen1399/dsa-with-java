package dsa_java.neetcode.array_and_hashing;

public class ProductofArrayExceptSelf {
    public static void main(String[] args) {
        int[] nums = { 1,2,3,4 }; 
        int[] rs = productExceptSelf1(nums);
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
}
