package CompanyTags.SubArrays;

import java.util.HashMap;

public class SubArrayWithGivenSum {
    public int subArraySum(int[] arr, int k) {
        if (arr.length == 0) {
            return 0;
        }
        int sum = 0, result = 0;
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        hashMap.put(0, 1);
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            int key = sum - k;
            if (hashMap.containsKey(key)) {
                Integer integer = hashMap.get(key);
                result += hashMap.get(key);
            }
            hashMap.put(sum, hashMap.getOrDefault(sum, 0) + 1);
        }
        return  result;
    }


    public static void main(String[] args) {
        int arr[] = {1, 1, 1};
        int k = 2;
        new SubArrayWithGivenSum().subArraySum(arr, k);
    }
}
