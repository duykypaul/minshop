<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	trang Chi tiet <br />
	${user.getFull_name() }
	${user.getAddress() }
	${user.getOld() }
</body>
</html>