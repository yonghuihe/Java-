$(function() {
	$("#addMore").click(function() {
		var c = $("#data tr:first").clone();
		c.find(":text").prop("value", 0);
		c.appendTo("#data")

	})
})