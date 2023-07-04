//Convert Array to Object
const arr = ["a", "b", "c", "d"];
let obj = arr.reduce((accumulator, current) => {
  return { ...accumulator, [current]: current };
}, {});
// console.log(obj);
//Output Question
(function () {
  var x, y;
  try {
    throw new Error();
  } catch (x) {
    x = 1;
    y = 2;
    console.log(x);
  }
  console.log(x);
  console.log(y);
});
//Hoisting
x = 5;
var x;
// console.log(x);
// say();
function say() {
  console.log("Hello");
}
var y = 3;
function call() {
//   console.log(y);
  //   var z = 1;
  var y = 1;
}
call();

for (let i = 0; i < 5; i++) {
  setTimeout(() => {
    // console.log(i);
  }, i * 1000);
}
for (var i = 0; i < 5; i++) {
  setTimeout(() => {
    // console.log(i);
  }, i * 1000);
}
const str1=Array.from("Hello");
// console.log(str1)
const set1=Array.from(new Set([1,2,3,4]))
// console.log(set1)
const a=[1,2,3,4];
const mapfrom=Array.from(a,it=>3*it);
// console.log(mapfrom)
// console.log(Array.from({length: 10},(it,index)=>index*2))


var name="Akash"
function hellonormal(){return this.name;}
const helloarrow=()=>{return this.name}
const person={name:"John",age: 29,helloarrow,hellonormal};
// console.log(person.helloarrow())
// console.log(person.hellonormal())