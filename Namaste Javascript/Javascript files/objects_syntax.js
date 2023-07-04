//What is object;
//How to create object;
let obj1 = {};
let obj2 = new Object();
console.log(obj1, obj2);
obj1.name="bruce";
obj2.name="wayne"
console.log(obj1, obj2);
//Objects with const
//Shorthand property

const x={
    val: 10
}
console.log(x)
x.val=20;
console.log(x)

let key="address"
let phone=7972068299;
let obj={
    name:"Shantanu",
    age: 27,
    isDeveloper: true,
    getData: function(){
        return this.city
    },
    inner:{
        innerobj_name:"Seth",
        innerobj_city:"Bhilai"
    },
    ['street']: 46,
    [key]: "5B street 46",
    phone
}
console.log(obj)
delete obj.age;
console.log(obj)
obj.city="Durg"
console.log(obj.getData())
obj['pin code']=490006
console.log(obj)
console.log("street" in obj)

for(item in obj){
    console.log(`Item is ${item} and Value is ${obj[item]}`)
}
