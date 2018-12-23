function show(src) {
	console.log(src);// 事件源
	console.log(this);// window对象
}

window.onload = function() {
	//方式2：
	var byId = document.getElementById("id");
	byId.onclick = function(e) {
		console.log(e);//表示事件对象
		console.log(this);//事件源
	}
	
	//方式3：
	var d3 = document.getElementById("d3");
	
	addListener(d3, "click", function(){	
		document.getElementById("div").innerHTML = "方式3";
	})
}

//浏览器兼容性处理
function addListener(src,type,fn){
	if(src.addEventListener){
		d3.addEventListener(type, fn);//w3c、ie9+
	} else {
		d3.attachEvent("on"+type, fn);//ie9-
	}
}