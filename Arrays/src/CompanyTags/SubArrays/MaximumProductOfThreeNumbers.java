package CompanyTags.SubArrays;

import java.util.Arrays;

// https://www.geeksforgeeks.org/find-maximum-product-of-a-triplet-in-array/
// https://leetcode.com/problems/maximum-product-of-three-numbers/
public class MaximumProductOfThreeNumbers {
    public int maximumProduct(int[] nums) {
        if (nums.length < 3) {
            return -1;
        }
        Arrays.sort(nums);
        int length = nums.length;
        int result = Math.max(nums[0] * nums[1] * nums[length - 1], nums[length - 1] * nums[length - 2] * nums[length - 3]);
        return result;

    }

    public int maximumProductOptimizedWay(int[] arr) {
        int max1 = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;
        int max3 = Integer.MIN_VALUE;
        int min1 = Integer.MAX_VALUE;
        int min2 = Integer.MAX_VALUE;
        for (int num : arr) {
            if (num > max1) {
                max3 = max2;
                max2 = max1;
                max1 = num;
            } else if (num > max2) {
                max3 = max2;
                max2 = num;
            } else if (num > max3) {
                max3 = num;
            }
            if (num < min1) {
                min2 = min1;
                min1 = num;
            } else if (num < min2) {
                min2 = num;
            }
        }

        return Math.max(max1 * max2 * max3, max1 * min1 * min2);
    }

    public static void main(String[] args) {
        int arr[] = {-4, -3, -2, -1, 60};
        int i = new MaximumProductOfThreeNumbers().maximumProduct(arr);
        System.out.println(i);

        int m = new MaximumProductOfThreeNumbers().maximumProductOptimizedWay(arr);
        System.out.println(m);
    }
}
