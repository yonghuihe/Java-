window.onload = function() {
	var d2 = document.getElementById("d2");
	console.log(d2.style);
	console.log(d2.style.color);
	console.log(d2.style["background-color"]);
	d2.style.backgroundColor = "black";
	console.log(d2.style.backgroundColor);
	console.log(d2.style["font-size"]);
	d2.style.fontSize = "25px";
	console.log(d2.style.fontSize);

	var d1 = document.getElementById("d1");
	console.log(d1);
	console.log(d1.className);
	d1.className="";
	
	
	var check = document.getElementById("check");
	console.log(check);
	check.checked = "11";//选中
	check.checked = "";	//不选中
	check.checked = true;//选中
	check.checked = false;//不选中
	
	
	var tx = document.getElementById("tx");
	console.log(tx);
	// 获取原始属性
	console.log(tx.name);
	console.log(tx["name"]);
	// 修改原始属性值
	// tx.name = "newName";
	tx["name"] = "newName";

	// 获取自定义属性
	console.log(tx.getAttribute("xx"));
	// 修改自定义属性值
	tx.setAttribute("xx", "newXx");

}