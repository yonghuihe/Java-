window.onload = function() {
	var ele = document.getElementById("id")
	console.log(ele);
	console.log(ele.innerHTML);
	console.log(ele.innerText);
	
	var byName = document.getElementsByName("name");
	console.log(byName);
	console.log(byName[1]);
	console.log(byName[1].value);
	
	var byTagName=document.getElementsByTagName("div");
	console.log(byTagName);
	console.log(byTagName[0]);
	console.log(byTagName[0].innerText);
}