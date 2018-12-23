window.onload = function() {
	var province = document.getElementById("province");
	var city = document.getElementById("city");
	province.innerHTML = "<option value=\"-1\">---请选择省份---</option>";
	// 发送ajax请求，获取省份数据
	var xmlHttpReq = new XMLHttpRequest();
	xmlHttpReq.open("get", "/ajax/link_getProvice");
	xmlHttpReq.onreadystatechange = function() {
		if (xmlHttpReq.readyState == 4 && xmlHttpReq.status == 200) {
			var doc = xmlHttpReq.responseXML;
			// dom解析
			var dates = doc.getElementsByTagName("date");
			for (var i = 0; i < dates.length; i++) {
				var op = "<option value='" + dates[i].id + "'>"
						+ dates[i].innerHTML + "</option>";
				province.innerHTML += op;
			}
		}
	}
	xmlHttpReq.send();

	// 当province数据变化，发送ajax请求，获取city数据，并显示在id=city的select中
	province.onchange = function() {
		city.innerHTML = "<option value=\"-1\">---请选择城市---</option>";
		if (this.value < 0) {
			return;
		}
		// 发送ajax请求，获取省份数据
		var xmlHttpReq = new XMLHttpRequest();
		xmlHttpReq.open("post", "/ajax/link_getCityById");
		xmlHttpReq.setRequestHeader("Content-Type",
				"application/x-www-form-urlencoded");
		xmlHttpReq.onreadystatechange = function() {
			if (xmlHttpReq.readyState == 4 && xmlHttpReq.status == 200) {
				var doc = xmlHttpReq.responseXML;
				// dom解析
				var dates = doc.getElementsByTagName("date");
				for (var i = 0; i < dates.length; i++) {
					var op = "<option value='" + dates[i].id + "'>"
							+ dates[i].innerHTML + "</option>";
					city.innerHTML += op;
				}
			}
		}
		var data = "pid=" + this.value;
		xmlHttpReq.send(data);
	}
}