window.onload = function() {
	var byId=document.getElementById("id");
	/*console.log(byId);
	console.log(byId.hasChildNodes());
	console.log(byId.firstChild.nextSibling);
	console.log(byId.lastChild.previousSibling);*/
	
	//元素
//	console.log(byId.nodeName);	//DIV
//	console.log(byId.nodeValue);//null
//	console.log(byId.nodeType);	//1
	//属性
//	console.log(byId.getAttributeNode("id").nodeName);	//id
//	console.log(byId.getAttributeNode("id").nodeValue);	//id
//	console.log(byId.getAttributeNode("id").nodeType);	//2
	//方法
	console.log(byId.firstChild.nodeName);	//#text
	console.log(byId.firstChild.nodeValue);	//文本内容
	console.log(byId.firstChild.nodeType);	//3
}