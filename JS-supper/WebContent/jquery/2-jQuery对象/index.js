window.onload = function() {
	var jsDiv = document.getElementById("msg");
	console.log(jsDiv);
	console.log(jsDiv.innerHTML);
	// DOM-->jQuery
	console.log($(jsDiv));
}
$(function() {
	console.log($("#msg"))
	console.log($("#msg").html())
	//jQuery-->DOM
	console.log($("#msg")[0]);
	console.log($("#msg").get(0));
	//window.jQuery = window.$ = jQuery
	console.log($===jQuery)//true
	console.log(jQuery("#msg").get(0));
});
