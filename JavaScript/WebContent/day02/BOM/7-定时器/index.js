//定时器，3秒后执行一次
/*setTimeout(function(){
	location.href="https://www.taobao.com/";
}, 3000)*/
//没一秒执行一次
setInterval(function(){
	var ele =document.getElementById("name")
	ele.innerHTML = ele.innerHTML-1;
	if (ele.innerHTML == 0){
		location.href="https://www.taobao.com/";
	}
}, 1000)