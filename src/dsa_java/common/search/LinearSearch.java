package dsa_java.common.search;

public class LinearSearch {
    public static void main(String[] args) {
        int[] arr = {
          //0, 1, 2 , 3 , 4 , ...
            3, 7, 12, 18, 25, 31, 36, 42, 48, 55, 61, 67, 72, 79, 84, 90, 95, 101, 108, 115
        };

        int value = 55;

        System.out.println("Index of given number: " + search(arr, value));
    }

    //Linear search
    private static int search(int[] arr, int value) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == value) {
                return i;
            }
        }
        return -1;
    }
}
