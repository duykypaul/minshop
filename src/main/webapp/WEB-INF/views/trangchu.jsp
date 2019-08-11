<%@page import="java.util.List"%>
<%@page import="com.duykypaul.entity.NhanVien"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="resources/styles.css" >
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<a id="test" href="chitiet" >chi tiet</a>
<form method="post" action="chitiet">
	<input type="text" name="tenNhanVien"/>
	<input type="text" name="diaChi"/>
	<input type="text" name="tuoi"/>
	<input type="submit" value="post du lieu"/>
</form>
</body>
</html>