//文档加载完毕再执行
window.onload = function () {
    var data = document.getElementById("data");

    //删除所有
    document.getElementById("btn_removeAll").onclick = function () {
        data.innerHTML = "";
    };

    //添加一行数据
    document.getElementById("btn_submit").onclick = function () {
        var usernameVal = document.getElementById("username").value;
        var emailVal = document.getElementById("email").value;
        var telVal = document.getElementById("tel").value;
        //创建一个tr和4个td
        var trEl = document.createElement("tr");
        var usernameEl = document.createElement("td");
        var emailEl = document.createElement("td");
        var telEl = document.createElement("td");
        var delEl = document.createElement("td");
        //给4个td设置内容
        usernameEl.innerHTML = usernameVal;
        emailEl.innerHTML = emailVal;
        telEl.innerHTML = telVal;
        delEl.innerHTML = "<a href=\"javascript:\" onclick=\"delRow(this);\">删除</a>";
        //设置父子关系
        trEl.appendChild(usernameEl);
        trEl.appendChild(emailEl);
        trEl.appendChild(telEl);
        trEl.appendChild(delEl);
        data.appendChild(trEl);
    };
};
//删除单行
function delRow(src) {
    //事件源和tr是爷孙关系
    var trEl = src.parentNode.parentNode;
    trEl.parentNode.removeChild(trEl);
}
