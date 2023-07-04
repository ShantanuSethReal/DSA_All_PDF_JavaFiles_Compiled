const btn = document.querySelector(".increment_btn");
const btnPress = document.querySelector(".increment_pressed");
const count = document.querySelector(".increment_count");

var pressed_count = 0;
var triggered_count = 0;

function myDebounce(cb, d) {
  let timer;
  return function (...args) {
    if (timer) {
      clearTimeout(timer);
    }
    timer = setTimeout(() => {
      cb(...args);
    }, d);
  };
}
function myThrottle(cb,d){
    let last=0;
    return function(...args){
        let now=new Date().getTime();
        if(now-last<d){return;}
        last=now;
        cb(...args);
    }

}
const debounceCount = myDebounce(() => {
  triggered_count += 1;
  count.innerHTML = triggered_count;
}, 800);
const throttleCount = myThrottle(() => {
  triggered_count += 1;
  count.innerHTML = triggered_count;
}, 800);
btn.addEventListener("click", () => {
  btnPress.innerHTML = ++pressed_count;
//   debounceCount(count);
  throttleCount(count);
});
