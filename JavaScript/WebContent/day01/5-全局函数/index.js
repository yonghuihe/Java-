//全局函数
var test = "http://localhost:8080/index.jsp?username=逍遥";

var encode=encodeURI(test);
console.log(encode);
console.log(decodeURI(encode));

var component=encodeURIComponent(test)
console.log(component);
console.log(decodeURIComponent(component));

var test2 = "11.11";
console.log(parseInt(test2));
console.log(parseFloat(test2));

console.log(isNaN(""));
console.log(isNaN(undefined));
console.log(isNaN(NaN));

var str = "alert('你好');";
eval(str);