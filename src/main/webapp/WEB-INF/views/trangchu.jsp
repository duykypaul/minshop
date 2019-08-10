<%@page import="java.util.List"%>
<%@page import="com.duykypaul.entity.NhanVien"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<% List<NhanVien> list = (List<NhanVien>) request.getAttribute("listnhanvien");
	for(NhanVien nv : list){
%>
	<%= nv.getTenNhanVien() + " " + nv.getTuoi() %><br/>
<%} %>
<a href="chitiet?id=2&tensp=abc" >chi tiet</a>
</body>
</html>