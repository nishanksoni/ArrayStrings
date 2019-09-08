package Basic.Sorting;

import java.util.Arrays;

// View Dutch national flag problem
// https://www.geeksforgeeks.org/sort-array-0s-1s-2s-simple-counting/
// https://leetcode.com/problems/sort-colors/

public class SortAnArrayOf0s1s2s {
    // Basic way
    private void sort(int[] arr) {
        int count0 = 0;
        int count1 = 0;
        int count2 = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                count0++;
                continue;
            }
            if (arr[i] == 1) {
                count1++;
                continue;
            }
            if (arr[i] == 2) {
                count2++;
                continue;
            }
        }
        for (int i = 0; i < count0; i++) {
            arr[i] = 0;
        }
        for (int i = count0; i < count1 + count0; i++) {
            arr[i] = 1;
        }
        for (int i = count1 + count0; i < arr.length; i++) {
            arr[i] = 2;
        }
    }

    // One pass solution
    void sortColors(int A[], int n) {
        int n0 = -1, n1 = -1, n2 = -1;
        for (int i = 0; i < n; ++i) {
            if (A[i] == 0) {
                A[++n2] = 2;
                A[++n1] = 1;
                A[++n0] = 0;
            } else if (A[i] == 1) {
                A[++n2] = 2;
                A[++n1] = 1;
            } else if (A[i] == 2) {
                A[++n2] = 2;
            }
        }
    }


    public static void main(String[] args) {
        int arr[] = {2, 0, 2, 1, 1, 0};
        SortAnArrayOf0s1s2s sortAnArray = new SortAnArrayOf0s1s2s();
        sortAnArray.sortColors(arr, arr.length);
        System.out.println(Arrays.toString(arr));
        sortAnArray.sort(arr);


    }


}
