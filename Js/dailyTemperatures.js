/** @format */
/**
 * @format
 * @param {number[]} temperatures
 * @return {number[]}
 */

var dailyTemperatures = function (temperatures) {
  let resultArray = new Array(temperatures.length).fill(0);
  let stack = [0];

  for (let index = 1; index < temperatures.length; index++) {
    pullFromStackToResultArray(stack, resultArray, index, temperatures);
    stack.push(index);
  }

  return resultArray;
};

function pullFromStackToResultArray(stack, resultArray, index, temperatures) {
  let tmp = [];

  while (true) {
    tmp = stack.pop();
    if (tmp === undefined) {
      break;
    }
    if (temperatures[index] > temperatures[tmp]) {
      resultArray[tmp] = index - tmp;
    } else if (temperatures[index] <= temperatures[tmp]) {
      stack.push(tmp);
      break;
    }
  }
}

let result_1 = dailyTemperatures([73, 74, 75, 71, 69, 72, 76, 73]);
console.log("🚀 ~ file: dailyTemperatures.js:33 ~ result_1:", result_1);

result_1 = dailyTemperatures([30, 40, 50, 60]);
console.log("🚀 ~ file: dailyTemperatures.js:35 ~ result_1:", result_1);

result_1 = dailyTemperatures([30, 60, 90]);
console.log("🚀 ~ file: dailyTemperatures.js:37 ~ result_1:", result_1);
