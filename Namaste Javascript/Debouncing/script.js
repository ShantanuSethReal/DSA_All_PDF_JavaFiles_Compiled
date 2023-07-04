console.log("Hello !! Welcome to  Debouncing Tutorial");
let count = 0;
function getData() {
  console.log("Fetching data for the " + count + " no of times::");
  count++;
}
const outerFunc = debounce(getData, 300);
function debounce(fn, d) {
  let timer;
  return function () {
    let context = this;
    let args = arguments;
    clearTimeout(timer);
    timer = setTimeout(() => {
      getData.apply(context, args);
    }, d);
  };
}
