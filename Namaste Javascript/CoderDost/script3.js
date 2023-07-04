const fruits = ["Banana", "Orange", "Apple", "Mango","Guava"];
// console.log(fruits.length)

// console.log(fruits.toString())

// console.log(fruits.join('|'))

// fruits.pop()
// console.log(fruits)

// let f=fruits.pop()
// console.log(fruits)

// fruits.push("Kiwi")
// console.log(fruits)

// fruits.shift();
// console.log(fruits)

// let shifted=fruits.shift();
// console.log(shifted)

// fruits.unshift("chiku")
// console.log(fruits)

// let newlen=fruits.unshift("Coconut");
// console.log(newlen)

// console.log(fruits[0],fruits[1],fruits[2])

// fruits[fruits.length]="Ginger";
// console.log(fruits)

// delete fruits[1];
// console.log(fruits)

const myGirls = ["Cecilie", "Lone"];
const myBoys = ["Emil", "Tobias", "Linus"];

const myChildren = myBoys.concat(myGirls);
// console.log(myChildren)

const nonflat=[[1,2,3],[4,[5,[6,7],8]]];
// console.log(nonflat.flat())
const nonflatten = [
  [1, 2, 3],
  [4, [5, [6, 7]], 8],
];

function customFlat(array, depth = 3) {
  let result = [];
  array.forEach((arr) => {
    if (Array.isArray(arr) == true && depth > 0) {
      result.push(...customFlat(arr, depth - 1));
    } else result.push(arr);
  });
  return result;
}
// console.log(customFlat(nonflat, 3));

const slice1=fruits.slice(1);
const slice2=fruits.slice(2);
const slice3=fruits.slice(1,4);
// console.log(fruits)
// console.log(slice1,slice2,slice3)

const fruit = ["Banana", "Orange", "Apple", "Mango"];
// fruit.splice(2, 0, "Lemon", "Kiwi");
// console.log(fruit)

// fruit.sort()
// console.log(fruit)

// fruit.reverse();
// console.log(fruit)
const num=[1,2,3,4,5,6,7,8,10];
num.sort((x,y)=>x-y);
// console.log(num);

// console.log(Math.max.apply(null,num))
// console.log(Math.min.apply(null,num))