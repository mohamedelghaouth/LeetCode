/** @format */
/**
 * Given an integer array nums and an integer k, return the k most frequent elements. You may return the answer in any order.
 *
 * the K element that are the most frequent
 */
function constructCountingMap(nums) {
  let map = new Map();
  for (const elm of nums) {
    if (map.has(elm)) {
      map.set(elm, map.get(elm) + 1);
    } else {
      map.set(elm, 1);
    }
  }

  return map;
}

function sortMap(map) {
  return new Map([...map.entries()].sort((a, b) => b[1] - a[1]));
}

/**
 * @format
 * @param {number[]} nums
 * @param {number} k
 * @return {number[]}
 */
var topKFrequent = function (nums, k) {
  let map = sortMap(constructCountingMap(nums));
  return [...map.keys()].slice(0, k);
};
