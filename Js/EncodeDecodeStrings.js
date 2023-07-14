/**
 * Design an algorithm to encode a list of strings to a string.
 * The encoded string is then sent over the network and is decoded back to the original list of strings.
 *
 * Example1
 *
 * Input: ["lint","code","love","you"]
 * Output: ["lint","code","love","you"]
 * Explanation:
 * One possible encode method is: "lint:;code:;love:;you"
 *
 * Example2
 * Input: ["we", "say", ":", "yes"]
 * Output: ["we", "say", ":", "yes"]
 * Explanation:
 * One possible encode method is: "we:;say:;:::;yes"
 *
 * @format
 */

const PATTERN = "@";

function encode(strs) {
  function encodeOneString(str) {
    return PATTERN + str.length + str;
  }

  let res = "";

  strs.forEach((element) => {
    res += encodeOneString(element);
  });

  return res;
}

function detectWord(start, str) {
  let res = "";
  let worldLength = parseInt(str.charAt(start + 1));
  let word = str.slice(start + 2, start + 2 + worldLength);

  res += word;
  return res;
}

function decode(str) {
  let res = [];
  let i = 0;
  while (i < str.length) {
    let word = detectWord(i, str);
    res.push(word);
    i += word.length + 2;
  }
  return res;
}

var EncodeDecodeStrings = function (nums, target) {};

console.log("-----------Array-------------");
s = [
  "@m@@e@d@",
  "@med",
  "3m&ed@4",
  "3m&ed@",
  "m&ed@",
  "@m@ed@",
  "m@ed",
  "@med",
  "med",
  "@med@",
];
console.log(s);
console.log("-----------Encoded Array-------------");
let encodeString = encode(s);
console.log(encodeString);
console.log("-----------Decode-------------");
console.log(decode(encodeString));
