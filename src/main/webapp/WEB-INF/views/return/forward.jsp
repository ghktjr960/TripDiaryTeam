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
		var url = "${url}";
		document.location.href = url+${authInfo.memberNum};
	</script>
</body>
</html>
<!-- 그냥 페이지만 넘겨줌 -->