function expensive() {
  console.log("Expensive function called");
}
const betterExpensive = throttle(expensive, 3000);
function throttle(fn, limit) {
  let flag = true;
  return function () {
    let context = this;
    let args = arguments;
    if (flag == true) {
      fn.apply(context, args);
      flag = false;
      setTimeout(() => {
        flag = true;
      }, limit);
    }
  };
}
