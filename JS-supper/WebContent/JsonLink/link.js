window.onload = function() {
	var province = document.getElementById("province");
	var city = document.getElementById("city");

	// 发送ajax请求，获取省份信息,拼接到province中
	var xmlHttpReq = new XMLHttpRequest();
	xmlHttpReq.open("post", "/ajax/link_getProvice");
	xmlHttpReq.onreadystatechange = function() {
		if (xmlHttpReq.readyState == 4 && xmlHttpReq.status == 200) {
			var provinces = eval("("+xmlHttpReq.responseText+")");
			for (var i = 0; i < provinces.length; i++) {
				province.innerHTML += "<option value=\"" + provinces[i].id
						+ "\">" + provinces[i].name + "</option>";
			}
		}
	}
	xmlHttpReq.send();
	// 给province添加change事件，当选择province后，发送ajax请求，获取对应的city
	province.onchange = function() {
		city.innerHTML = "<option value=\"-1\">--请选择城市--</option>";
		if(this.value < 0){
			return;
		}

		xmlHttpReq = new XMLHttpRequest();
		xmlHttpReq.open("post", "/ajax/link_getCityById");
		xmlHttpReq.setRequestHeader("Content-Type",
				"application/x-www-form-urlencoded");
		xmlHttpReq.onreadystatechange = function() {
			if (xmlHttpReq.readyState == 4 && xmlHttpReq.status == 200) {
				var cities = eval("("+xmlHttpReq.responseText+")");
				for (var i = 0; i < cities.length; i++) {
					city.innerHTML += "<option value=\"" + cities[i].id
							+ "\">" + cities[i].name + "</option>";
				}
			}
		}
		var data = "pid=" + this.value;
		xmlHttpReq.send(data);
	}
}
