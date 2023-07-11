/**
 *
 * -------------------------Problem--------------------------
 *
 * Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 * You can return the answer in any order.
 *
 *
 * --------------------------Hint-----------------------
 * you can use :
 *  - hash map were you put all elements: (key: nums[i], value: i)
 *  - and the astuce:  compliant = target - nums[i]
 *
 * @format
 */

/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number[]}
 */
var twoSum = function (nums, target) {
  let map = new Map();

  for (let i = 0; i < nums.length; i++) {
    const elem = array[i];
    let comp = target - elem;

    if (map.has(comp)) {
      return [map.get(comp), i];
    }

    map.set(elem, i);
  }

  return [];
};
