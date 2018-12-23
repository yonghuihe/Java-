function show(src) {
    document.getElementById("div").innerHTML = "方式1";
    console.log(src);//事件源可以通过参数传递给响应函数
    console.log(this);//当前函数是window对象调用的
    console.log("按钮被点击啦");
}

window.onload = function () {
    //方式2:在JS中使用 元素对象.onxx = 响应函数
    var btn1 = document.getElementById("btn1");
    btn1.onclick = function (e) {
        document.getElementById("div").innerHTML = "方式2";
        console.log(e);//表示事件对象
        console.log(this);//事件源
        console.log("方式2:我被点击了");
    };

    //方式3:在JS中给对象添加监听器
    var btn2 = document.getElementById("btn2");

    addListener(btn2, "click", function (e) {
        console.log(this);//事件源
        console.log(e);   //事件对象
        document.getElementById("div").innerHTML = "方式3";
    });
};

//给事件源添加监听器
function addListener(src, type, fn) {
    if (src.addEventListener) { //w3c ie9+
        src.addEventListener(type, fn);
    } else { //ie9-
        src.attachEvent("on"+type, fn);
    }
}

