package dsa_java.common.search;

public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = {
          //0, 1, 2 , 3 , 4 , ...
            // 3, 7, 12, 18, 25, 31, 36, 42, 48, 55, 61, 67, 72, 79, 84, 90, 95, 101, 108, 115
            1, 2, 3, 4, 5
        };

        int value = 1;

        System.out.println("Index of given number: " + search(arr, value));
    }

    //Binary search
    private static int search(int[] arr, int value) {
        if (arr.length <= 0) 
            return -1;

        int left = 0;
        int right = arr.length - 1;

        int mid;

        while (left <= right) {
            mid = (left + right) / 2;

            if (arr[mid] == value) {
                return mid;
            }

            if (arr[mid] < value) {
                left = mid + 1;
                // right = mid - 1;
            } else {
                right = mid - 1;
                // left = mid + 1;
            }
        }

        return -1;
    }

    // private static int helper(int mid, int left, int right, int value, int[] arr) {
    //     int mid = (left + right) / 2;
    //     if ()
    // }

}
