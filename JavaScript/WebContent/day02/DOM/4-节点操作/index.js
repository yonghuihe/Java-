window.onload = function() {
	
}
//追加节点
/*function spanApendDiv(){
	var div = document.getElementById("div");
	var span = document.getElementById("span");
	div.appendChild(span)
}
function crateSpanApendDiv(){
	var div = document.getElementById("div");
	var span=document.createElement("span");
	span.innerHTML = "newSpan";
	span.style.backgroundColor = "green";
	console.log(span.innerHTML);
	div.appendChild(span)
}*/

//在指定节点之前插入新的节点
function insertNode2BeforeNode3(){
	var newOption=document.getElementById("item2")
	//判断：如果节点2已经存在，则不需要插入节点2
	if(!newOption){
		//得到节点3
		var item3 =document.getElementById("item3")
		//创建节点2
		newOption=document.createElement("option")
		newOption.id = "item2";
		newOption.innerHTML = "节点2";
		//将newOption插入到item3前
		item3.parentNode.insertBefore(newOption, item3);
	}
}

//在节点1后插入节点2-->在节点3前插入节点2
function insertNode2AfterNode1(){
	var newOption=document.getElementById("item2")
	//判断：如果节点2已经存在，则不需要插入节点2
	if(!newOption){
		//得到节点1的下一个节点
		var item1=document.getElementById("item1");
		//创建节点2
		newOption=document.createElement("option")
		newOption.id = "item2";
		newOption.innerHTML = "节点2";
		item1.parentNode.removeChild(oldChild)
		insertAfter(newOption,item1);
	}
}

//在refNode前插入newNode
function insertAfter(newNode,refNode){
	if(refNode.nextSibling){
		refNode.nextSibling.c.insertBefore(newNode, refNode.nextSibling);
	} else {
		refNode.nextSibling.parentNode.appendChild(newNode);
	}
}

//删除节点1
function removeNode1(){
	//获取节点1
	var itme1=document.getElementById("item1");
	if (itme1){
		//节点1的老爸删除节点1
		item1.parentNode.removeChild(item1);
	}
}

//把节点3替换为节点8
function replaceNode3ToNode8(){
	//得到节点3
	var item3=document.getElementById("item3");
	if (item3){
		//方式1：把节点3中的内容换成节点8
//		item3.innerHTML = "节点8";
//		item3.id = "itme8";
		//方式2：新建一个节点8，让节点3的老爸把节点3换成节点8
		var newItem=document.createElement("option");
		newItem.id = "item8";
		newItem.innerHTML = "节点8";
		item3.parentNode.replaceChild(newItem, item3);
	}
}
