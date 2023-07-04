document.querySelector("#child").addEventListener(
  "click",
  () => {
    console.log("Child Clicked");
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

document.querySelector("#grandparent").addEventListener(
  "click",
  () => {
    console.log("GrandParent Clicked");
  },
  false
);
//Set True for event capturing
