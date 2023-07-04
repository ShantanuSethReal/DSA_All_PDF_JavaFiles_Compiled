let developer1 = { name: "Shantanu" };
let developer2 = developer1;

// console.log(developer1);
// console.log(developer2);

//Now we change 2nd object name property
//Example of shallow copy
let developer3 = { name: "Shantanu" };
let developer4 = developer3;
developer4.name = "Shashank";

// console.log(developer3);
// console.log(developer4);

//So this is a shallow copy as it has the same memory location as that of 1st object
//PARTIAL DEEP COPY METHODS

//Method 1 Object.assign()

let developer5 = { name: "Aman" };
let developer6 = Object.assign({}, developer5);
// console.log(developer5);
// console.log(developer6);
developer6.name = "Vishal";
// console.log(developer5);
// console.log(developer6);

//Disadvantage

let developer7 = { name: "Sarthak", skills: { frontend: "Reactjs", backend: "spring" } };
let developer8 = Object.assign({}, developer7);
developer8.skills.frontend = "nextjs";
// console.log(developer7);
// console.log(developer8);

//Method 2 -ES6 Spread Operator
let developer9 = { name: "Sarthak", skills: { frontend: "Reactjs", backend: "spring" } };
let developer10 = { ...developer9 };
developer10.name = "Ayan";
// console.log(developer9)
// console.log(developer10)
//Disadvantage
developer10.skills.frontend = "nextjs";
// console.log(developer9);
// console.log(developer10);

//Disadvantages of M1,M2 is it doesn't work after one level of copying
//Method 3

let developer11 = {
  name: "Hero",
  skills: "Frontend",
  address: {
    street: 46,
    state: "Chhattisgarh",
  },
  calculateAge: function () {
    return 30;
  },
  joiningDate: new Date(),
};
let developer12 = JSON.parse(JSON.stringify(developer11));
// console.log(developer11);
// console.log(developer12);

//Disadvantages of M3 -1.)function gets lost in this,2.) also type of key value pair changes
// console.log(typeof(developer11.joiningDate));
// console.log(typeof(developer12.joiningDate));
//Method 4 Loadash
// const _ = require("lodash");
let developer13 = {
  name: "Hero",
  skills: "Frontend",
  address: {
    street: 46,
    state: "Chhattisgarh",
  },
  calculateAge: function () {
    return 30;
  },
  joiningDate: new Date(),
};
// let developer14 = _.cloneDeep(developer13);
// console.log(developer13);
// console.log(developer14);
