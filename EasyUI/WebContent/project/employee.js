$(function(){
	$("#MyDataGrid").datagrid({
		fit:true,
		fitColumns:true,
		singleSelect:false,
		url:"employee.json",
		rownumbers:true,
		columns:[[
		          {field:'id',checkbox:true},
		          {field:'name',title:'姓名',width:1},
		          {field:'age',title:'年龄',width:1},
		          {field:'inputTime',title:'入职时间',width:1},
		          {field:'dept',title:'部门',width:1,formatter:function(value,row,index){
		        	  return value?value.name:"";
		          }},
		          {field:'status',title:'状态',width:1,formatter:function(value,row,index){
		        	  return value== "true"?"<font color='red'>离职</font>":"<font color='green'>在职</font>";
		          }}
		]],
		toolbar:"#MyToolbar",
		striped:true,
		pagination:true
	})
	$("#MyDialog").dialog({
		width: 400,    
	    height: 350,
	    closed:true,
		buttons:"#MyButton"
	})
})
function add(){
	//清空表单
	$("#MyForm").form("clear");
	//设置标题
	$("#MyDialog").dialog("setTitle","新增员工");
	$("#MyDialog").dialog("open");
}
function edit(){
	//清空表单
	$("#MyForm").form("clear");
	//设置标题
	$("#MyDialog").dialog("setTitle","编辑员工");
	//如果选中了一条数据，弹出编辑框
	var selected =$("#MyDataGrid").datagrid("getSelected");
	if(!selected){
		$.messager.alert("温馨提示","请选中一条数据","error");
		return;
	}
	if(selected){
		$("#MyDialog").dialog("open");//打开弹出框
		//处理部门数据（根据同名匹配的原则，表单：name=dept.id,这里也需要使用dept.id
		if(selected.dept){//如果部门不为空
			selected["dept.id"] = selected.dept.id;
		}
		//处理状态：如果使用easyui1.3版本需要处理
//		selected["status"] = selected["selected"]+"";
		$("#MyForm").form("load",selected);//数据回显
	}
}
function remove(){
	//删除多条数据
	var deletedData =$("#MyDataGrid").datagrid("getChecked");
	if(deletedData.length == 0){
		$.messager.alert("温馨提示","请勾选要删除的数据","error");
		return;
	}
	for (var i = deletedData.length - 1; i >= 0; i--) {
		  var rowIndex = $('#MyDataGrid').datagrid('getRowIndex', deletedData[i]);
		  $('#MyDataGrid').datagrid('deleteRow', rowIndex);
	}
	//删除单条数据
	/*//如果选中了一条数据，弹出编辑框
	var selected =$("#MyDataGrid").datagrid("getSelected");
	if(!selected){
		$.messager.alert("温馨提示","请选中一条数据","error");
		return;
	}
	var rowIndex = $('#MyDataGrid').datagrid('getRowIndex', selected);
	$("#MyDataGrid").datagrid("deleteRow",rowIndex);*/
}
function reload(){
	$("#MyDataGrid").datagrid("load");
}
function MySearch(){
	var data =$("input[name='queryObject.keywords']").val();
	$("#MyDataGrid").datagrid("load",{
		'queryObject.keywords':data
	});
}

function save(){
	//判断是新增还是编辑
	var id =$("#MyForm [name='id']").val();
	var url = null;
	if(id){
		url = "employee_update.json"
	}else{
		url = "employee_save.json"
	}
	
	//保存失败停留当前编辑页面
	$('#MyForm').form("submit",{    
	    url:url,//模拟后台发送过来的json数据 
	    success:function(data){
	    	//将json字符串转化为json数组
	    	data = $.parseJSON(data);
	    	if(data.success == "false"){
	    		$.messager.alert('温馨提示',data.msg,'error');  
	    	}else{
	    		$.messager.alert('温馨提示',data.msg,'info',function(){
	    			//保存成功刷新当前页面（datagrid页面）
	    			$("#MyDialog").dialog("close");//关闭对话框
	    			$("#MyDataGrid").datagrid("reload");//重新加载页面
	    		})
	    	}
	    }    
	});  
}
function cancel(){
	$("#MyDialog").dialog("close");
}