window.onload = function() {
	var province = document.getElementById("province");
	var city = document.getElementById("city");

	// 发送ajax请求，获取省份信息,拼接到province中
	var xmlHttpReq = new XMLHttpRequest();
	xmlHttpReq.open("post", "/ajax/link_getProvice");
	xmlHttpReq.onreadystatechange = function() {
		if (xmlHttpReq.readyState == 4 && xmlHttpReq.status == 200) {
			province.innerHTML += xmlHttpReq.responseText;
		}
	}
	xmlHttpReq.send();
	// 给province添加change事件，当选择province后，发送ajax请求，获取对应的city
	province.onchange = function() {
		city.innerHTML = "<option value=\"-1\">--请选择城市--</option>";

		xmlHttpReq = new XMLHttpRequest();
		xmlHttpReq.open("post", "/ajax/link_getCityById");
		xmlHttpReq.setRequestHeader("Content-Type",
				"application/x-www-form-urlencoded");
		xmlHttpReq.onreadystatechange = function() {
			if (xmlHttpReq.readyState == 4 && xmlHttpReq.status == 200) {
				city.innerHTML += xmlHttpReq.responseText;
			}
		}
		var data = "pid=" + this.value;
		xmlHttpReq.send(data);
	}
}
