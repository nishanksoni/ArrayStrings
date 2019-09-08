package Basic.Sorting;

import java.util.Arrays;

// Examine a[Mid]. There are three possibilities:
//a[Mid] is (0) red, (1) white or (2) blue.
//Case (0) a[Mid] is red, swap a[Lo] and a[Mid]; Lo++; Mid++

// Solves two Problems
// 1.Segregate 0s , 1s
// 2.Segregate 0s,1s,2s
// https://www.geeksforgeeks.org/sort-an-array-of-0s-1s-and-2s/
public class DutchNationalFlagProblem {


    void sort012(int a[], int arr_size) {
        int low = 0;
        int high = arr_size - 1;
        int mid = 0, temp = 0;

        while (mid <= high) {
            switch (a[mid]) {
                //Case (0) a[Mid] is red, swap a[Lo] and a[Mid]; Lo++; Mid++
                case 0: {
                    temp = a[low];
                    a[low] = a[mid];
                    a[mid] = temp;
                    low++;
                    mid++;
                    break;
                }
                //Case (1) a[Mid] is white , Mid++
                case 1: // a[mid]  (1) white
                    mid++;
                    break;
                // Case (2)  a[Mid] is blue, swap a[Mid] and a[Hi]; Hi--
                case 2: {
                    temp = a[mid];
                    a[mid] = a[high];
                    a[high] = temp;
                    high--;
                    break;
                }
            }
        }
    }


    public static void main(String[] args) {
        DutchNationalFlagProblem dutchNationalFlagProblem = new DutchNationalFlagProblem();

        int sort0s1s2s[] = {0, 1, 2, 0, 1, 2};
        dutchNationalFlagProblem.sort012(sort0s1s2s, sort0s1s2s.length);


        int segregate0s1s[] = {0, 1, 0, 1, 0, 0, 1, 1, 1, 0};
        dutchNationalFlagProblem.sort012(segregate0s1s, segregate0s1s.length);

        System.out.println(Arrays.toString(sort0s1s2s));
        System.out.println(Arrays.toString(segregate0s1s));
    }
}
