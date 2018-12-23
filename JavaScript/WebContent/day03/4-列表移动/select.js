function moveAll(srcId, targetId) {
	var src = document.getElementById(srcId);
	var target = document.getElementById(targetId);
	while (src.hasChildNodes()) {
		target.appendChild(src.firstChild);
	}
}
function moveSelected(srcId, targetId) {
	var src = document.getElementById(srcId);
	var target = document.getElementById(targetId);
	var options = src.getElementsByTagName("option");
	for (var i = options.length - 1; i > -1; i--) {
		if (options[i].selected) {
			target.appendChild(options[i])
		}
	}
}
