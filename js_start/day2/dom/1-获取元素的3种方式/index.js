//文档加载完毕后执行
window.onload = function () {
    //getElementById() 返回对拥有指定id的第一个对象的引用
    var d1 = document.getElementById("d1");
    console.log(d1.innerHTML)
    console.log(d1.innerText)

    //getElementsByName() 返回带有指定名称的对象伪数组
    var inputs = document.getElementsByName("hobby");
    //获取索引为1的对象
    console.log(inputs[1]);
    console.log(inputs[1].value);

    //getElementsByTagName() 返回带有指定标签名的对象集合
    var divs = document.getElementsByTagName("div");
    console.log(divs);
};

