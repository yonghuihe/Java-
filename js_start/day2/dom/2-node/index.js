//文档加载完毕后执行
window.onload = function () {
    var div = document.getElementById("d1");
   /* //1.常用属性和方法
    //hasChildNodes() 判断当前节点是否有子节点
    console.log(div.hasChildNodes());
    //childNodes 获取当前节点的所有子节点
    console.log(div.childNodes);
    //firstChild 获取当前节点的第一个子节点
    console.log(div.firstChild);
    //lastChild 获取当前节点的第一个子节点
    console.log(div.lastChild);
    //previousSibling 获取当前节点的上一个兄弟
    console.log(div.lastChild.previousSibling);
    //nextSibling 获取当前节点的下一个兄弟
    console.log(div.firstChild.nextSibling);*/

    //nodeName/nodeValue/nodeType的区别
    //元素
    console.log(div.nodeName); //DIV
    console.log(div.nodeValue);//null
    console.log(div.nodeType); //1
    //属性
    console.log(div.getAttributeNode("id").nodeName); //id
    console.log(div.getAttributeNode("id").nodeValue);//d1
    console.log(div.getAttributeNode("id").nodeType); //2
    //文本
    console.log(div.firstChild.nodeName); //#text
    console.log(div.firstChild.nodeValue);//文本的值
    console.log(div.firstChild.nodeType); //3
};

