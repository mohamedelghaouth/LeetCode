package Java.solutions;


import java.util.HashSet;
import java.util.Set;

/**
 *
 * Determine if a 9 x 9 Sudoku board is valid. Only the filled cells need to be validated according to the following rules:
 *
 * Each row must contain the digits 1-9 without repetition.
 * Each column must contain the digits 1-9 without repetition.
 * Each of the nine 3 x 3 sub-boxes of the grid must contain the digits 1-9 without repetition.
 * Note:
 *
 * A Sudoku board (partially filled) could be valid but is not necessarily solvable.
 * Only the filled cells need to be validated according to the mentioned rules.
 *
 */
public class ValidateSudoku {

    /**
     *
     * Collect the set of things we see, encoded as strings. For example:
     * '4' in row 7 is encoded as "(4)7".
     * '4' in column 7 is encoded as "7(4)".
     * '4' in the top-right block is encoded as "0(4)2".
     * Scream false if we ever fail to add something because it was already added (i.e., seen before).
     *
     * */
    public boolean isValidSudoku(char[][] board) {
        Set<String> set = new HashSet<>();

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                char element = board[i][j];
                if(element != '.'){
                    if(
                        !set.add("add " + element + " to the line " + i) ||
                        !set.add("add " + element + " to the colon " + j) ||
                        !set.add("add " + element + " to block " + i/3 + " " + j/3)
                    ){
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
