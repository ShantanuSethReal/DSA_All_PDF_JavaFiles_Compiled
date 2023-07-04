let obj={
    name:"Bruce"
}
// console.log(obj)
//Shallow copy
let user=Object.assign({},obj);
// let user={...obj};
// let user=obj;
user.name="wayne";
// console.log(obj,user)
let obj1 = {
  name: "Bruce",

  address:{
    city:"Bhilai",
    state:"CG"
  }
};
// console.log(obj1);
// let user1=Object.assign({},obj1);
let user1={...obj1}
user1.address.city="Raipur";
// console.log(user1,obj1)
let user2=JSON.parse(JSON.stringify(obj1));
console.log(user2)
user2.address.city="Bilaspur"
// console.log(user2,obj1)
//Deep copy does not work with functions in obj