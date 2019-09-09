package CompanyTags;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/count-of-smaller-numbers-after-self/
public class CountOfSmallerNumbersAfterSelf {
    public List<Integer> countSmallerRightSide(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int result = 0;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] > nums[j]) {
                    result++;
                }
            }
            list.add(i, result);
        }
        return list;
    }


    public static void main(String[] args) {
        int arr[] = {5, 2, 6, 1};
        List<Integer> list = new CountOfSmallerNumbersAfterSelf().countSmallerRightSide(arr);
        System.out.println(list);
    }
}
