$(function(){
	$("#MyDataGrid").datagrid({
		fit:true,
		url:'data.json',
		fitColumns:true,
		resizeHandle:"right",
		striped:true,
		nowrap:false,
		pagination:true,
		rownumbers:true,
		singleSelect:true,
		checkOnSelect:true,
		//pageSize:2,
		//pageList:[1,2,3,4,5],
		showHeader:true,
		frozenColumns:[[
		                {field:'id',checkbox:true},
		                {field:'productid',title:'商品ID',width:100},
		                {field:'productname',title:'商品名称',width:100},
		]],
		columns:[[
		          {field:'unitcost',title:'unitcost',width:1,sortable:true,formatter:function(value,row,index){
		        	  if(value < 15){
		        		  return "<font color='red'>"+value+"</font>";
		        	  }
		        	  return value;
		          }},
		          {field:'status',title:'状态',width:1,resizable:"false"},
		          {field:'listprice',title:'listprice',width:1,order:'desc'},
		          {field:'attr1',title:'属性',width:1},
		          {field:'dept',title:'部门',width:1,formatter:function(value,row,index){
		        	  if(value){
		        		  return value.name
		        	  }
		        	  return "";
		          }},
		          {field:'itemid',title:'itemid',width:1,hidden:"true"}
		]],
		toolbar:"#MyToolbar"
	})
})