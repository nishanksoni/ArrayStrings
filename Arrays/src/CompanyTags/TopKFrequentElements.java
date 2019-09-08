package CompanyTags;

import java.util.*;

public class TopKFrequentElements {


    // Time complexity : O(N log(k)).
    // https://leetcode.com/problems/top-k-frequent-elements/solution/
    public List<Integer> usingPriorityQueue(int[] arr, int k) {
        // Put all in Map
        Map<Integer, Integer> hashMap = new HashMap<>();
        for (int n : arr) {
            hashMap.put(n, hashMap.getOrDefault(n, 0) + 1);
        }
        // Initialize  heap 'the less frequent element first'
        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>((n1, n2) -> hashMap.get(n1) - hashMap.get(n2));
        for (int n : hashMap.keySet()) {
            maxHeap.add(n);
            if (maxHeap.size() > k)  // If some element having size more than k than poll that element
            {
                maxHeap.poll();
            }
        }
        //   System.out.println(Arrays.toString(maxHeap.toArray())); -- Another option to print priorityQueue instead of list
        List<Integer> list = new LinkedList<>();
        while (!maxHeap.isEmpty()) {
            list.add(maxHeap.poll());
        }
        Collections.reverse(list);

        return list;
    }

    // https://leetcode.com/problems/top-k-frequent-elements/discuss/81602/Java-O(n)-Solution-Bucket-Sort
    private List<Integer> usingBucketSort(int[] arr, int k) {
        List<Integer> res = new ArrayList<>();
        Set<Integer>[] bucket = new HashSet[arr.length + 1];
        if (arr == null || arr.length == 0) {
            return res;
        }
        Map<Integer, Integer> map = new HashMap<>();
        // Putted all in Map
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }

        for (int num : map.keySet()) {
            int count = map.get(num);
            if (bucket[count] == null) {
                bucket[count] = new HashSet<>();
            }
            bucket[count].add(num);
        }

        for (int pos = bucket.length - 1; pos >= 0; pos--) {
            if (bucket[pos] != null) {
                if (res.size() == k) {
                    break;
                }
                for (int num : bucket[pos]) {
                    res.add(num);
                }
            }
        }

        return res;
    }


    public static void main(String[] args) {
        int arr[] = {1, 1, 1, 2, 2, 3};
        int k = 2;
        List<Integer> list1 = new TopKFrequentElements().usingPriorityQueue(arr, k);
        System.out.println(list1);


        List<Integer> list = new TopKFrequentElements().usingBucketSort(arr, k);
        System.out.println(list);

    }


}
