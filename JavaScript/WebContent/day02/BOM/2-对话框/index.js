function show(){
	alert("xxx");
}
function askMe(){
	var con=confirm("确认要删除吗");
	if(con){
		console.log("删除成功");
	}
}
function showMsg(){
	var p=prompt("请输入尊姓大名");
	if(p){
		console.log(p + " 能活："+ parseInt(Math.random() * 100));
	}
}