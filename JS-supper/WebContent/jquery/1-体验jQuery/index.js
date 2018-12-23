//js方式
changeByJs = function() {
	var div1 = document.getElementById("div1");
	console.log(div1.innerHTML);
	div1.innerHTML = "js方式修改了值";
}
//jQuery方式
changeByJq = function() {
	console.log($("#div2").html());
	$("#div2").html("jq方式修改了值");
}

//js方式
window.onload = function() {
	var debug1 = document.getElementById("debug1");
	var msg = document.getElementById("msg");
	debug1.onclick = function() {
		if (msg.style.display == "none") {
			msg.style.display = "block";
		} else {
			msg.style.display = "none";
		}
	}
}
//jQuery方式
$(function(){
	$("#debug2").click(function() {
		$("#msg").toggle(1500);
	})
})