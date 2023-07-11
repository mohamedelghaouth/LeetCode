/**
 * ------------------Problem----------------------
 * Given two strings s and t, return true if t is an anagram of s, and false otherwise.
 * An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.
 *
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
 * @param {string} s
 * @param {string} t
 * @return {boolean}
 */
var isAnagram = function (s, t) {
  let firstSorted = s.split("").sort().join("");
  let secondSorted = t.split("").sort().join("");

  return firstSorted === secondSorted;
};
