$(function(){
	//需求:获取DIV元素对象
	//DOM
	var domObj = document.getElementById("detail");
	//jQuery
	var jQueryObject=$("#detail");
	
	console.log(domObj);
	console.log(jQueryObject);
	//DOM对象转换为jQuery对象:$(DOM对象)
	console.log($(domObj));
	//jQuery对象转换为DOM对象:jQuery对象[index]或jQuery.get[index]
	console.log(jQueryObject[0]);
	console.log(jQueryObject.get(0));
	//获取DIV的文本的内容
	console.log(domObj.innerHTML);
	console.log(jQueryObject.html());
	console.log($(domObj).html());
})

/*$(function() {
	$("#btn_debug2").click(function(){
		$("#detail").toggle(5000);
	});
})*/

/*window.onload = function(){
	document.getElementById("btn_debug1").onclick = function(){
		var divEl = document.getElementById("detail");
		console.debug(divEl.style.display);
		if (divEl.style.display) {//当隐藏时
			divEl.style.display = "";
		} else {
			divEl.style.display = "none";//当显示时
		}
	}
}*/

//jQuery
/*$ (function(){
	//alert(1);
	//获取元素文本内容
	console.log($("#div1").text());
	//设置元素文本内容
	$("#div1").text("bangbangda") ;
})*/
/*window.onload = function() {
	var text = document.getElementById("div1").innerHTML;
	console.log(text);
	//设置元素文本的内容
	document.getElementById("div1").innerHTML="棒棒哒";
};*/
