//存储生成的字母
var codeArr = [];
//文档加载完毕之后执行
window.onload = function() {
	//获取开始游戏的按钮
	var btn = document.getElementById("start");
	btn.onclick = function() {
		//禁用开始按钮
		btn.disabled = true;
		//开始游戏
		startGame();
	};
};

function startGame() {
	// 循环生成字母
	setInterval(function() {
		var spanEl = createCode();
		document.body.appendChild(spanEl);// 加入到页面中
		codeArr.push(spanEl);// 把生成的字母存储起来
	}, 500);
	// 字母往下走
	setInterval(function() {
		for (i = 0; i < codeArr.length; i++) {
			var spanEl = codeArr[i];
			var height = document.documentElement.clientHeight;
			var old = parseInt(spanEl.style.top);
			if (old < height - 60) {
				spanEl.style.top = parseInt(spanEl.style.top) + 20 + "px";
			} else {
				// 从页面和数组中删除
				spanEl.parentNode.removeChild(spanEl);
				codeArr.splice(i, 1);
			}
		}
	}, 500);
	// 处理打字-->监听键盘的按下事件
	document.body.onkeydown = function(e) {
		var char = String.fromCharCode(e.keyCode);
		for (i = 0; i < codeArr.length; i++) {
			if (char == codeArr[i].innerHTML) {
				codeArr[i].parentNode.removeChild(codeArr[i]);
				codeArr.splice(i, 1);
				var scoreEl = document.getElementById("score");
				scoreEl.innerHTML = parseInt(scoreEl.innerHTML) + 10;
				return;
			}
		}
	};
}
//生成字母的函数
function createCode() {
	var width = parseInt(Math.random()
			* (document.documentElement.clientWidth - 60));

	var spanEl = document.createElement("span");
	spanEl.className = "code"
	spanEl.style.left = width + "px";
	spanEl.style.top = "50px";
	spanEl.innerHTML = String.fromCharCode(65 + parseInt(Math.random() * 26));
	return spanEl;
}