
function askMe() {
    if(confirm("确定要删除吗?")) {
        console.log("删除成功!");
    }
}

function showMsg() {
    var username = prompt("请输入尊姓大名");
    if(username) {
        var age = parseInt(Math.random() * 100);
        console.log(username, "能活", age, "岁")
    }
}
