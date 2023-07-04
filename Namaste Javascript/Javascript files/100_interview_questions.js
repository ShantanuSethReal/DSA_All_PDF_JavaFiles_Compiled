// Top 100 Interview Questions JavaScript Code Step By Step
//1
let a = [];
let b = [];
console.log(a == b);
console.log(a === b);

//2
let a = [];
let b = a;
console.log(a == b);
console.log(a === b);

//3
let a = [20];
let b = [20];
console.log(a[0] == b[0]);
console.log(a[0] === b[0]);

//4
const a=[1,2,3,4];
const b={name:"Shantanu"}
console.log(...a)

//5
console.log(typeof NaN)

//6
let data=10--10;
console.log(data)

//7
const set=new Set([1,1,2,3,4]);
console.log(set)

//8
let obj={name:"Shantanu"};
console.log(delete obj.name)

//9
let obj={name:"Shantanu"};
console.log(delete obj)

//10
const arr=["Chennai","Punjab","Delhi"]
let [y]=arr;
console.log(y)
let [a,b]=arr;
console.log(a,b)


//11
const arr=["Chennai","Punjab","Delhi"]
let [c,,d]=arr
console.log(c,d)

//12
const data={name:"Shantanu",class:"XII",sec: "F"}
console.log(data["name"])
const {name}=data;
const {age}=data;
console.log(name,age)

//13
let data1={name1:"Shantanu",class1:"XII",sec1: "F"}
let data2={name2:"Akshay",class2:"XII",sec2: "E"}
let newobj={...data1,...data2}
console.log(newobj)
console.log(...data1,...data2)

//14
let data1={name1:"Shantanu",class1:"XII",sec1: "F"}
let data2={name2:"Akshay",class2:"XII",sec2: "E"}
let newobj={data1,...data2}
console.log(newobj)

//15
let data1={name:"Shantanu",class1:"XII",sec1: "F"}
let data2={name:"Akshay",class2:"XII",sec2: "E"}
let newobj={data1,...data2}
console.log(newobj)

//16
const name="Anil";
console.log(name())

//17
const exp=false||{}||null
console.log(exp);

//18
const exp=null||false||''
console.log(exp);

//19
const exp=[]||0||true
console.log(exp);

//20
console.log(Promise.resolve(10));

//21
JSON.parse()
JSON.stringify()

//22
let name="Seth";

function getName(){
    console.log(name);
    let name="Shantanu";
}
getName();

//23
let name="Seth";

function getName(){
    console.log(name);
}
getName();

//24
console.log(`${(x => x)("I love")} to program`)

//25-Mcq
function getSum(x,y,z){
    return x+y+z;
}
// 1.return getSum(...1,2,3)
// 2.return getSum([...[1,2,3]])
// 3.return getSum(...[1,2,3])
// 4.return getSum([1,2,3])

//26
const str="Hello World";
console.log(!typeof str==="object")
console.log(!typeof str==="string")

//27
const name="Subscribe"
const age=20;
console.log(isNaN(name))
console.log(isNaN(age))

//28
let person={name: "SuryaKumar"}
Object.seal(person)
// person="Hello";
person.age=29;
console.log(person)

//29
let data=[1,2,3,4,5];
console.log(data.shift())


//30
let data=[1,2,3,4,5];
console.log(data.pop())

//31
let a=30;
console.log(a%2)

//32
let data={
    name:"Anil"
}
delete data.name
console.log(data)

//33
let val="true";
console.log(typeof !(!(val)))

//34
//map,forEach difference

//35
let data=["a","b","c"];
delete data[1];
console.log(data);

//36
let data=["a","b","c"];
delete data[1];
console.log(data.length);

//37
let arr1=[1,2,3];
let arr2=[11,21,31];
let arr3=[...arr1,...arr2];
console.log(arr3)

//38
let arr1=[1,2,3,11,21];
let arr2=[11,21,31];
let arr3=[...arr1,...arr2];
console.log(arr3)

//39
let n=3***3;
console.log(n);

//40
let a=1;
setTimeout(() => {
    console.log(a)
}, 0);
a=10;

//41
let a=1;
let A=2;
console.log(a,A);

//42
let A10="hello";
let 10A="hell";
console.log(A10,10A);

//43
let a="like";
let b=`like`;
console.log(a===b)

//44
let a=1;
let c=2;
console.log(--c==a)

