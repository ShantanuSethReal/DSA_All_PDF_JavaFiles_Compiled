let student = {
  name: "Peter",
  sname: "Parker",
  getName: function () {
    return `${this.name} ${this.sname}`;
  },
};
let teacher = {
  name: "Jarvis",
  sname: "Patel",
  getName: function () {
    return `${this.name} ${this.sname}`;
  },
};
console.log(student.getName());
console.log(teacher.getName());
console.log(student.getName.call(teacher));
function getUsername() {
  return `${this.name} ${this.sname}`;
}
console.log(getUsername.call(student))
console.log(getUsername.call(teacher))
function chooseSub(sub,sub2){
    return {sub,sub2};
}
console.log(chooseSub.call(teacher,"Maths","English"))
console.log(chooseSub.apply(teacher,["Maths","English"]))
const f1=chooseSub.bind(teacher,"Maths","English");
console.log(f1)