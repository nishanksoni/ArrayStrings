package DynamicProgramming;

// The best way to understand this solution is to understand the math under the hood.
// for m=7, n=3, we will always have 6 (m-1) Right, 2 (n-1)
// Down to reach the bottom-right corner. Total is 6+2=8 (m+n-2).
// Now it becomes a permutation question but with repetition. According to the formula,
// the ans should be (m+n-2)! / ( (m-1)! * (n-1)! )
// https://www.geeksforgeeks.org/delannoy-number/

// https://leetcode.com/problems/unique-paths/discuss/?currentPage=1&orderBy=most_votes&query=
public class TotalUniquePaths {

    // https://www.youtube.com/watch?v=GO5QHC_BmvM
    public int uniquePaths(int row, int column) {
        int mat[][] = new int[row][column];

        for (int i = 0; i < row; i++) {
            mat[i][0] = 1;
        }
        for (int i = 0; i < column; i++) {
            mat[0][i] = 1;
        }
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < column; j++) {
                mat[i][j] = mat[i][j - 1] + mat[i - 1][j];
            }
        }
        return mat[row - 1][column - 1]; // Last Row ,Last column
    }

    int uniquePathsCombinations(int m, int n) {
        int N = n + m - 2;// how much steps we need to do
        int k = m - 1; // number of steps that need to go down
        double res = 1;
        // here we calculate the total possible path number
        // Combination(N, k) = n! / (k!(n - k)!)
        // reduce the numerator and denominator and get
        // C = ( (n - k + 1) * (n - k + 2) * ... * n ) / k!
        for (int i = 1; i <= k; i++) {
            int i1 = N - k + i;
            res = res * i1;
            res = res / i;
        }
        return (int) res;
    }


    public static void main(String[] args) {
        TotalUniquePaths totalUniquePaths = new TotalUniquePaths();
        int i = totalUniquePaths.uniquePaths(4, 4);
        System.out.println(i);

        int i1 = totalUniquePaths.uniquePathsCombinations(7, 3);
        System.out.println(i1);


    }
}
