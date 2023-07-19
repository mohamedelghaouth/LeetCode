/** @format */

var MinStack = function () {
  this.stack = [];
};

/**
 * @param {number} val
 * @return {void}
 */
MinStack.prototype.push = function (val) {
  this.stack.push({ value: val, min: Math.min(this.getMin(), val) });
};

/**
 * @return {void}
 */
MinStack.prototype.pop = function () {
  this.stack.pop();
};

/**
 * @return {number}
 */
MinStack.prototype.top = function () {
  return this.stack.length > 0 ? this.stack[this.stack.length - 1].value : null;
};

/**
 * @return {number}
 */
MinStack.prototype.getMin = function () {
  return this.stack.length > 0
    ? this.stack[this.stack.length - 1].min
    : Number.MAX_VALUE;
};

let minStack = new MinStack();
minStack.push(-2);
minStack.push(0);
minStack.push(-3);
console.log(minStack.getMin()); // return -3
minStack.pop();
console.log(minStack.stack); // return 0
console.log(minStack.top()); // return 0
console.log(minStack.getMin()); // return -2
