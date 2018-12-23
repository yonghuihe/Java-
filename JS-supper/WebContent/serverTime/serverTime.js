window.onload = function() {
	document.getElementById("btn").onclick = function() {
		//发送ajax请求，获取数据
		var xmlHttpReq = new XMLHttpRequest();
		//解决浏览器缓存问题：使用当前时间的毫秒值
		xmlHttpReq.open("post", "/ajax/serverTime?"+new Date().getTime(), true);
		xmlHttpReq.onreadystatechange = function (){
			//监听当前xmlHttpReq的状态，正常情况下获取数据
			if (xmlHttpReq.readyState == 4 && xmlHttpReq.status == "200") {
				document.getElementById("sp").innerHTML = xmlHttpReq.responseText;
			}
		};
		xmlHttpReq.send();
	}
}
