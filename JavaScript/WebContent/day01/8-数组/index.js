//数组
//创建数组的三种方式
//var arr = new Array();
//var arr = new Array("貂蝉","杨玉环","西施");
var arr = ["貂蝉","杨玉环","西施"];
//length属性
console.log(arr.length);
//操作数组的方式：索引
//arr[0] = "王尼玛";
//arr[10] = "王尼玛";
//数组对象的方法
//arr.pop();
//arr.push("stef");
//arr.reverse();
//arr.shift();
//arr.unshift("stef","will");
arr.splice(1, 1 , "stef")

/*for(var i = 0; i < arr.length;i++){
	console.log(arr[i]);
}
*/

for(var obj in arr){
	console.log(obj,arr[obj]);
}

//console.log(arr);s