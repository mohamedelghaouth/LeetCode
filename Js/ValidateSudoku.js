/**
 * @format
 * @param {character[][]} board
 * @return {boolean}
 */

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

/**
 *
 * Collect the set of things we see, encoded as strings. For example:
 * '4' in row 7 is encoded as "(4)7".
 * '4' in column 7 is encoded as "7(4)".
 * '4' in the top-right block is encoded as "0(4)2".
 * Scream false if we ever fail to add something because it was already added (i.e., seen before).
 *
 * */
var isValidSudoku = function (board) {
  const set = new Set();

  for (let i = 0; i < board.length; i++) {
    for (let j = 0; j < board.length; j++) {
      let element = board[i][j];
      // --------------------this work
      let line = `add ${element} to the line ${i}`;
      let colon = `add ${element} to the colon ${j}`;
      let block = `add ${element} to block ${parseInt(i / 3)} ${parseInt(
        j / 3
      )}`;
      // __________________this  does not work
      //   let line = "add " + element + " to the line " + i;
      //   let colon = "add " + element + " to the line " + j;
      //   let block =
      //     "add " +
      //     element +
      //     " to block " +
      //     parseInt(i / 3) +
      //     " " +
      //     parseInt(j / 3);

      if (element != ".") {
        let HasElement = set.has(line) || set.has(colon) || set.has(block);
        if (HasElement) {
          return false;
        } else {
          set.add(line);
          set.add(colon);
          set.add(block);
        }
      }
    }
  }

  return true;
};

let notValidBoard = [
  ["8", "3", ".", ".", "7", ".", ".", ".", "."],
  ["6", ".", ".", "1", "9", "5", ".", ".", "."],
  [".", "9", "8", ".", ".", ".", ".", "6", "."],
  ["8", ".", ".", ".", "6", ".", ".", ".", "3"],
  ["4", ".", ".", "8", ".", "3", ".", ".", "1"],
  ["7", ".", ".", ".", "2", ".", ".", ".", "6"],
  [".", "6", ".", ".", ".", ".", "2", "8", "."],
  [".", ".", ".", "4", "1", "9", ".", ".", "5"],
  [".", ".", ".", ".", "8", ".", ".", "7", "9"],
];
let validBoard = [
  ["5", "3", ".", ".", "7", ".", ".", ".", "."],
  ["6", ".", ".", "1", "9", "5", ".", ".", "."],
  [".", "9", "8", ".", ".", ".", ".", "6", "."],
  ["8", ".", ".", ".", "6", ".", ".", ".", "3"],
  ["4", ".", ".", "8", ".", "3", ".", ".", "1"],
  ["7", ".", ".", ".", "2", ".", ".", ".", "6"],
  [".", "6", ".", ".", ".", ".", "2", "8", "."],
  [".", ".", ".", "4", "1", "9", ".", ".", "5"],
  [".", ".", ".", ".", "8", ".", ".", "7", "9"],
];
console.log(isValidSudoku(notValidBoard)); // false
console.log(isValidSudoku(validBoard)); // true
