//使用JSON表示单个对象(Employee),看做是一个Map<String,Object>
var emp1 = {
	id:1,
	name:'will',
	age:17,
	hobby:['java','js','music'],
	dept:{
		did:10,
		dname:'教学部'
	}
};
//使用JSON表示多个对象(数组),看做是一个List<Map<String,Object>>
var emps = [emp1,emp1];

//console.debug(emp1.toSource());
//---------------------
//console.debug(emp1);
//console.debug(emp1.name);
//console.debug(emp1.age);
//console.debug(emp1.hobby[1]);
//console.debug(emp1.dept.dname);
//把字符串转换为JSON 
var jsonString = "{id:123,name:'Lily'}";
var jsonObject = eval("("+jsonString+")");
console.debug(jsonObject);