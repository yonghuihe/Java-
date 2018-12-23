//全选/全不选
window.onload = function() {
	var ele = document.getElementById("checkAll");
	ele.onclick = function(){
		checkAll(ele.checked);
	}
}
//全选/全不选
function checkAll(checked) {
	var all = document.getElementsByName("hobby");
	for (var i = 0; i < all.length; i++) {
		all[i].checked = checked;
	}
}
//反选
function checkUnAll() {
	var all = document.getElementsByName("hobby");
	for (var i = 0; i < all.length; i++) {
		all[i].checked = !all[i].checked;
	}
}