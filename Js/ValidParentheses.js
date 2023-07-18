/**
 * Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 *
 * An input string is valid if:
 *
 * Open brackets must be closed by the same type of brackets.
 * Open brackets must be closed in the correct order.
 * Every close bracket has a corresponding open bracket of the same type.
 *
 * @format
 */

/**
 * Keys: are opening brackets
 * values: are closing brackets
 */
const bracketsMap = new Map([
  ["(", ")"],
  ["{", "}"],
  ["[", "]"],
]);

function isAnOpeningBracket(currentElement) {
  return bracketsMap.has(currentElement);
}

function isNotTheClosingBracketForTheLastElement(lastElement, currentElement) {
  return bracketsMap.get(lastElement) !== currentElement;
}

/**
 * @format
 * @param {string} s
 * @return {boolean}
 */
var isValid = function (s) {
  let stack = [];
  for (const currentElement of s) {
    if (isAnOpeningBracket(currentElement)) stack.push(currentElement);
    else {
      let lastElement = stack.pop();
      if (
        isNotTheClosingBracketForTheLastElement(lastElement, currentElement)
      ) {
        stack.push(lastElement);
        stack.push(currentElement);
      }
    }
  }

  return stack.length === 0;
};

//---------------------------Tests---------------------------------
console.log(isValid("[()]"));
console.log(isValid("(]"));
console.log(isValid("(])"));
console.log(isValid("]"));
console.log(isValid("()"));
