$(document).ready(function() {
	$("#btn-login").click(function() {
		var email = $("#email").val();
		var password = $("#password").val();
		$.ajax({
			url : "/minshop/api/CheckLogin",
			data : {
				email : email,
				password : password
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
				$("#status_login").html("fail!");
			}
		})
	});
	
	$("#header-login").click(function() {
		$(this).addClass("actived");
		$("#header-signup" ).removeClass("actived");
		$(".form-login").show();
		$(".form-signup").hide();
	});
	
	$("#header-signup").click(function() {
		$(this).addClass("actived");
		$("#header-login" ).removeClass("actived");
		$(".form-login").hide();
		$(".form-signup").show();
	})
	
})