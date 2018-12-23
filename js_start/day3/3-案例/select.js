//移动所有元素
function moveAll(srcId, targetId) {
    var src = document.getElementById(srcId);
    var target = document.getElementById(targetId);

    while (src.hasChildNodes()) {
        target.appendChild(src.firstChild);
    }
}

//移动选中的元素
function moveSelected(srcId, targetId) {
    var src = document.getElementById(srcId);
    var target = document.getElementById(targetId);

    var opts = src.getElementsByTagName("option");
    for (var i = opts.length - 1; i > -1; i--) {
        if (opts[i].selected) {
            target.appendChild(opts[i]);
        }
    }
}