//45
let p=1;
let q=1;
let r=2;
console.log(p==q==--r)
//46
console.log(3*3)
console.log(3**3)
console.log(3***3)

//47
console.log(a)
var a;

//48
console.log(h);

//49
console.log([[[[[]]]]])

//50
console.log(navigator.platform)

//51
let for=100;
console.log(for)//Reserved keyword

//52
function get(){
    console.log(age)
    console.log(city)

    var age=10;
    let city="poland"
}
get();

//53-var
for (var index = 0; index < 3; index++) {
    setTimeout(()=>{console.log(index)},0);
}

//54-let
for (let index = 0; index < 3; index++) {
    setTimeout(()=>{console.log(index)},0);
}

//55
console.log(+true);
console.log(typeof +true);

//56
console.log(!"anil");
console.log(typeof ("anil"));

//57
let data="size";
let obj={
    size: "five"
}
console.log(obj[data]);
console.log(obj["size"])
console.log(obj.size)
console.log(obj.data)

//58
let obj1={
    city:"Bhilai"
}
let obj2=obj1;
obj2.city="Durg";
console.log(obj2,obj1)

//59
var x;
var x=10;
console.log(x)

//60
var x;
let x=10;
console.log(x)
 
//61
let a=9;
let b=new Number(9);
console.log(a==b)
console.log(a===b)
 
//62
let city;
ctiy={};
console.log(ctiy)
 
//63
function fruit(){
    console.log("apple")
}
fruit.names="Chikoo"
fruit();
 
//64
 function sum(x,y){
    return x+y;
 }
 console.log(sum(1,"2"))

//65
 let n=0;
 console.log(n++);
 console.log(++n);
 console.log(n)

//66
function getAge(...args){
    console.log(typeof args)
}
getAge(21)
 
//67
 function getAge(args){
    'use strict'
    k=3;
    console.log(k)
}
getAge(21)

//68
 const s=eval("10*10+5")
 console.log(s)

//69 
//sessionStorage()

//70
const obj={
    1:"a",
    2:"b",
    3:"c"
}
console.log(obj.hasOwnProperty("1"))
console.log(obj.hasOwnProperty(1))

//71
const obj={
    one:"a",
    two:"b",
    one:"c"
}
console.log(obj)
//72
//continue in for loop

//73
const foo=()=> console.log("One")
const bar=()=> setTimeOut(()=>console.log("Two"),0)
const tag=()=> console.log("Three")
foo()
bar()
tag();

//74
{/* <div onclick="console.log(" 1")">
        <div onclick="console.log("2")">
            <button onclick="console.log("3")">Click Me
                <button/>
        </div>
    </div>  */}

//75
function getprops(age){
    console.log(`${this.name} has age ${age}`)
}
const obj={
    name: "Shantanu"
}
console.log(getprops().call(obj,21))
console.log(getprops().bind(obj,21))

//76
function sayHi(){
    return (()=>0)()
}
console.log(typeof sayHi)

//77
function sayHi(){
    return (()=>0)
}
console.log(typeof sayHi)

//78
console.log(typeof typeof 2)

//79
const num=[1,3,5];
num[9]=19;
console.log(num)

//80
const num=[1,3,5];
num[9]=num;
console.log(num)

//81
//Everything in js is primitive or object

//82
console.log(!!null)
console.log(!!'')
console.log(!!1)

//83
//setInterval return id
console.log(setInterval(() => {
    console.log("Hello")
}, 1000))

//84
console.log(..."shantanu")

//85
const p1=new Promise((resolve,reject)=>{
    setTimeout(() => {
        resolve("p1")
    }, 1000);
})
const p2=new Promise((resolve,reject)=>{
    setTimeout(() => {
        resolve("p2")
    }, 2000);
})
console.log(Promise.race({p1,p2}).then((data)=>{console.log(data)}))

//86
let obj={age: 21};
const arr=[obj];
obj=null;
console.log(arr)

//87
// for in loop obj

//88
const str=3+4+"5"
console.log(typeof str,str)

//89
console.log(typeof 3+4+"5")

//90
console.log(typeof (3+4++"5")

//91
console.log([]==[]])
//92
//.map()

//93
function getName(member){
    member.name="Sarah";
}
let person={
    name:"Victor"
}
getName(person)
console.log(person)
//94
//95
//96
//97
//98
//99
//100