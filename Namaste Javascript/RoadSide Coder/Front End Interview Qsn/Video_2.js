//*******************MAP REDUCE FILTER************ */

//map,filter,reduce
const nums = [1, 2, 3, 4];
const multiplyByThree = nums.map((num, i, arr) => {
  return num * 3;
});
const filterEven = nums.filter((num, i, arr) => {
  return num % 2 == 0;
});
const sum = nums.reduce((acc, curr, i, arr) => {
  return acc + curr;
}, 0);
//Polyfill
Array.prototype.myMap = function (cb) {
  let temp = [];
  for (let index = 0; index < this.length; index++) {
    temp.push(cb(this[index]));
  }
  return temp;
};
Array.prototype.myfilter = function (cb) {
  let temp = [];
  for (let index = 0; index < this.length; index++) {
    if (cb(this[index], index, this)) {
      temp.push(this[index]);
    }
  }
  return temp;
};
Array.prototype.myReduce = function (cb, initialValue) {
  var accumulator = initialValue;
  for (let index = 0; index < this.length; index++) {
    accumulator = accumulator ? cb(accumulator, this[index], index, this) : this[index];
  }
  return accumulator;
};
let students = [
  { name: "Aman", rollNumber: 31, marks: 80 },
  { name: "Abhishek", rollNumber: 35, marks: 70 },
  { name: "Aviral", rollNumber: 39, marks: 50 },
  { name: "Ashutosh", rollNumber: 43, marks: 60 },
];
console.log(students.map((student) => student.name.toUpperCase()));
console.log(students.filter((student) => student.marks > 60));
console.log(students.filter((stu) => stu.marks > 60 && stu.rollNumber > 32));
console.log(students.reduce((acc, stu) => acc + stu.marks, 0));

console.log(students.filter((stu) => stu.marks > 60).map((student) => student.name));
console.log(
  students
    .map((val) => {
      if (val.marks < 70) {
        val.marks = val.marks + 20;
      }
      return val;
    })
    .filter((stu) => stu.marks > 65)
    .reduce((acc, stu) => acc + stu.marks, 0)
);
