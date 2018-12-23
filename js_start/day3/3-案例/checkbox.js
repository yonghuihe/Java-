window.onload = function () {
      document.getElementById("checkAll").onclick = function () {
          checkAll(this.checked);
      };
};

// 全选/全不选
function checkAll(checked) {
    var boxes = document.getElementsByName("hobby");
    for (var i = 0; i < boxes.length; i++) {
        boxes[i].checked = checked;
    }
}

// 反选
function checkUnAll() {
    var boxes = document.getElementsByName("hobby");
    for (var i = 0; i < boxes.length; i++) {
        boxes[i].checked = !boxes[i].checked;
    }
}
