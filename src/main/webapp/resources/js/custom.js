$(document).ready(function() {
	$("#login").click(function() {
		var email = $("#email").val();
		var password = $("#password").val();
		$.ajax({
			url : "/minshop/api/KiemTraDangNhap",
			data : {
				email : email,
				matkhau : password
			},
			success : function(value) {
				if (value == "true") {
					currentPath = window.location.href;
					window.location = currentPath.replace("dangnhap/", "");
				} else {
					$("#status_login").html("Đăng nhập thất bại!");
				}

			},
			error : function(value) {
				alert("fail!");
				$("#status_login").html("fail!");
			}
		})
	});
})