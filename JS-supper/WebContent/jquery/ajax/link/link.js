$(function(){
	var url = "/ajax/link_getProvice";
	$.get(url,function(backData){
		$.each(backData,function(i,json){
			var op = "<option value='"+json.id+"'>"+json.name+"</option>"
			$(op).appendTo($("#province"));
		})
	});
	
	$("#province").change(function(){
		$("#city").html("<option value=\"-1\">---请选择城市---</option>");
		if(this.value < 0){
			return;
		}
		
		url = "/ajax/link_getCityById";
		var data = {pid:this.value};
		$.post(url,data,function(backData){
			$.each(backData,function(i,json){
				var op = "<option value='"+json.id+"'>"+json.name+"</option>";
				$(op).appendTo($("#city"));
			})
		},"json")
	});
	
})