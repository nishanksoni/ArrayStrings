package Basic.TwoPointer;

import java.util.Arrays;

// Time O(n) and space complexity is O(1)

public class SeparateEvenOrOdd {
    public void evenOdd(int[] A) {
        int low = 0, high = A.length - 1;
        while (low < high) {
            // No need to do anything
            if (A[low] % 2 == 0) {
                low++;
            }
            // Just that you need to swap the high and low
            else {
                int temp = A[low];
                A[low] = A[high];
                A[high] = temp;
                high--;
            }
        }
    }


    public static void main(String[] args) {
        SeparateEvenOrOdd separateEvenOrOdd = new SeparateEvenOrOdd();
        int arr[] = {12, -2, 34, 0, -1, -5, -2, 45, 9, 8, 90, 3};
        separateEvenOrOdd.evenOdd(arr);

        System.out.println(Arrays.toString(arr));
    }
}

// 12, -2, 34, 0, 90, 8, -2, 9, 45, -5, 3, -1