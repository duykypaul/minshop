$(document).ready(function () {
    $("#btn-login").click(function () {
        var email = $("#email").val();
        var password = $("#password").val();
        $.ajax({
            url: "/minshop/api/CheckLogin",
            data: {
                email: email,
                password: password
            },
            success: function (value) {
                if (value == "true") {
                    currentPath = window.location.href;
                    window.location = currentPath.replace("dangnhap/", "");
                } else {
                    $("#status_login").html("Đăng nhập thất bại!");
                }

            },
            error: function (value) {
                $("#status_login").html("fail!");
            }
        })
    });

    $("#header-login").click(function () {
        $(this).addClass("actived");
        $("#header-signup").removeClass("actived");
        $(".form-login").show();
        $(".form-signup").hide();
    });

    $("#header-signup").click(function () {
        $(this).addClass("actived");
        $("#header-login").removeClass("actived");
        $(".form-login").hide();
        $(".form-signup").show();
    });


    $(".btn-shopping-cart").click(function () {
        var product_id = $(this).closest("tr").attr("data-product-id");
        var product_name = $("#product_name").attr("data-product-name");
        var product_color_id = $(this).closest("tr").find(".color").attr("data-color-id");
        var color_name = $(this).closest("tr").find(".color").text();
        var product_size_id = $(this).closest("tr").find(".size").attr("data-size-id");
        var size_name = $(this).closest("tr").find(".size").text();
        var price = $("#product_price").attr("data-product-price");
        var quantity = $(this).closest("tr").find(".quantity").attr("data-quantity");
        $.ajax({
            url: "/minshop/api/AddToCart",
            data: {
                product_id: product_id,
                product_name: product_name,
                product_color_id: product_color_id,
                color_name: color_name,
                product_size_id: product_size_id,
                size_name: size_name,
                price: price,
                quantity: quantity
            },
            success: function (value) {

            },
            error: function (value) {

            }
        })
    });
})