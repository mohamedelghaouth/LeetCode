/** @format */

const Operators = ["+", "-", "*", "/"];
const stack = [];

function isOperator(key) {
  return Operators.includes(key);
}

function doOperation(key) {
  let secondOperand = parseInt(stack.pop());
  let firstOperand = parseInt(stack.pop());

  let result;

  switch (key) {
    case "+":
      result = firstOperand + secondOperand;

      break;
    case "-":
      result = firstOperand - secondOperand;

      break;
    case "*":
      result = firstOperand * secondOperand;

      break;
    case "/":
      result = Math.trunc(firstOperand / secondOperand);

      break;

    default:
      result = key;
      break;
  }

  return result;
}

/**
 * @format
 * @param {string[]} tokens
 * @return {number}
 */

var evalRPN = function (tokens) {
  let tmp = 0;
  for (const key of tokens) {
    tmp = key;

    if (isOperator(key)) tmp = doOperation(key);

    stack.push(tmp);
  }
  return stack.pop();
};

let tokens1 = ["2", "1", "+", "3", "*"]; // result should be 9
let tokens2 = ["4", "13", "5", "/", "+"]; // result should be 6
let tokens3 = [
  "10",
  "6",
  "9",
  "3",
  "+",
  "-11",
  "*",
  "/",
  "*",
  "17",
  "+",
  "5",
  "+",
]; // result should be 22

console.log(evalRPN(tokens1)); // result should be 9
console.log(evalRPN(tokens2)); // result should be 6
console.log(evalRPN(tokens3)); // result should be 22
