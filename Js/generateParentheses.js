/** @format */

/**
 *
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 *
 * @param {number} n
 * @return {string[]}
 */
var generateParenthesis = function (n) {
  let arr = [];
  generate(n, 0, 0, arr, "");

  return arr;
};

function generate(n, op, cl, arr, cum) {
  if (op === n && cl === n) {
    arr.push(cum);
    return;
  }

  if (op < n) {
    generate(n, op + 1, cl, arr, cum + "(");
  }

  if (cl < op) {
    generate(n, op, cl + 1, arr, cum + ")");
  }
}

let resultArray = generateParenthesis(3); // 14

console.log(resultArray);
