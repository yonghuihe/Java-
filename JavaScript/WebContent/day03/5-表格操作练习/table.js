window.onload = function() {
	var removeAll = document.getElementById("btn_removeAll");
	var btnSubmit = document.getElementById("btn_submit");
	var data = document.getElementById("data");
	
	removeAll.onclick = function(){//给按钮添加点击事件
		data.innerHTML = "";
	}
	
	btnSubmit.onclick = function(){//给按钮添加点击事件
		var trEL =document.createElement("tr")
		
		var usernameEL =document.createElement("td")
		var emailEL =document.createElement("td")
		var telEL =document.createElement("td")
		var delEL =document.createElement("td")
		
		var usernameVal =document.getElementById("username").value;
		var emailVal =document.getElementById("email").value;
		var telVal =document.getElementById("tel").value;
		
		usernameEL.innerHTML = usernameVal;
		emailEL.innerHTML = emailVal;
		telEL.innerHTML = telVal;
		delEL.innerHTML = "<a href=\"javascript:\" onclick=\"delRow(this);\">删除</a>";
		
		trEL.appendChild(usernameEL);
		trEL.appendChild(emailEL);
		trEL.appendChild(telEL);
		trEL.appendChild(delEL);
		
		data.appendChild(trEL);
	}
}
//删除一行：先找到事件源，然后获得td，再获得tr，最后调用让tr的老爸删掉自己
function delRow(src){
	var reEL = src.parentNode.parentNode;
	reEL.parentNode.removeChild(reEL);
}