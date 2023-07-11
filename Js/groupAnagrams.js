/**
 * ------------------Problem----------------------
 * Given an array of strings strs, group the anagrams together. You can return the answer in any order.
 * An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.
 * @format
 */

/**
 * ------------------Hint-----------------------
 * anagrams words become the same when sorted:
 * eat -> aet
 * tea -> aet
 */

/**
 * @format
 * @param {string[]} strs
 * @return {string[][]}
 */

var groupAnagrams = function (strs) {
  function sortedVersion(params) {
    return params.split("").sort().join("");
  }

  function createMap() {
    let map = new Map();

    for (let i = 0; i < strs.length; i++) {
      const element = strs[i];
      const elemSorted = sortedVersion(element);
      if (map.has(elemSorted)) {
        map.get(elemSorted).push(element);
      } else {
        map.set(elemSorted, [element]);
      }
    }

    return map;
  }

  return [...createMap().values()];
};

let res = groupAnagrams(["eat", "tea", "tan", "ate", "nat", "bat"]);
console.log("🚀 ~ file: groupAnagrams.js:42 ~ res:", res);
