document.querySelector("#grandparent").addEventListener(
  "click",
  () => {
    console.log("GrandParent Clicked");
  },
  false
);

document.querySelector("#parent").addEventListener(
  "click",
  (e) => {
    console.log("Parent Clicked");
    // e.stopPropagation();
  },
  false
);

document.querySelector("#child").addEventListener(
  "click",
  () => {
    console.log("Child Clicked");
  },
  false
);
//EVENT BUBBLING FROM BOTTOM TO TOP
//Name few events that do not bubble..
// Set True for event capturing

document.querySelector("#grandparent").addEventListener("click", func, false);

document.querySelector("#parent").addEventListener("click", func, false);

document.querySelector("#child").addEventListener("click", func, false);
function func(e) {
  console.log(e.currentTarget.tagName + " " + e.target.tagName + " " + this.tagName);
}
document.querySelector("#grandparent").addEventListener(
  "click",
  () => {
    console.log("GrandParent Clicked");
  },
  true
);

document.querySelector("#parent").addEventListener(
  "click",
  (e) => {
    console.log("Parent Clicked");
    // e.stopPropagation();
  },
  true
);

document.querySelector("#child").addEventListener(
  "click",
  () => {
    console.log("Child Clicked");
  },
  true
);
document.querySelector(".products").addEventListener("click",(e)=>{
console.log(e)
console.log(e.target)
console.log(e.target.tagName)
console.log(e.target.className)
console.log(e.currentTarget.tagName)
})
//E.target vs E.currentTarget
//How do you stop capturing/bubbling

//Event delegation