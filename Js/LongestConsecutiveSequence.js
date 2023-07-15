/** @format */

function getNextConsecutive(start, sortedArray) {
  let runner = start;
  let counter = 1;
  while (runner < sortedArray.length) {
    if (sortedArray[runner + 1] - sortedArray[runner] == 1) {
      ++runner;
      ++counter;
    } else if (sortedArray[runner + 1] - sortedArray[runner] == 0) {
      ++runner;
    } else {
      break;
    }
  }
  return counter;
}
/**
 * @param {number[]} nums
 * @return {number}
 */

var longestConsecutive = function (nums) {
  nums.sort((a, b) => a - b);

  let longestConsecutive = 0;
  let runner = 0;

  while (runner < nums.length) {
    let consecutiveSize = getNextConsecutive(runner, nums);
    longestConsecutive = Math.max(consecutiveSize, longestConsecutive);
    runner += consecutiveSize;
  }

  return longestConsecutive;
};

//-------------------Test Cases----------------------------------------------

let nums_1 = [100, 4, 200, 1, 3, 2];
let nums_2 = [0, 3, 7, 2, 5, 8, 4, 6, 0, 1];
let nums_3 = [1, 2, 0, 1];
console.log(longestConsecutive(nums_1));
console.log(longestConsecutive(nums_2));
console.log(longestConsecutive(nums_3));
