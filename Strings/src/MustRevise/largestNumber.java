package MustRevise;

import java.util.Arrays;
import java.util.Comparator;

// https://www.geeksforgeeks.org/given-an-array-of-numbers-arrange-the-numbers-to-form-the-biggest-number/
// https://leetcode.com/problems/largest-number/discuss/53158/My-Java-Solution-to-share
public class largestNumber {

    public String largestNumber(int[] num) {
        if (num == null || num.length == 0) {
            return "";
        }
        // Convert int array to String array, so we can sort later on
        String[] string_num = new String[num.length];
        for (int i = 0; i < num.length; i++) {
            string_num[i] = String.valueOf(num[i]);
        }
        Arrays.sort(string_num, new Comparator<String>() {
            @Override
            public int compare(String str1, String str2) {
                String s1 = str1 + str2;
                String s2 = str2 + str1;
                int i = s2.compareTo(s1); // Need to remember to put s2 before
                return i; // reverse order here, so we can do append() later
            }
        });
        System.out.println(Arrays.toString(string_num));
        // An extreme edge case by lc, say you have only a bunch of 0 in your int array
        if (string_num[0].charAt(0) == '0') {
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        for (String s : string_num) {
            sb.append(s);
        }
        return sb.toString();
    }


    public static void main(String[] args) {
        largestNumber largestNumber = new largestNumber();
        int[] arr = {3, 30, 34, 5, 9};
        String largestNum = largestNumber.largestNumber(arr);
        System.out.println(largestNum);


    }
}
