//对象设计
function User(){}
var u = new User();
u.username = "name";
u.age = "11";
u.say = function(){
	console.log(this.username,this.age);
}
console.log(u);
u.say();
//-----------------------------------------
function Person(username,age){
	this.username = username;
	this.age = age;
	this.sayHello = function (){
		console.log(this.username,this.age);
	}
}
var p = new Person('name',22);
console.log(p);
p.sayHello();