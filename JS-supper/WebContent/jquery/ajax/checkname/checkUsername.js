$(function() {
	$("#checkUsername").blur(function() {
		
		var data = {
			username : this.value
		};
		$.get("/ajax/checkUsername", data, function(backData) {
			if (backData.success){
				$("#showMag").css("color","green");
			} else {
				$("#showMag").css("color","red");
			}
			$("#showMag").html(backData.msg);
		}, "json")
	})
})