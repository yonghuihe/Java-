$(function(){
	$("img").bind({
		"mouseover":function(){
			this.src = "1.jpg"
				console.log(this.src)
		},
		"mouseout":function(){
			this.src = "0.jpg"
				console.log(this.src)
		}
	})
})