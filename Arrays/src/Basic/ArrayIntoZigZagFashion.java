package Basic;

// Given an array of DISTINCT elements, rearrange the elements of array in zig-zag fashion in O(n) time.
// The converted array should be in form a < b > c < d > e < f.
// https://www.geeksforgeeks.org/convert-array-into-zig-zag-fashion/

import java.util.Arrays;

public class ArrayIntoZigZagFashion {

    void zigZag(int arr[]) {
        boolean flag = true;
        int temp = 0; // Used for swapping
        for (int i = 0; i < arr.length - 1; i++) {
            if (flag == true) {
                // If we have a situation like A > B > C, we get A > B < C by swapping B and C
                if (arr[i] > arr[i + 1]) {
                    // swap
                    temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;

                }

            } else if (flag == false) {
                // If we have a situation like A < B < C, we get A < C > B by swapping B and C
                if (arr[i] < arr[i + 1]) {
                    // swap
                    temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                }
            }
            flag = !flag; /* flip flag  every time */
        }


    }


    public static void main(String[] args) {
        int arr[] = {4, 3, 7, 8, 6, 2, 1};
        new ArrayIntoZigZagFashion().zigZag(arr);
        System.out.println(Arrays.toString(arr));
    }
}
