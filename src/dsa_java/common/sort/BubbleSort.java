package dsa_java.common.sort;

public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {5, 4, 2, 40, 20, 99};
        int[] sortedArr = bubbleSort(arr);
        for (int i : sortedArr) {
            System.out.print(i + " - ");
        } 
    }

    public static int[] bubbleSort(int[] arr) {
        int size = arr.length;
        
        int[] newArr = new int[size];

        for (int i = 0; i < size - 1; i++) {
            for (int j = i; j < size; j++) {
                if (arr[i] > arr[j]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }

        return arr;
    }
}
