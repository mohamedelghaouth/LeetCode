/** @format */

/**
 * @param {number} n
 * @return {string[]}
 */
var generateParenthesis = function (n) {
  let stack = ["()"];

  for (let i = 1; i < n; i++) {
    let length = stack.length;
    for (let j = 0; j < length; j++) {
      let tmp = stack.shift();
      if (j != 0) stack.push("()" + tmp);
      stack.push(tmp + "()");
      stack.push("(" + tmp + ")");
    }
  }
  return stack;
};

// console.log(generateParenthesis(1));
// console.log(generateParenthesis(2));
// console.log(generateParenthesis(3));
// console.log(generateParenthesis(4));

let expectedArray = [
  "(((())))",
  "((()()))",
  "((())())",
  "((()))()",
  "(()(()))",
  "(()()())",
  "(()())()",
  "(())(())",
  "(())()()",
  "()((()))",
  "()(()())",
  "()(())()",
  "()()(())",
  "()()()()",
];
let resultArray = generateParenthesis(4); // 14
let map = new Map();

resultArray.forEach((element) => {
  map.set(element, (map.get(element) || 0) + 1);
});

console.log(map);
