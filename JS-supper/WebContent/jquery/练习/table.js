$(function(){
	$("#btn_submit").click(function(){
		var usernameVal = $("input:text")[0].value;
		var emailVal = $("input:text")[1].value;
		var telVal = $("input:text")[2].value;
		console.log(usernameVal,emailVal,telVal);
		
		var tr = "<tr>" +
					"<td>"+usernameVal+"</td>" +
					"<td>"+emailVal+"</td>" +
					"<td>"+telVal+"</td>" +
					"<td><a href=\"javascript:\" onclick=\"delRow(this);\">删除</a></td>" +
				"</tr>";
		$(tr).appendTo("#data")
	})
	$("#btn_removeAll").click(function(){
//		$("#data").empty();
		$("#data").html("");
	})
})

function delRow(src){
	$(src).parents("tr").html("");
}