/**
 * You are given an integer array height of length n. There are n vertical lines drawn such that the two endpoints of the ith line are (i, 0) and (i, height[i]).
 * Find two lines that together with the x-axis form a container, such that the container contains the most water.
 * Return the maximum amount of water a container can store.
 * Notice that you may not slant the container.
 */
function maxArea(heights) {
  let j = heights.length - 1;
  let i = 0;
  let max = j * Math.min(heights[j], heights[i]);
  while (j > i) {
    if (heights[i] < heights[j]) {
      max = Math.max(max, (j - i - 1) * Math.min(heights[j], heights[i + 1]));
      i++;
    } else {
      max = Math.max(max, (j - i - 1) * Math.min(heights[j - 1], heights[i]));
      j--;
    }
  }
  return max;
}
