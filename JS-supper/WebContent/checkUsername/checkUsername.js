window.onload = function (){
	document.getElementById("checkUsername").onblur = function(){
		//发送ajax请求，将this.value发送给Action，检查用户名是否存在，并接受返回的数据
		var xmlHttpReq = new XMLHttpRequest();
		xmlHttpReq.open("get", "/ajax/checkUsername?username=" + this.value);
		xmlHttpReq.onreadystatechange = function (){
			if(xmlHttpReq.readyState == 4 && xmlHttpReq.status == 200){
				document.getElementById("showMag").innerHTML = xmlHttpReq.responseText;
			}
		}
		xmlHttpReq.send();
	}
}