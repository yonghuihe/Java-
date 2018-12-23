//内置对象
//Object
var o = new Object();
o.username = "name";
console.log(o);
console.log(o.constructor);
console.log(o.hasOwnProperty("username"));
console.log(o.hasOwnProperty("password"));

// Date
var d = new Date();
console.log(d.getFullYear() + "年" + d.getMonth() + "月" + d.getDate() + "日"
		+ d.getHours() + "时" + d.getMinutes() + "分" + d.getSeconds() + "秒");
console.log("毫秒：" + d.getTime());

//Math
console.log(Math.random());
//需求：生成一个43-193直接的随机数
console.log(43+parseInt(Math.random()*150));

//String
console.log("学习型详细写".length);

//65-91
var number = 65 + parseInt(Math.random() * 26);
console.log(String.fromCharCode(number));