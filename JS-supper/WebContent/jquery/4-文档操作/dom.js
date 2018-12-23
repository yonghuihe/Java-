//内部插入
$(function() {
	$("#append").click(function() {
		// append(content) 父.append(子)作为小弟
		// $("#div1").append($("#span"));
		$("div").append($("#span"));
	});
	$("#appendTo").click(function() {
		// appendTo 子.appendTo(父)
		// $("#span").appendTo($("#div1"));
		// $("#span").appendTo($("div"));
		$("#span").appendTo("div");
	});
	$("#prepend").click(function() {
		// prepend(content) 父.append(子)作为大哥
		// $("#div1").prepend($("#span"));
		$("div").prepend($("#span"));
	});
	$("#prependTo").click(function() {
		// prependTo(content) 子.appendTo(父)
		// $("#span").prependTo("#div1");
		$("#span").prependTo("div");
	});
});

// 外部插入
$(function() {
	$("#after").click(function() {
		// 在匹配的元素之后插入内容
		$("#ul").after($("#span"));
	});
	$("#before").click(function() {
		// 在匹配的元素之前插入内容
		$("#ul").before($("#span"));
	});
	$("#insertAfter").click(function() {
		// 把内容插入到匹配的元素之后
		$("#span").insertAfter($("#ul"));
	});
	$("#insertBefore").click(function() {
		// 把内容插入到匹配的元素之前
		$("span").insertBefore("#ul");
		// $("span").insertBefore("ul");
	});
});

// 删除节点
$(function() {
	$("#empty").click(function() {
		// 删除所有子节点
		// $("#ul").empty();
		$("#ul").html("");
	});
	$("#remove").click(function() {
		// 删除选中的节点
		// var btn= $("#btn").remove();//删除之后的节点没有点击事件
		var btn = $("#btn").detach();// 删除之后的节点有点击事件
		$("#ul").append(btn);
	});
});

// 克隆/替换节点
$(function() {
	$("#btn").click(function() {
		alert("克隆按钮");
	});

	$("#clone").click(function() {
		// 克隆节点
		//var clone = $("#btn").clone();
		var clone = $("#btn").clone(true);//加参数后，克隆的元素事件会保留
		$("#ul").append(clone);
	});
	$("#replaceWith").click(function() {
		// $(源).replaceWith(目标)
		$("input").replaceWith("<a>旺财<a>");
	});
	$("#replaceAll").click(function() {
		// $(目标).replaceAll(源)
		$("<a>旺财<a>").replaceAll("input");
	});
});

// 属性操作
$(function() {
	$("#getAttr").click(function() {
		// jQuery中查询只查询第一个对象的值
		//console.log($("input").prop("value"));//获取的是第一个值
		/*$("input").prop("value",function(i,val){//使用函数查询出所有的值
			console.log(i,val);
		})*/
	});
	$("#setAttr").click(function() {
		// jQuery中设置值则是操作所有匹配的元素
		//$("input").prop("value","亲，你好！");//修改了所有匹配的元素
		$("input").prop("value",function(i,val){	//在所有匹配的元素的值上进行修改
			return "亲："+val;
		})
	});
});

// CSS操作
$(function() {
	$("#addClass").click(function() {
		// 给元素添加样式
		$("input").addClass("myBtn");
		$("input").addClass("other");
	});
	$("#removeClass").click(function() {
		// 删除元素样式
		$("input").removeClass("myBtn");
	});
	$("#toggleClass").click(function() {
		// 切换元素样式
		$("input").toggleClass();
	});
	$("#hasClass").click(function() {
		// 判断是否有某样式
		console.log($("input").hasClass("myBtn"));;
	});
});