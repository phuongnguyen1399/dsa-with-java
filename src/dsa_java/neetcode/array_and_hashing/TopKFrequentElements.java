package dsa_java.neetcode.array_and_hashing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

public class TopKFrequentElements {
    public static void main(String[] args) {
        // int[] nums = { 1,1,1,2,2,3 };
        int[] nums = { 1 };
        int k = 1;

        // expect [2, 3]
        for (int i : topKFrequentBucketSort(nums, k)) {
            System.out.println(i);
        }
    }

    //Solution 1: 
    public static int[] topKFrequent(int[] nums, int k) {

        Map<Integer, Integer> maps = new HashMap<>();

        for (int i : nums) {
            maps.merge(i, 1, (oldValue, newValue) -> {
                return oldValue + newValue;
            });
        }

         int[] array = maps.entrySet()
            .stream()
            .sorted(Map.Entry.<Integer, Integer>comparingByValue().reversed())
            .limit(k)
            .mapToInt(Map.Entry::getKey)
            .toArray();

        return array;
    }

    //Solution 2: Priority Queue
    public static int[] topKFrequentPQueue(int[] nums, int k) {

        Map<Integer, Integer> maps = new HashMap<>();

        for (int i : nums) {
            maps.put(i, maps.getOrDefault(i, 0) + 1);
        }

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(
            (a, b) -> maps.get(b) - maps.get(a));

        priorityQueue.addAll(maps.keySet());

        int[] array = new int[k];

        for (int i = 0; i < k; i++) {
            array[i] = priorityQueue.poll();
        }

        return array;
    }

    //Solution 3: bucket sort
    public static int[] topKFrequentBucketSort(int[] nums, int k) {
        //int[] nums = { 1,1,1,2,2,3 };

        Map<Integer, Integer> maps = new HashMap<>();

        //sau bước này sẽ có map (key, value) với key là phần tử trong mảng nums còn value là số lần xuất hiện của key đó trong nums
        for (int i : nums) {
            maps.merge(i, 1, Integer::sum);
        }
        //[0, 1, 2, 3, 4, 5, 6]
        
        // Lặp qua các phần tử của maps, check xem với key đó đã xuất hiện bao nhiêu lần
        // Ví dụ số 1 xuất hiện 3 lần thì sẽ thêm vào vị trí index 1 phần tử 3
        // Nếu index số 1 chưa có phần tử thì new ArrayList rồi add vào.
        // chưa thì tạo mới arrayList và add vào.
        List<Integer>[] bucket = new List[nums.length + 1];
        for (Map.Entry<Integer, Integer> entry : maps.entrySet()) {
            int num = entry.getKey();
            int frequency = entry.getValue();
            if (bucket[frequency] == null) {
                bucket[frequency] = new ArrayList<>();
            }
            bucket[frequency].add(num);
        }

        int[] array = new int[k];
        int index = 0;
        for (int i = nums.length; i > 0 && index < k; i--) {
            if (!Objects.isNull(bucket[i])) {
                for (int element : bucket[i]) {
                    array[index++] = element;
                    if (index == k) {
                        return array;
                    }
                }
            }
        }
        
        return array;
    }
}
