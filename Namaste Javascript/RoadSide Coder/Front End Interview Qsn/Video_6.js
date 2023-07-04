//************OBJECTS************************ */

//Objects MDN

const user = {
  name: "Roadside Coder",
  age: 24,
};

console.log(user.name); //Roadside Coder or
console.log(user["name"]); //Roadside Coder

user.name = "Piyush";
console.log(user["name"], user); //Piyush

delete user.age;
console.log(user);

// //O/P based question
const func = (function (a) {
  delete a;
  return a;
})(5);
console.log(func);

let user1 = {
  name: "Roadside Coder",
  age: 24,
  "like this Video": true,
};
console.log(user1["like this Video"]);
// //Dynamic properties
let property = "firstName";
let name = "Piyush Agarwal";
let person = { property: name };
let person2 = { [property]: name };
console.log(person, person2);

let user2 = { name: "Piyush", age: 24 };
for (let key in user2) {
  console.log(key);
}

// //Questions
const obj = { a: "one", b: "two", a: "three" };
console.log(obj);

const nums = { a: 200, b: 400, title: "My nums" };
function multiplyByTwo(obj) {
  for (let key in obj) {
    if (typeof obj[key] == "number") {
      obj[key] *= 2;
    }
  }
  return obj;
}
console.log(multiplyByTwo(nums));

// //O/P based Question
const a = {};
const b = { key: "b" };
const c = { key: "c" };
a[b] = 123;
a[c] = 456;

console.log(a[b]); //456

// //Question
const user3 = { name: "Lydia", age: 21 };
console.log(JSON.stringify(user3));
const strObj = JSON.stringify(user3);
console.log(JSON.parse(strObj));
//Question
console.log([..."Lydia"]);

// //Question
const user4 = { name: "Lydia", age: 21 };
const admin = { admin: true, ...user4 };
console.log(admin);

const settings = { username: "lydiahallie", level: 19, health: 90 };
const data = JSON.stringify(settings, ["level", "health"]);
console.log(data);

// //Question
const shape = {
  radius: 10,
  diameter() {
    return this.radius * 2;
  },
  perimeter: () => 2 * Math.PI * this.radius,
};
console.log(shape.diameter());
console.log(shape.perimeter());

// //Question
let user5 = { name: "Piyush", age: 24 };
const { age } = user5;
console.log(age);

const { age: myAge } = user5;
console.log(myAge);

let user6 = { name: "Piyush", age: 24, fullName: { firstName: "Piyush", secondName: "Aggarwal" } };
const { fullName } = user6;
console.log(fullName);
const {
  fullName: { firstName },
} = user6;
console.log(firstName);
function getItems(fruitList, favoriteFruit, ...args) {
  return [...fruitList, ...args, favoriteFruit];
}

console.log(getItems(["banana", "apple"], "pear", "orange"));

// //Copy Objects
let co = { greeting: "Hey!" };
let d;
d = co;
co.greeting = "Hello";
console.log(d.greeting); // Hello

// //O/P based
console.log({ a: 1 } == { a: 1 });
console.log({ a: 1 } === { a: 1 });

let person1 = { name: "Lydia" };
const members = [person1];
person1 = null;
console.log(members);

let person3 = { name: "Lydias" };
const members2 = [person3];
person3.name = null;
console.log(members2);

const value = { number: 10 };

const multiply = (x = { ...value }) => {
  console.log((x.number *= 2));
};

multiply();
multiply();
multiply(value);
multiply(value);

function changeAgeAndReference(person) {
  person.age = 25;
  person = {
    name: "John",
    age: 50,
  };

  return person;
}

const personObj1 = {
  name: "Alex",
  age: 30,
};

const personObj2 = changeAgeAndReference(personObj1);

console.log(personObj1);
console.log(personObj2);

const userinfo = {
  name: "Jen",
  age: 26,
};
const copyOfUserinfo = userinfo;
console.log(userinfo, "userinfo");
copyOfUserinfo.age = 24;

const object = {
  class: "1",
  rollNo: "12",
};
const objclone = Object.assign({}, object);
const objclone2 = JSON.parse(JSON.stringify(object));
const objclone3 = { ...object };
