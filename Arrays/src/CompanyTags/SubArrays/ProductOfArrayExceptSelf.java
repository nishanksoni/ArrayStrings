package CompanyTags.SubArrays;

import java.util.Arrays;

// https://leetcode.com/problems/product-of-array-except-self/discuss/65622/Simple-Java-solution-in-O(n)-without-extra-space
// https://stackoverflow.com/questions/2680548/given-an-array-of-numbers-return-array-of-products-of-all-other-numbers-no-div?page=1&tab=oldest#tab-top
public class ProductOfArrayExceptSelf {

    public int[] productExceptSelfMyWay(int[] nums) {
        int temp[] = new int[nums.length];
        Arrays.fill(temp, 1);
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (i != j) {
                    temp[i] *= nums[j];
                }
            }
        }
        return temp;
    }


    public int[] usingLeftAndRight(int[] nums) {
        int length = nums.length;
        int resultLeftRightSide[] = new int[length];
        int productLeftSide = 1;
        resultLeftRightSide[0] = productLeftSide;
        for (int i = 1; i < length; i++) {
            productLeftSide = productLeftSide * nums[i - 1]; // So left value changes each and every time
            resultLeftRightSide[i] = productLeftSide; // Here only we are storing
        }
        System.out.println("My left end " + Arrays.toString(resultLeftRightSide));
        int right = 1;
        for (int i = length - 2; i >= 0; i--) {

            right = right * nums[i + 1];
            resultLeftRightSide[i] *= right;
        }

        System.out.println(Arrays.toString(resultLeftRightSide));

        return resultLeftRightSide;
    }

    public static void main(String[] args) {
        int[] arr = {2, 3, 4, 5};
        int[] ints = new ProductOfArrayExceptSelf().productExceptSelfMyWay(arr);
        System.out.println(Arrays.toString(ints));


        int[] ints1 = new ProductOfArrayExceptSelf().usingLeftAndRight(arr);


    }
}
