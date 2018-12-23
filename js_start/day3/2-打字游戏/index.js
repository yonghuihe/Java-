//存储生成的字母
var codeArr = [];

//文档加载完毕执行
window.onload = function () {
    //获取开始游戏的按钮
    document.getElementById("startGame").onclick = startGame;
};

//开始游戏的函数
function startGame() {
    //禁用开始按钮
    this.disabled = true;

    var score = document.getElementById("score");
    //循环生成字母
    setInterval(function () {
        var ch = createCharCode();
        document.body.appendChild(ch);//加入到页面中
        codeArr.push(ch);//把生成的字母存储起来
    }, 500);
    //字母往下走
    setInterval(function () {
        var height = document.documentElement.clientHeight - 60;
        for (var i = 0; i < codeArr.length; i++) {
            var top = parseInt(codeArr[i].style.top);
            if (top < height) {
                codeArr[i].style.top = top + 20 + "px";
            } else {
                //从页面和数组中删除
                codeArr[i].parentNode.removeChild(codeArr[i]);
                codeArr.splice(i, 1);
            }
        }
    }, 500);
    //处理打字 -> 监听键盘的按下事件
    document.onkeydown = function (e) {
        var ch = String.fromCharCode(e.keyCode);
        for (var i = 0; i < codeArr.length; i++) {
            if (ch == codeArr[i].innerHTML) { //按对了
                //从页面和数组中删除
                codeArr[i].parentNode.removeChild(codeArr[i]);
                codeArr.splice(i, 1);
                //加分
                score.innerHTML = parseInt(score.innerHTML) + 10;
            }
        }
    };
}

//生成字母的函数
function createCharCode() {
    //<span style="left:10px;top:50px;width:20px;position:absolute;
    //font-weight:bold;background-color:orange;text-align:center;">A</span>
    var sp = document.createElement("span");
    //设置sp元素的style属性
    var width = parseInt(Math.random() * (document.documentElement.clientWidth - 60));
    sp.style.left = width+"px"; //设置字母的x位置
    sp.style.top = "50px";
    sp.style.width = "20px";
    sp.style.position = "absolute";
    sp.style.fontWeight = "bold";
    sp.style.backgroundColor = "orange";
    sp.style.textAlign = "center";
    //设置sp的字母
    var ch = String.fromCharCode(65 + parseInt(Math.random() * 26));
    sp.innerHTML = ch;
    return sp;
}
