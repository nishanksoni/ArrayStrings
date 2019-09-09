package DynamicProgramming;

import java.util.HashSet;
import java.util.Set;

// https://leetcode.com/problems/valid-sudoku/submissions/
// https://www.geeksforgeeks.org/check-if-given-sudoku-board-configuration-is-valid-or-not/
public class SudokuValidation {

    // Add rows in set
    // Add columns in set
    // Add block wise in set
    // Run for loop for up to board size
    // If already added in set it will return false - so sudoku is invalid
    public boolean isValidSudoku(char[][] board) {
        Set<String> seen = new HashSet();
        for (int i = 0; i < board.length; ++i) {
            for (int j = 0; j < board[0].length; j++) {
                char number = board[i][j];
                if (number != '.') {
                    boolean add = seen.add(number + " in row " + i);
                    boolean add1 = seen.add(number + " in column " + j);
                    boolean add2 = seen.add(number + " in block " + i / 3 + "-" + j / 3);
                    // if an of the value becomes false than we return false
                    if (!add || !add1 || !add2) {
                        return false;
                    }
                }
            }
        }
        return true;
    }


    public static void main(String[] args) {

        char[][] strings = {{'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '.', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};


        boolean validateSudoku = new SudokuValidation().isValidSudoku(strings);
        System.out.println(validateSudoku);

    }
}



// Hard Question - sudoku solver