package CompanyTags;

import java.util.Arrays;
import java.util.PriorityQueue;

// https://leetcode.com/problems/kth-largest-element-in-an-array/discuss/60294/Solution-explained
// https://www.geeksforgeeks.org/kth-smallestlargest-element-unsorted-array/
public class KthLargestElementInAnArray {

    //  O(N log N) running time + O(1) memory
    public int findKthLargestUsingSort(int[] nums, int k) {
        final int N = nums.length;
        Arrays.sort(nums);
        int position = N - k;
        return nums[position];
    }

    // O(N lg K) running time + O(K) memory
    public int findKthLargest(int[] arr, int k) {
        final PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        for (int val : arr) {
            priorityQueue.offer(val);
            if (priorityQueue.size() > k) {
                priorityQueue.poll(); // Removing an element from PriorityQueue
            }
        }
        Integer peek = priorityQueue.peek(); // Getting the top element from PriorityQueue we need N-K position
        return peek;
    }


    public int findKthSmallest(int[] arr, int k) {
        final PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        for (int val : arr)
        {
            priorityQueue.add(val);
            if (priorityQueue.size() > k)
            {
                priorityQueue.poll();
                System.out.println("The  poll queue is " + Arrays.toString(priorityQueue.toArray()));
                return priorityQueue.peek();
            }
        }
        System.out.println("Sorted Priority queue is " + Arrays.toString(priorityQueue.toArray()));
        return -1;
    }


    public static void main(String[] args) {
        KthLargestElementInAnArray kthLargest = new KthLargestElementInAnArray();
        int[] arr = {7, 10, 4, 3, 20, 15};
        int k = 4;
        int kthLargest1 = kthLargest.findKthLargest(arr, k);
        System.out.println("The largest Element is " + kthLargest1);


        int kthSmallest = kthLargest.findKthSmallest(arr, k);
        System.out.println("The smallest element is " + kthSmallest);

        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
    }

}
