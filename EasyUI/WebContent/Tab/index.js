$(function(){
	$("#MyTab").tabs({
		width:500,
		height:600,
		plain:false,
		fit:false,
		border:true,
		tabPosition:'top',
		headerWidth:50,
		tools:"#tool"
	})
})
//添加选项卡
function add(){
	$("#MyTab").tabs("add",{
		title:"新选项卡面板",
		selected:true,
		closable:true,
		content:"选项卡内容"
	})
}
//关闭选项卡
function remove(){
	//1、获取选中的选项卡
	var tab = $("#MyTab").tabs("getSelected");
	//2、获取选项卡的索引
	var index = $("#MyTab").tabs("getTabIndex",tab)
	//3、关闭它
	$("#MyTab").tabs("close",index)
}