<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>alert</title>
</head>
<body>
	<script type="text/javascript">
		var message = "${msg}";
		alert(message);
		window.history.back();
	</script>
</body>
</html>
<!-- 이전에 작성한 내용을 그대로 보관함 -->