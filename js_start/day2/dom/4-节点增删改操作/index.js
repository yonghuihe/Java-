//把span移动到div中
function move2Div() {
    var sp = document.getElementById("sp");
    var div = document.getElementById("d1");
    //把sp对象加入到div中作为子节点
    div.appendChild(sp);
}

//创建span元素加入到divz中
function createSpan2Div() {
    //创建元素
    var sp = document.createElement("span");//<span></span>
    sp.style.color = "red";
    sp.innerHTML = "新建的span";             //<span>新建的span</span>
    var div = document.getElementById("d1");
    //把sp对象加入到div中作为子节点
    div.appendChild(sp);
}

//在item4前插入item3
function insertItem3BeforeItem4() {
    var opt = document.getElementById("item3");
    if (!opt) {
        //创建item3对象
        opt = document.createElement("option");
        opt.id = "item3";
        opt.innerHTML = "item3";
        //获取到item4对象
        var item4 = document.getElementById("item4");
        item4.parentNode.insertBefore(opt, item4);
    }
}

//在item2后插入item3
function insertItem3AfterItem2() {
    var opt = document.getElementById("item3");
    if (!opt) {
        //创建item3对象
        opt = document.createElement("option");
        opt.id = "item3";
        opt.innerHTML = "item3";
        //获取到item4对象
        var item2 = document.getElementById("item2");
        insertAfter(opt, item2);
    }
}

function insertAfter(newNode, refNode) {
    if (refNode.nextSibling) {
        refNode.parentNode.insertBefore(newNode, refNode.nextSibling);
    } else {
        //refNode是最后一个节点
        refNode.parentNode.appendChild(newNode);
    }
}

//删除item1
function deleteItem1() {
    var item1 = document.getElementById("item1");
    if (item1) {
        item1.parentNode.removeChild(item1);
    }
}

//把item5替换成item8
function changeItem5ToItem8() {
    var item5 = document.getElementById("item5");
    if (item5) {
        var item8 = document.createElement("option");
        item8.id = "item8";
        item8.innerHTML = "item8";

        item5.parentNode.replaceChild(item8, item5);
    }
}