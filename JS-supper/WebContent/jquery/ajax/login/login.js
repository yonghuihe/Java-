$(function(){
	$("#btn").click(function(){
		console.log();
		console.log();
		var url = "/ajax/login";
		var data = {username:$("input:text").val(),password:$("input:password").val()};
		$.post(url,data,function(backData){
			if(backData.success){
				location.href="http://www.baidu.com";
			} else {
				$("span").html(backData.msg).css("color","red");
			}
		},"json")
	})
})