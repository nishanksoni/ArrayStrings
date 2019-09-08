package CompanyTags.SubArrays;

import java.util.Arrays;

// https://www.geeksforgeeks.org/maximum-product-subarray/
// https://leetcode.com/problems/maximum-product-subarray/

public class MaximumProductSubArray {

    // Normal way
    public int maxProduct(int[] arr) {
        int ans = arr[0];
        int max = arr[0];
        int min = arr[0];
        for (int i = 1; i < arr.length; i++) {
            int num = arr[i];
            int i1 = num * min;
            int i2 = num * max;
            int[] temp = {num, i1, i2};
            Arrays.sort(temp);
            max = temp[2];
            min = temp[0];
            ans = Math.max(ans, max);
        }
        return ans;
    }


    // O(n) way
    int maxProduct(int A[], int n) {
        // store the result that is the max we have found so far
        int result = A[0];

        // iMax/iMin stores the max/min product of sub array that ends with the current number A[i]
        int iMax = result, iMin = result;
        for (int i = 1; i < n; i++) {
            // multiplied by a negative makes big number smaller, small number bigger so we redefine the extremums by swapping them
            if (A[i] < 0) {
                int temp = iMax;
                iMax = iMin;
                iMin = temp;
            }
            // max/min product for the current number is either the current number itself
            // or the max/min by the previous number times the current one
            iMax = Math.max(A[i], iMax * A[i]);
            iMin = Math.min(A[i], iMin * A[i]);

            // the newly computed max value is a candidate for our global result
            result = Math.max(result, iMax);
        }
        return result;
    }


    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 4};
        int i = new MaximumProductSubArray().maxProduct(arr);
        System.out.println(i);


        int i1 = new MaximumProductSubArray().maxProduct(arr, arr.length);
        System.out.println(i1);


    }


}
