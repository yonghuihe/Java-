//文档加载完毕后执行
window.onload = function () {
    var tx = document.getElementById("tx");
    //操作readOnly属性
    console.log(tx.readOnly);
};
/*
var tx = document.getElementById("tx");
//操作对象的属性
//原始属性 直接使用 对象.属性
console.log(tx.name);
//console.log(tx["name"]);

tx.name = "age";
//tx["name"] = "age";

//操作自定义属性 只能使用方法来完成
var val = tx.getAttribute("xy");
console.log(val)
tx.setAttribute("xy", "bunny");

 var check = document.getElementById("check");
 //操作属性名和属性值相同的属性,使用boolean类型来赋值
 check.checked = true;

 var div = document.getElementById("d1");
 //操作class属性,属性名称叫className
 console.log(div.className);

 div.className = "";

 //操作普通名称的属性
 console.log(div.style.color);
 div.style.color = "red";

 //操作带有-号的属性,如:background-color,使用驼峰表示法
 //console.log(div.style["background-color"]);
 console.log(div.style.backgroundColor);
 console.log(div.style.fontSize);
*/

