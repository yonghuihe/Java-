$(function(){
	$("#win").window({
		width:300,
		height:200,
		modal:false,
		title:'My Window',
		draggable:true,
		resizable:true,
		shadow:true
	})
	$("#win").window("open")
	console.log($("#win").window)
})