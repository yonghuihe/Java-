window.onload = function() {
	var btn = document.getElementById("btn");
	var usernameVal = document.getElementById("username").value;
	btn.onclick = function() {
		// 使用ajax的post请求方式，将数据发送给action，成功，跳转到淘宝页面
		var xmlHttpReq = new XMLHttpRequest();
		// post
		xmlHttpReq.open("post", "/ajax/login");
		// 手动设置请求头
		xmlHttpReq.setRequestHeader("Content-Type",
				"application/x-www-form-urlencoded");
		xmlHttpReq.onreadystatechange = function() {
			if (xmlHttpReq.readyState == 4 && xmlHttpReq.status == 200) {
				console.log(xmlHttpReq.responseText);
				// 跳转到淘宝页面
				location.href = "https://www.baidu.com";
			}
		}
		// 传递的参数放到send方法中，格式为 key-value形式
		var data = "username=" + usernameVal;
		xmlHttpReq.send(data);
	}
}