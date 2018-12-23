//函数：
/*//无参无返回
function sayHello(){
	console.log("hello");
}
sayHello();
//有参无返回
function say(num){
	console.log(num + 1);
}
say(1);
//有参有返回
function getSum(a,b){
	return a+b;
}
var sum = getSum(1,2);
console.log(sum);
console.log(getSum(1,2));
console.log(say(1));//undefined：表示函数没有返回值*/
//匿名函数
/*var res = function (a,b){
	return a + b;
}
var sum = res(1,2);
console.log(sum);
sum = res;
var xxx = sum(2,2);
console.log(xxx);*/
var xx = "全局变量";
function say(){
	var xx = "局部变量";
	console.log(xx);
}
say();
console.log(xx);