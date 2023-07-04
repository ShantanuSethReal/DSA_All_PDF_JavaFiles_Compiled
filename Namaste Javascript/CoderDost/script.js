const arr = [1, 2, 3, 4, 5];
const arr1 = [1, 2, 3, 4, 5, 10, 10, 12, 12];
//SUM OF ARRAY EXCEPT SELF
function problem1(a) {
  const b = [...a];
  let globalsum = 0;
  for (let index = 0; index < b.length; index++) {
    globalsum += b[index];
  }
  let nArr = [];
  for (let index = 0; index < b.length; index++) {
    nArr.push(globalsum - b[index]);
  }
  return nArr;
}
// console.log(problem1(arr));
//MERGE OBJECTS
let obj1 = { a: 1, b: 2, c: 3, d: 4, e: 5 };
let obj2 = { a: 11, b: 21, c: 31, d: 4, e: 5 };
function problem2(o1, o2) {
  let o3 = {};
  for (let keys in o1) {
    if (o1[keys] === o2[keys]) {
      o3[keys] = o1[keys];
    }
  }
  return o3;
}
// console.log(problem2(obj1,obj2))
//SECOND LARGEST ELEMENT IN ARRAY
function problem3(arr) {
  let greatest_first = -Infinity;
  let greatest_second = -Infinity;

  for (let index = 0; index < arr.length; index++) {
    const element = arr[index];
    if (element > greatest_first) {
      greatest_second = greatest_first;
      greatest_first = element;
    } else if (element > greatest_second && element < greatest_first) {
      greatest_second = element;
    }
  }
  //   return greatest_second;
  let nArr = [...new Set([...arr])].sort((x, y) => x - y);
  let len = nArr.length;
  //   return nArr[len-2];
  let nArr2 = [...arr].sort((x, y) => x - y);
  let len2 = nArr2.length;
  let gr = nArr2[len2 - 1];
  let i = len2 - 2;
  while (i >= 0) {
    if (nArr2[i] != gr) {
      return nArr2[i];
    }
  }
}
// console.log(problem3(arr));
//ROTATING ARRAY BY D PLACES
function problem4(arr, k) {
  let b = [...arr];
  let len = b.length;
  for (let j = 0; j < k; j++) {
    let old = b[0];
    for (let index = 1; index < b.length; index++) {
      b[index - 1] = b[index];
    }
    b[len - 1] = old;
  }
  return b;
}
// console.log(arr);
// console.log(problem4(arr,3));
//MISSING NUMBER IN ODD SORTED ARRAY
const odd_sorted = [3, 5, 7, 9, 11, 13, 17];
function problem5(arr) {
  for (let i = 0; i < arr.length - 1; i++) {
    const element = arr[i];
    if (arr[i + 1] !== element + 2) {
      return element + 2;
    }
  }
  return arr[arr.length - 1];
}
// console.log(problem5(odd_sorted))
function problem6(str) {
  let split_a = str.split(" ").reverse();
  // return split_a.reverse().join(" ");
  return split_a.map((item) => item.split("").reverse().join("")).join(" ");
}
// console.log(problem6("Hi It is Raining Outside"))
function problem7(str) {
  let a = [...str];
  let amap = {};
  for (let index = 0; index < a.length; index++) {
    const element = a[index];
    if (amap[element.toLowerCase()]) {
      amap[element.toLowerCase()] += 1;
    } else {
      amap[element.toLowerCase()] = 1;
    }
  }
  let maxval = -Infinity;
  let maxcha = "";
  for (let key in amap) {
    if (amap[key] > maxval) {
      maxcha = key;
      maxval = amap[key];
    }
  }
  //   return maxcha;
  const arrOfsplit = str.split("");
//   console.log(arrOfsplit);
  const result = arrOfsplit.reduce((acc, curr) => (Object.keys(acc).includes(curr) ? { ...acc, [curr.toLowerCase()]: acc[curr] + 1 } : { ...acc, [curr.toLowerCase()]: 1 }),{});
//   console.log(result);
  const sortedobj=Object.entries(result).sort((a,b)=>a[1]-b[1])
//   console.log(sortedobj)
  return sortedobj[sortedobj.length-1[1]];
}
problem7("Hi it is raining outside");
