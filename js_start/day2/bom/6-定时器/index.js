
//设置定时器,3秒后执行1次
setTimeout(function () {
    location.href = "newWin.html";
}, 3000);


//每一秒执行1次
setInterval(function () {
    var sp = document.getElementById("num");
    sp.innerHTML = sp.innerHTML - 1;
    if (sp.innerHTML == 0) {
        location.href = "newWin.html";
    }
} ,1000);
