<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>json交互测试</title>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/js/jquery-1.4.4.min.js"></script>
<script type="text/javascript">
	function responseJson() {
		$.ajax({
			url : '${pageContext.request.contextPath }/responseJson.do',
			type : 'post',
			// 			contentType:'',
			data : 'name=zhangsan&price=999',
			success : function(data) {
				alert(data.name);
			}
		});
	}
	function requestJson() {
		$.ajax({
			url : '${pageContext.request.contextPath }/requestJson.do',
			type : 'post',
			contentType : 'application/json',
			data : '{"name":"zhangsan","price":999}',
			success : function(data) {
				alert(data.name);
			}
		});
	}
</script>
</head>
<body>
	<input type="button" value="请求是key/value返回是json"
		onclick="responseJson()">
	<input type="button" value="请求是json返回是json" onclick="requestJson()">
</body>
</html>