function moveAll(srcId,targetId){
	$("#"+srcId+" option").appendTo($("#"+targetId+""));
}
function moveSelected(srcId,targetId){
	$("#"+srcId+" option:selected").appendTo($("#"+targetId+""));
}
