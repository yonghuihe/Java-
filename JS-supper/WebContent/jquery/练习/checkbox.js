function checkAll(checked){
	$("[name=hobby]").prop("checked",checked);
}
function checkUnAll(){
	$("[name=hobby]").prop("checked",function(i,value){
		return !value;
	});
}
$(function(){
	$("#checkAll").click(function(){
		checkAll(this.checked);
	})
})