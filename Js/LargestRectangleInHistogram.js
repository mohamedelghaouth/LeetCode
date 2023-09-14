/**
 * @format
 * @param {number[]} heights
 * @return {number}
 */

var largestRectangleArea = function (heights) {
  let previousLessArray = getPreviousLessArray(heights);
  console.log(previousLessArray);
  let nextLessArray = getNextLessArray(heights);
  console.log(nextLessArray);
  let area = -1;
  let areas = [];
  for (let index = 0; index < heights.length; index++) {
    let tmpArea = getRectArea(index, heights, previousLessArray, nextLessArray);

    areas.push(tmpArea);

    area = area > tmpArea ? area : tmpArea;
  }

  return areas;
};

function getPreviousLessArray(heights) {
  let previousLessArray = new Array(heights.length);
  let stack = [];

  function getPreviousLessIndex(index) {
    while (
      stack.length !== 0 &&
      heights[stack[stack.length - 1]] >= heights[index]
    )
      stack.pop();

    if (stack.length === 0) return -1;

    return stack[stack.length - 1];
  }

  for (let index = 0; index < heights.length; index++) {
    previousLessArray[index] = getPreviousLessIndex(index);

    stack.push(index);
  }
  return previousLessArray;
}

function getNextLessArray(heights) {
  let nextLessArray = new Array(heights.length);
  let stack = [];

  function getNextLessIndex(index) {
    while (
      stack.length !== 0 &&
      heights[stack[stack.length - 1]] >= heights[index]
    )
      stack.pop();

    if (stack.length === 0) return heights.length;

    return stack[stack.length - 1];
  }

  for (let index = heights.length - 1; index >= 0; index--) {
    nextLessArray[index] = getNextLessIndex(index);

    stack.push(index);
  }

  return nextLessArray;
}

function getRectArea(index, heights, previousLessArray, nextLessArray) {
  let height = heights[index];
  let indexR = nextLessArray[index];
  let indexL = previousLessArray[index];

  return height * (indexR - indexL - 1);
}

console.log(largestRectangleArea([2, 1, 5, 6, 2, 3]));
