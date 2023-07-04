//***************THIS*********************** */

//Implicit using . operator , Explicit using call bind apply
//This target parent of function
let a = 5;
this.b = 9;
// console.log(this,this.a, b);

function myFunction() {
  console.log(this);
  console.log(this.a);
}
// myFunction();

const myFun = () => {
  console.log(this);
  console.log(this.a);
};
// myFun();

let user = {
  name: "Piyush",
  age: 24,
  getDetails() {
    console.log(this,this.name); //Piyush
  },
};
// user.getDetails();

let user1 = {
  name: "Piyush",
  age: 24,
  childObj: {
    newName: "Roadside Coder",
    getDetails() {
      console.log(this.newName, "and", this.name);
    },
  },
};
// console.log(user1.childObj.getDetails());
//This for arrow function comes from its parent function****
let user2 = {
  name: "Piyush",
  age: 24,
  getDetails: () => {
    console.log(this,this.name);
  },
};
// user2.getDetails();

let user3 = {
  name: "Piyush",
  age: 24,
  getDetails() {
    const nestedArrow = () => console.log(this.name); //Piyush
    nestedArrow();
  },
};
// user3.getDetails();

class user5 {
  constructor(n) {
    this.name = n;
  }
  getName() {
    console.log(this.name);
  }
}
const juser = new user5("Shantanu");
// console.log(juser)
// juser.getName();

const user6 = {
  firstName: "Piyush!",
  getName() {
    const firstName = "Vishal!";
    return this.firstName;
  },
};
// console.log(user6.getName());

function makeUser() {
  return {
    name: "John",
    ref: this,
  };
}

let user7 = makeUser();
// console.log(user7.ref.name);
// console.log(user7);

function makeUser() {
  return {
    name: "Piyush Agarwal",
    ref() {
      return this;
    },
  };
}

let user8 = makeUser();
// console.log(user8.ref().name);

const user9 = {
  name: "Shan",
  logMessage() {
    console.log(this.name);
  },
};
// setTimeout(() => {
//   user9.logMessage();
// }, 1000);
// setTimeout(function () {
//   user9.logMessage();
// }, 1000);

const user10 = {
  name: "Piyush",
  greet() {
    return ` Hello, ${this.name}!`;
  },
  farewell: () => {
    return `Goodbye, ${this.name}!`;
  },
};
// console.log(user10.greet());
// console.log(user10.farewell());
let calculator = {
  sum() {
    return this.a + this.b;
  },

  mul() {
    return this.a * this.b;
  },

  read() {
    this.a = +prompt("a?", 0);
    this.b = +prompt("b?", 0);
  },
};

// calculator.read();
// console.log(calculator.sum());
// console.log(calculator.mul());

var length = 4;
function callback() {
  console.log(this.length);
}
const object = {
  length: 5,
  method(callback) {
    callback();
  },
};
// object.method(callback, 1, 2);

var length = 4;
function callback() {
  console.log(this.length);
}
const object1 = {
  length: 5,
  method() {
    console.log(arguments);
    arguments[0]();
  },
};
// object1.method(callback, 1, 2);
var calc = {
  total: 0,
  add(a) {
    this.total += a;
    return this;
  },
  subtract(a) {
    this.total -= a;
    return this;
  },
  multiply(a) {
    this.total *= a;
    return this;
  },
};
const result = calc.add(10).multiply(5).subtract(8).add(9);
// console.log(result);
