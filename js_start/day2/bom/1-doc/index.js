//在文档加载完毕之后执行的操作
window.onload = function () {
    //获取页面中的链接
    console.log(window.document.links);
    console.log(window.document.links[1]);
    console.log(window.document.links[1].innerHTML);
    //获取页面中的表单
    console.log(document.forms);
    console.log(document.forms[0]);

    console.log(document.form2);
};
