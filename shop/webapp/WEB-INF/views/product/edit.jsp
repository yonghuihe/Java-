<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8"/>
<title>Insert title here</title>
</head>
<body>
	<form action="/product?cmd=save" method="post">
		<input type="hidden" name="id" value="${product.id}"/>
		商品名称:<input type="text" name="productName" value="${product.productName}" required/><br/>
		零售价:<input type="number" name="salePrice" value="${product.salePrice}" required/><br/>
		商品分类:<select name="dir_id">
				<option value="">---选择分类---</option>
				<option ${product.dir_id == 2?'selected':''} value="2">无线鼠标</option>
				<option ${product.dir_id == 3?'selected':''} value="3">有线鼠标</option>
				<option ${product.dir_id == 4?'selected':''} value="4">游戏鼠标</option>
			</select><br/>
		供应商:<input type="text" name="supplier" value="${product.supplier}" required/><br/>
		品牌:<input type="text" name="brand" value="${product.brand}" required/><br/>
		折扣:<input type="text" name="cutoff" value="${product.cutoff}" required/><br/>
		成本价:<input type="number" name="costPrice" value="${product.costPrice}" required/><br/>
		<br/>
		<input type="submit" value="${empty product ? '保存' : '更新'}"/>
	</form>
</body>
</html>